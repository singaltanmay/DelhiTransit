package com.example.delhitransit.Activities;

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

import com.example.delhitransit.Database.DynamicDbHelper;
import com.example.delhitransit.Database.StaticDbHelper;
import com.example.delhitransit.BusPositionUpdate;
import com.example.delhitransit.GeoLocation;
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
import java.util.Calendar;
import java.util.List;

public class AppService extends Service {

    public static final short TABLE_OPS_INIT = 0;
    public static final short TABLE_OPS_DROP = 1;

    private static final String LOG_TAG = AppService.class.getSimpleName();
    private static Context context;
    private static ContentResolver resolver;

    private DatabaseOps databaseOps;

    public AppService() {
        Log.d(LOG_TAG, "AppService constructed");
        context = this;
    }

    @Override
    public void onCreate() {
        resolver = context.getContentResolver();
        databaseOps = new DatabaseOps();
        databaseOps.checkDatabaseIntegrity();
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
        else return new AppService();
    }

    /**
     * Initiates web update and delegates all related tasks
     */
    public List<BusPositionUpdate> fetchAllPosition() {

        final List<BusPositionUpdate> positionList = new ArrayList<>();

        // Get the latest update from server
        List<GtfsRealtime.FeedEntity> feedEntities = fetchUpdateFromServer();

        // Parses list element into a POJO and adds it to another positionList
        for (GtfsRealtime.FeedEntity entity : feedEntities) {
            positionList.add(new BusPositionUpdate().parseFrom(entity));
        }

        if (databaseOps == null) databaseOps = new DatabaseOps();

        databaseOps.updatePositionDatabase(positionList);

        // Return list for displaying in GUI
        return positionList;
    }

    /**
     * Makes a HTTP request and returns the latest update in a list
     */
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

                Log.d(LOG_TAG, "Size of FeedEntity list received from server : " + feedEntityList.size());

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

    // TODO Find all paths
    public Cursor findAllPaths(String source, String destination) {

        String columnNameStopId = StaticDbHelper.COLUMN_NAME_STOP_ID;

        String selection = columnNameStopId + " = ? OR " + columnNameStopId + " = ?;";

        String[] selectionArgs = {source, destination};

        return resolver.query(StaticDbHelper.Companion.getTABLE_NAME_STOP_TIMES_CONTENT_URI(), null, selection, selectionArgs, null, null);

    }

    public Cursor getAllStops() {

        return resolver.query(StaticDbHelper.Companion.getTABLE_NAME_STOPS_CONTENT_URI(), null, null, null, null, null);

    }

    /**
     * Returns all stops within the given radius from the co-ordinates passed into it.
     *
     * @param latitude   is the latitude of user's current location
     * @param longitude  is the longitude of user's current location
     * @param radius     is the radius in km in which latitude & longitude of stops can vary
     * @param projection is used to specify the columns required. Pass null to get all columns
     */
    public Cursor getAllStopsWithinRange(final double latitude, final double longitude, final double radius, String[] projection) {

        GeoLocation[] boundingCoordinates = GeoLocation.fromDegrees(latitude, longitude).boundingCoordinates(radius, null);

        final String minLat = Double.toString(boundingCoordinates[0].getLatitudeInDegrees());
        final String minLong = Double.toString(boundingCoordinates[0].getLongitudeInDegrees());
        final String maxLat = Double.toString(boundingCoordinates[1].getLatitudeInDegrees());
        final String maxLong = Double.toString(boundingCoordinates[1].getLongitudeInDegrees());

        String latCondition = StaticDbHelper.COLUMN_NAME_STOP_LATITUDE + " > ? AND " + StaticDbHelper.COLUMN_NAME_STOP_LATITUDE + " < ?";
        String longCondition = StaticDbHelper.COLUMN_NAME_STOP_LONGITUDE + " > ? AND " + StaticDbHelper.COLUMN_NAME_STOP_LONGITUDE + " < ?";

        String selection = "(" + latCondition + ") AND (" + longCondition + ");";
        String[] selectionArgs = {
                minLat,
                maxLat,
                minLong,
                maxLong
        };

        return resolver.query(StaticDbHelper.Companion.getTABLE_NAME_STOPS_CONTENT_URI(), projection, selection, selectionArgs, null, null);

    }

    private long convertTimeToEpoch(String timestamp) {
        long time;
        long hour = Long.parseLong(timestamp.substring(0, 2));
        long minute = Long.parseLong(timestamp.substring(3, 5));
        long second = Long.parseLong(timestamp.substring(6));

        time = (((hour * 60) + minute) * 60) + second;

        return time;
    }

    public long secondsSince12AM() {
        Calendar instance = Calendar.getInstance();
        return ((((instance.get(Calendar.HOUR_OF_DAY) * 60) + instance.get(Calendar.MINUTE)) * 60)
                + instance.get(Calendar.SECOND));
    }

    public void modifyDatabaseTable(final String table_key, final short operation) {

        if (table_key.equals(getString(R.string.routes_initialized_key))) {
            switch (operation) {
                case TABLE_OPS_INIT: {
                    databaseOps.initRoutesTable();
                    break;
                }
                case TABLE_OPS_DROP: {
                    databaseOps.dropRoutesTable();
                    break;
                }
            }
        } else if (table_key.equals(getString(R.string.stops_initialized_key))) {
            switch (operation) {
                case TABLE_OPS_INIT: {
                    databaseOps.initStopsTable();
                    break;
                }
                case TABLE_OPS_DROP: {
                    databaseOps.dropStopsTable();
                    break;
                }
            }
        } else if (table_key.equals(getString(R.string.trips_initialized_key))) {
            switch (operation) {
                case TABLE_OPS_INIT: {
                    databaseOps.initTripsTable();
                    break;
                }
                case TABLE_OPS_DROP: {
                    databaseOps.dropTripsTable();
                    break;
                }
            }
        } else if (table_key.equals(getString(R.string.stop_times_initialized_key))) {
            switch (operation) {
                case TABLE_OPS_INIT: {
                    databaseOps.initStopTimesTable();
                    break;
                }
                case TABLE_OPS_DROP: {
                    databaseOps.dropStopTimesTable();
                    break;
                }
            }
        }

    }


    /**
     * Class responsible for all initialization operation on the
     * permanent static data containing tables in the Database
     */
    private final class DatabaseOps {

        private final String LOG_TAG = DatabaseOps.class.getSimpleName();
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

            // Get SharedPreferences that stores the state of the Database
            staticDBPrefs = getSharedPreferences(getString(R.string.database_shared_pref_key), MODE_PRIVATE);
            staticDBPrefsEditor = staticDBPrefs.edit();

            // Checks if tables in the Database have already been initialized
            // Initializes tables if not already initialized
            if (tableHasToBeInitialized(getString(R.string.stops_initialized_key)))
                initStopsTable();

            if (tableHasToBeInitialized(getString(R.string.routes_initialized_key)))
                initRoutesTable();

            if (tableHasToBeInitialized(getString(R.string.trips_initialized_key)))
                initTripsTable();

            if (tableHasToBeInitialized(getString(R.string.stop_times_initialized_key)))
                initStopTimesTable();

        }

        void initRoutesTable() {
            // Create new thread to init table
            final Thread initRoutes = new Thread(new Runnable() {
                @Override
                public void run() {
                    initRoutesTable(context);
                }
            });
            initRoutes.start();
        }

        void initStopsTable() {
            // Create new thread to init table
            Thread initStops = new Thread(new Runnable() {
                @Override
                public void run() {
                    initStopsTable(context);
                }
            });
            initStops.start();
        }

        void initTripsTable() {
            // Create new thread to init table
            final Thread initTrips = new Thread(new Runnable() {
                @Override
                public void run() {
                    initTripsTable(context);
                }
            });
            initTrips.start();
        }

        void initStopTimesTable() {
            // Create new thread to init table
            final Thread initStopTimes = new Thread(new Runnable() {
                @Override
                public void run() {
                    initStopTimesTable(context);
                }
            });
            initStopTimes.start();
        }

        void dropRoutesTable() {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            resolver.delete(StaticDbHelper.Companion.getTABLE_NAME_ROUTES_CONTENT_URI(), null, null);
                        }
                    }
            ).start();
        }

        void dropStopsTable() {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            resolver.delete(StaticDbHelper.Companion.getTABLE_NAME_STOPS_CONTENT_URI(), null, null);
                        }
                    }
            ).start();
        }

        void dropStopTimesTable() {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            resolver.delete(StaticDbHelper.Companion.getTABLE_NAME_STOP_TIMES_CONTENT_URI(), null, null);
                        }
                    }
            ).start();
        }

        void dropTripsTable() {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            resolver.delete(StaticDbHelper.Companion.getTABLE_NAME_TRIPS_CONTENT_URI(), null, null);
                        }
                    }
            ).start();
        }

        private void initRoutesTable(Context context) {

            // Drop any pre-existing table to prevent duplicacy
            dropRoutesTable();

            InputStream stream = context.getResources().openRawResource(R.raw.routes);

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

            updateInitializationStatus(getString(R.string.routes_initialized_key));
            Log.v(LOG_TAG, "routes table initialized");


        }

        private void initStopsTable(Context context) {

            // Drop any pre-existing table to prevent duplicacy
            dropStopsTable();

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
                            int comma;

                            if (line.charAt(0) == '"') {
                                comma = line.indexOf('"', 1) + 1;
                            } else comma = line.indexOf(',');

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
                        values.put(StaticDbHelper.COLUMN_NAME_STOP_ID, stop_id);
                        values.put(StaticDbHelper.COLUMN_NAME_STOP_CODE, stop_code);
                        values.put(StaticDbHelper.COLUMN_NAME_STOP_NAME, stop_name);
                        values.put(StaticDbHelper.COLUMN_NAME_STOP_LATITUDE, stop_lat);
                        values.put(StaticDbHelper.COLUMN_NAME_STOP_LONGITUDE, stop_lon);

                        resolver.insert(StaticDbHelper.Companion.getTABLE_NAME_STOPS_CONTENT_URI(), values);

                    }

                } catch (IOException e) {
                    Log.e(LOG_TAG, e.toString());
                }

            }

            updateInitializationStatus(getString(R.string.stops_initialized_key));
            Log.d(LOG_TAG, "stops table initialized.");


        }

        private void initStopTimesTable(Context context) {

            // Drop any pre-existing table to prevent duplicacy
            dropStopTimesTable();

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
                                values.put(StaticDbHelper.COLUMN_NAME_TRIP_ID, trip_id);
                                values.put(StaticDbHelper.COLUMN_NAME_ARRIVAL_TIME, convertTimeToEpoch(arrival_time));
                                values.put(StaticDbHelper.COLUMN_NAME_DEPARTURE_TIME, convertTimeToEpoch(departure_time));
                                values.put(StaticDbHelper.COLUMN_NAME_STOP_ID, stop_id);
                                values.put(StaticDbHelper.COLUMN_NAME_STOP_SEQUENCE, stop_sequence);

                                resolver.insert(StaticDbHelper.Companion.getTABLE_NAME_STOP_TIMES_CONTENT_URI(), values);

                            }
                        }
                    };

                    runnable.run();


                } catch (IOException e) {
                    Log.e(LOG_TAG, e.toString());
                }

            }

            updateInitializationStatus(getString(R.string.stop_times_initialized_key));
            Log.d(LOG_TAG, "stop_times table initialized.");

        }

        private void initTripsTable(Context context) {

            // Drop any pre-existing table to prevent duplicacy
            dropTripsTable();

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
                        values.put(StaticDbHelper.COLUMN_NAME_ROUTE_ID, route_id);
                        values.put(StaticDbHelper.COLUMN_NAME_SERVICE_ID, service_id);
                        values.put(StaticDbHelper.COLUMN_NAME_TRIP_ID, trip_id);
                        resolver.insert(StaticDbHelper.Companion.getTABLE_NAME_TRIPS_CONTENT_URI(), values);
                    }

                } catch (IOException e) {
                    Log.e(LOG_TAG, e.toString());
                }

            }

            updateInitializationStatus(getString(R.string.trips_initialized_key));
            Log.d(LOG_TAG, "trips table initialized");

        }

        public void updatePositionDatabase(final List<BusPositionUpdate> list) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    // Update Database with new information
                    mUpdatePositionDatabase(list);
                }
            }).start();

        }

        // Updates the Database with new information
        private void mUpdatePositionDatabase(List<BusPositionUpdate> list) {

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

    }

}

