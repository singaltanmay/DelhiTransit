package com.example.delhitransit.activities;

import android.app.Service;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;

import com.example.delhitransit.database.DynamicDbHelper;
import com.example.delhitransit.database.StaticDbHelper;
import com.example.delhitransit.BusPositionUpdate;
import com.example.delhitransit.GtfsRealtime;
import com.example.delhitransit.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static com.example.delhitransit.database.StaticDbHelper.COLUMN_NAME_ARRIVAL_TIME;
import static com.example.delhitransit.database.StaticDbHelper.COLUMN_NAME_DEPARTURE_TIME;
import static com.example.delhitransit.database.StaticDbHelper.COLUMN_NAME_ROUTE_ID;
import static com.example.delhitransit.database.StaticDbHelper.COLUMN_NAME_SERVICE_ID;
import static com.example.delhitransit.database.StaticDbHelper.COLUMN_NAME_STOP_CODE;
import static com.example.delhitransit.database.StaticDbHelper.COLUMN_NAME_STOP_ID;
import static com.example.delhitransit.database.StaticDbHelper.COLUMN_NAME_STOP_LATITUDE;
import static com.example.delhitransit.database.StaticDbHelper.COLUMN_NAME_STOP_LONGITUDE;
import static com.example.delhitransit.database.StaticDbHelper.COLUMN_NAME_STOP_NAME;
import static com.example.delhitransit.database.StaticDbHelper.COLUMN_NAME_STOP_SEQUENCE;
import static com.example.delhitransit.database.StaticDbHelper.COLUMN_NAME_TRIP_ID;

public class AppService extends Service {


    private static final String DATABASE_SHARED_PREF_KEY = "staticDB";
    private static final String TABLE_STOPS_INITIALIZED = "stops_table_init";
    private static final String TABLE_ROUTES_INITIALIZED = "routes_table_init";
    private static final String TABLE_TRIPS_INITIALIZED = "trips_table_init";
    private static final String TABLE_STOP_TIMES_INITIALIZED = "stop_times_init";


    private static final String LOG_TAG = AppService.class.getSimpleName();
    private static Context context;
    private static ContentResolver resolver;

    public AppService() {
        Log.d(LOG_TAG, "Service constructed");
        context = this;
    }

    @Override
    public void onCreate() {
        resolver = context.getContentResolver();
        DatabaseInitializer initializer = new DatabaseInitializer();
        initializer.checkDatabaseIntegrity();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    public static AppService getInstance() {
        if (context != null) return (AppService) context;
        else {
            AppService service = new AppService();
            return service;
        }
    }

    // Initiates web update and delegates all related tasks
    public List<BusPositionUpdate> fetchAllPosition(final Context context) {

        final List<BusPositionUpdate> positionList = new ArrayList<>();

        // Get the latest update from server
        List<GtfsRealtime.FeedEntity> feedEntities = fetchUpdateFromServer();

        // Parses list element into a POJO and adds it to another positionList
        for (GtfsRealtime.FeedEntity entity : feedEntities) {
            positionList.add(new BusPositionUpdate().parseFrom(entity));
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // Update database with new information
                updatePositionDatabase(positionList);
            }
        });


        thread.start();

        // Return list for displaying in GUI
        return positionList;
    }

    // Makes a HTTP request and returns the latest update in a list
    private List<GtfsRealtime.FeedEntity> fetchUpdateFromServer() {

        List<GtfsRealtime.FeedEntity> feedEntityList = null;
        String urlString = "https://otd.delhi.gov.in/api/realtime/VehiclePositions.pb?key=ObnMpq02enRlNc8m2iuOnR97GLnfKQUj";

        try {

            URL url = new URL(urlString);
            InputStream inputStream = null;

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200) {

                Log.d(LOG_TAG, "Connected to server " + urlConnection.getResponseMessage());

                inputStream = urlConnection.getInputStream();

                GtfsRealtime.FeedMessage feedMessage = GtfsRealtime.FeedMessage.parseFrom(inputStream);
                feedEntityList = feedMessage.getEntityList();

                Log.d(LOG_TAG, "List Size : " + feedEntityList.size());

            } else
                Log.e(LOG_TAG, "Error connecting to server. Response code : " + urlConnection.getResponseCode());

            if (inputStream != null) {
                inputStream.close();
            }
            urlConnection.disconnect();

        } catch (
                Exception e) {
            Log.e(LOG_TAG, e.toString());
        }

        return feedEntityList;
    }

    // Updates the database with new information
    private void updatePositionDatabase(List<BusPositionUpdate> list) {


        String columnNameVehicleId = DynamicDbHelper.COLUMN_NAME_VEHICLE_ID;
        String columnNameTripId = DynamicDbHelper.COLUMN_NAME_TRIP_ID;
        String columnNameRouteId = DynamicDbHelper.COLUMN_NAME_ROUTE_ID;
        String columnNameVehicleLatitude = DynamicDbHelper.COLUMN_NAME_VEHICLE_LATITUDE;
        String columnNameVehicleLongitude = DynamicDbHelper.COLUMN_NAME_VEHICLE_LONGITUDE;
        String columnNameVehicleSpeed = DynamicDbHelper.COLUMN_NAME_VEHICLE_SPEED;
        String columnNameUpdateTimestamp = DynamicDbHelper.COLUMN_NAME_UPDATE_TIMESTAMP;

        for (BusPositionUpdate position : list) {
            ContentValues values = new ContentValues();
            values.put(columnNameVehicleId, position.getVehicleID());
            values.put(columnNameTripId, position.getTripID());
            values.put(columnNameRouteId, position.getRouteID());
            values.put(columnNameVehicleLatitude, position.getLatitude());
            values.put(columnNameVehicleLongitude, position.getLongitude());
            values.put(columnNameVehicleSpeed, position.getSpeed());
            values.put(columnNameUpdateTimestamp, position.getTimestamp());

            resolver.insert(DynamicDbHelper.Companion.getTABLE_NAME_VEHICLE_POSITION_UPDATE_CONTENT_URI(), values);
        }

    }


    // TODO Find all paths
    public Cursor findAllPaths(String source, String destination) {

        String selection = COLUMN_NAME_STOP_ID + " = ? OR " + COLUMN_NAME_STOP_ID + " = ?;";

        String[] selectionArgs = {source, destination};

        return resolver.query(StaticDbHelper.Companion.getTABLE_NAME_STOP_TIMES_CONTENT_URI(), null, selection, selectionArgs, null, null);

    }

    public Cursor getAllStops() {

        return resolver.query(StaticDbHelper.Companion.getTABLE_NAME_STOPS_CONTENT_URI(), null, null, null, null, null);

    }


    private long convertTimeToEpoch(String timestamp) {
        //TODO actually do stuff
        return 0;
    }

    /* Class responsible for all initialization operation on the
     permanent static data containing tables in the database */
    private class DatabaseInitializer {

        private final String LOG_TAG = DatabaseInitializer.class.getSimpleName();
        private SharedPreferences staticDBPrefs;
        private SharedPreferences.Editor staticDBPrefsEditor;


        // Helper method that checks if a table is to be initialized or not
        private boolean tableHasToBeInitialized(String tableName) {
            return !staticDBPrefs.getBoolean(tableName, false);
        }

        // Helper method to change table initialization flag stored in Shared Preferences
        private void updateInitializationStatus(String TABLE_NAME) {
            staticDBPrefsEditor.putBoolean(TABLE_NAME, true);
            staticDBPrefsEditor.apply();
        }

        private void checkDatabaseIntegrity() {

            // Get SharedPreferences that stores the state of the database
            staticDBPrefs = getSharedPreferences(AppService.DATABASE_SHARED_PREF_KEY, MODE_PRIVATE);
            staticDBPrefsEditor = staticDBPrefs.edit();

            // Checks if tables in the database have already been initialized
            // Initializes tables if not already initialized
            if (tableHasToBeInitialized(TABLE_STOPS_INITIALIZED)) {
                // Create new thread to init table
                final Thread initStops = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        initStopsTable(context);
                    }
                });
                initStops.start();
            }

            if (tableHasToBeInitialized(TABLE_ROUTES_INITIALIZED)) {
                // Create new thread to init table
                Thread initRoutes = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        initRoutesTable(context);
                    }
                });
                initRoutes.start();
            }

            if (tableHasToBeInitialized(TABLE_TRIPS_INITIALIZED)) {
                // Create new thread to init table
                final Thread initTrips = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        initTripsTable(context);
                    }
                });
                initTrips.start();
            }

            if (tableHasToBeInitialized(TABLE_STOP_TIMES_INITIALIZED)) {
                // Create new thread to init table
                final Thread initStopTimes = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        initStopTimesTable(context);
                    }
                });
                initStopTimes.start();
            }

        }

        private void initRoutesTable(Context context) {

            InputStream stream = context.getResources().openRawResource(R.raw.routes);

            InputStreamReader inputStreamReader = new InputStreamReader(stream, StandardCharsets.UTF_8 );

            // Since InputStreamReader can only read one character at a time
            // but a BufferedReader can read a lot more at once it is being used
            // to dramatically improve performance
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // First line of the stream
            //Being skipped as it contains headers and not actual data
            String line = null;
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                Log.e(LOG_TAG, e.toString());
            }

            // Read till end of stream
            while (line != null) {

                // readLine() automatically moves to next line after reading
                try {
                    line = bufferedReader.readLine();

                    //Skip any empty lines
                    if (!TextUtils.isEmpty(line)) {

                        String route_short_name = "";
                        String route_long_name = "";
                        int route_type = -1;
                        int route_id;

                        if (line.contains(",")) {
                            int comma = line.indexOf(',');
                            route_short_name = line.substring(0, comma);
                            line = line.substring(comma + 1);
                        }

                        if (line.contains(",")) {
                            int comma = line.indexOf(',');
                            route_long_name = line.substring(0, comma);
                            line = line.substring(comma + 1);
                        }

                        if (line.contains(",")) {
                            int comma = line.indexOf(',');
                            route_type = Integer.parseInt(line.substring(0, comma));
                            line = line.substring(comma + 1);
                        }

                        route_id = Integer.parseInt(line);

                        ContentValues values = new ContentValues();
                        values.put(StaticDbHelper.COLUMN_NAME_ROUTE_ID, route_id);
                        values.put(StaticDbHelper.COLUMN_NAME_ROUTE_SHORT_NAME, route_short_name);
                        values.put(StaticDbHelper.COLUMN_NAME_ROUTE_LONG_NAME, route_long_name);
                        values.put(StaticDbHelper.COLUMN_NAME_ROUTE_TYPE, route_type);

                        resolver.insert(StaticDbHelper.Companion.getTABLE_NAME_ROUTES_CONTENT_URI(), values);

                    }

                } catch (IOException e) {
                    Log.e(LOG_TAG, e.toString());
                }

            }

            updateInitializationStatus(TABLE_ROUTES_INITIALIZED);
            Log.v(LOG_TAG, "routes table initialized");


        }

        private void initStopsTable(Context context) {

            InputStream stream = context.getResources().openRawResource(R.raw.stops);

            InputStreamReader inputStreamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);

            // Since InputStreamReader can only read one character at a time
            // but a BufferedReader can read a lot more at once it is being used
            // to dramatically improve performance
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // First line of the stream
            //Being skipped as it contains headers and not actual data
            String line = null;
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                Log.e(LOG_TAG, e.toString());
            }

            // Read till end of stream
            while (line != null) {

                // readLine() automatically moves to next line after reading
                try {
                    line = bufferedReader.readLine();

                    //Skip any empty lines
                    if (!TextUtils.isEmpty(line)) {


                        int stop_id = -1;
                        String stop_code = "";
                        String stop_name = "";
                        double stop_lat = -1;
                        double stop_lon = -1;

                        if (line.contains(",")) {
                            int comma = line.indexOf(',');
                            stop_id = Integer.parseInt(line.substring(0, comma));
                            line = line.substring(comma + 1);
                        }

                        if (line.contains(",")) {
                            int comma = line.indexOf(',');
                            stop_code = line.substring(0, comma);
                            line = line.substring(comma + 1);
                        }

                        if (line.contains(",")) {
                            int comma = line.indexOf(',');
                            //TODO implement stack based method to ignore , between ""
                            //TODO restore "Sec-7 / 8 Xing" to "Sec-7,8 Xing" in line 2586

                            stop_name = line.substring(0, comma);
                            line = line.substring(comma + 1);
                        }

                        if (line.contains(",")) {
                            int comma = line.indexOf(',');
                            stop_lat = Double.parseDouble(line.substring(0, comma));
                            line = line.substring(comma + 1);
                        }

                        stop_lon = Double.parseDouble(line);

                        ContentValues values = new ContentValues();
                        values.put(COLUMN_NAME_STOP_ID, stop_id);
                        values.put(COLUMN_NAME_STOP_CODE, stop_code);
                        values.put(COLUMN_NAME_STOP_NAME, stop_name);
                        values.put(COLUMN_NAME_STOP_LATITUDE, stop_lat);
                        values.put(COLUMN_NAME_STOP_LONGITUDE, stop_lon);

                        resolver.insert(StaticDbHelper.Companion.getTABLE_NAME_STOPS_CONTENT_URI(), values);

                    }

                } catch (IOException e) {
                    Log.e(LOG_TAG, e.toString());
                }

            }

            updateInitializationStatus(TABLE_STOPS_INITIALIZED);
            Log.d(LOG_TAG, "stops table initialized.");


        }

        private void initStopTimesTable(Context context) {

            InputStream stream = context.getResources().openRawResource(R.raw.stop_times);

            InputStreamReader inputStreamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);

            // Since InputStreamReader can only read one character at a time
            // but a BufferedReader can read a lot more at once it is being used
            // to dramatically improve performance
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // First line of the stream
            //Being skipped as it contains headers and not actual data
            String line = null;
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                Log.e(LOG_TAG, e.toString());
            }

            // Read till end of stream
            while (line != null) {

                // readLine() automatically moves to next line after reading
                try {
                    line = bufferedReader.readLine();

                    final String xLine = line;

                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {

                            String fLine = xLine;

                            //Skip any empty lines
                            if (!TextUtils.isEmpty(fLine)) {

                                int trip_id = -1;
                                String arrival_time = "";
                                String departure_time = "";
                                long stop_id = -1;
                                int stop_sequence = -1;

                                if (fLine.contains(",")) {
                                    int comma = fLine.indexOf(',');
                                    trip_id = Integer.parseInt(fLine.substring(0, comma));
                                    fLine = fLine.substring(comma + 1);
                                }

                                if (fLine.contains(",")) {
                                    int comma = fLine.indexOf(',');
                                    arrival_time = fLine.substring(0, comma);
                                    fLine = fLine.substring(comma + 1);
                                }

                                if (fLine.contains(",")) {
                                    int comma = fLine.indexOf(',');
                                    departure_time = fLine.substring(0, comma);
                                    fLine = fLine.substring(comma + 1);
                                }


                                if (fLine.contains(",")) {
                                    int comma = fLine.indexOf(',');
                                    stop_id = Long.parseLong(fLine.substring(0, comma));
                                    fLine = fLine.substring(comma + 1);
                                }

                                stop_sequence = Integer.parseInt(fLine);

                                ContentValues values = new ContentValues();
                                values.put(COLUMN_NAME_TRIP_ID, trip_id);
                                values.put(COLUMN_NAME_ARRIVAL_TIME, convertTimeToEpoch(arrival_time));
                                values.put(COLUMN_NAME_DEPARTURE_TIME, convertTimeToEpoch(departure_time));
                                values.put(COLUMN_NAME_STOP_ID, stop_id);
                                values.put(COLUMN_NAME_STOP_SEQUENCE, stop_sequence);

                                resolver.insert(StaticDbHelper.Companion.getTABLE_NAME_STOP_TIMES_CONTENT_URI(), values);

                            }
                        }
                    };

                    runnable.run();


                } catch (IOException e) {
                    Log.e(LOG_TAG, e.toString());
                }

            }

            updateInitializationStatus(TABLE_STOP_TIMES_INITIALIZED);
            Log.d(LOG_TAG, "stop_times table initialized.");

        }

        private void initTripsTable(Context context) {

            InputStream stream = context.getResources().openRawResource(R.raw.trips);

            InputStreamReader inputStreamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);

            // Since InputStreamReader can only read one character at a time
            // but a BufferedReader can read a lot more at once it is being used
            // to dramatically improve performance
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // First line of the stream
            //Being skipped as it contains headers and not actual data
            String line = null;
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                Log.e(LOG_TAG, e.toString());
            }

            // Read till end of stream
            while (line != null) {

                // readLine() automatically moves to next line after reading
                try {
                    line = bufferedReader.readLine();

                    //Skip any empty lines
                    if (!TextUtils.isEmpty(line)) {


                        int route_id = -1;
                        int service_id = -1;
                        int trip_id;

                        if (line.contains(",")) {
                            int comma = line.indexOf(',');
                            route_id = Integer.parseInt(line.substring(0, comma));
                            line = line.substring(comma + 1);
                        }

                        if (line.contains(",")) {
                            int comma = line.indexOf(',');
                            service_id = Integer.parseInt(line.substring(0, comma));
                            line = line.substring(comma + 1);
                        }

                        trip_id = Integer.parseInt(line);

                        ContentValues values = new ContentValues();
                        values.put(COLUMN_NAME_ROUTE_ID, route_id);
                        values.put(COLUMN_NAME_SERVICE_ID, service_id);
                        values.put(COLUMN_NAME_TRIP_ID, trip_id);
                        resolver.insert(StaticDbHelper.Companion.getTABLE_NAME_TRIPS_CONTENT_URI(), values);
                    }

                } catch (IOException e) {
                    Log.e(LOG_TAG, e.toString());
                }

            }

            updateInitializationStatus(TABLE_TRIPS_INITIALIZED);
            Log.d(LOG_TAG, "trips table initialized");

        }


    }

}

