package com.example.delhitransit.Activities;

import android.app.Service;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;

import com.example.delhitransit.Database.StaticDbHelper;
import com.example.delhitransit.RoomData.AppDatabase;
import com.example.delhitransit.RoomData.DAO.BusPositionDao;
import com.example.delhitransit.RoomData.DataClasses.BusPositionUpdate;
import com.example.delhitransit.GtfsRealtime;
import com.example.delhitransit.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static com.example.delhitransit.Database.StaticDbHelper.COLUMN_NAME_ARRIVAL_TIME;
import static com.example.delhitransit.Database.StaticDbHelper.COLUMN_NAME_DEPARTURE_TIME;
import static com.example.delhitransit.Database.StaticDbHelper.COLUMN_NAME_ROUTE_ID;
import static com.example.delhitransit.Database.StaticDbHelper.COLUMN_NAME_SERVICE_ID;
import static com.example.delhitransit.Database.StaticDbHelper.COLUMN_NAME_STOP_CODE;
import static com.example.delhitransit.Database.StaticDbHelper.COLUMN_NAME_STOP_ID;
import static com.example.delhitransit.Database.StaticDbHelper.COLUMN_NAME_STOP_LATITUDE;
import static com.example.delhitransit.Database.StaticDbHelper.COLUMN_NAME_STOP_LONGITUDE;
import static com.example.delhitransit.Database.StaticDbHelper.COLUMN_NAME_STOP_NAME;
import static com.example.delhitransit.Database.StaticDbHelper.COLUMN_NAME_STOP_SEQUENCE;
import static com.example.delhitransit.Database.StaticDbHelper.COLUMN_NAME_TRIP_ID;
import static com.example.delhitransit.Database.StaticDbHelper.TABLE_NAME_STOP_TIMES_CONTENT_URI;

public class AppService extends Service {

    private static final String LOG_TAG = AppService.class.getSimpleName();
    private static Context context;
    private AppDatabase database;

    public AppService() {
        Log.d(LOG_TAG, "Service constructed");
        context = this;
    }

    @Override
    public void onCreate() {

        // Get a single instance of database to be used for all operations
        // This ensures data integrity as only single instance of DB initialized by application
        database = AppDatabase.getInstance(context.getApplicationContext());

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
            if (service.database == null) {
                Log.d(LOG_TAG, "Lifecycle not complete. Calling onCreate");
                //service.onCreate();
            }
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
                updatePositionDatabase(positionList, context);
            }
        });

        //TODO update database updation
//        thread.start();

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
            e.printStackTrace();
        }

        return feedEntityList;
    }

    // Updates the database with new information
    private void updatePositionDatabase(List<BusPositionUpdate> list, Context context) {
        BusPositionDao busPositionDao = database.getBusPositionDao();
        for (BusPositionUpdate position : list) busPositionDao.insertBusPosition(position);
    }

    private long convertTimeToEpoch(String timestamp) {
//        try {
//            long epoch = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/01/1970" + timestamp).getTime() / 1000;
//            Log.d(LOG_TAG, "Human, Epoch " + timestamp + "\t" + epoch);
//            return epoch;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return 0;
    }

    /* Class responsible for all initialization operation on the
     permanent data containing table of the database*/
    private class DatabaseInitializer {

        private final String LOG_TAG = DatabaseInitializer.class.getSimpleName();

        private boolean routes_initialized = false;
        private boolean stops_initialized = false;
        private boolean stop_times_initialized = false;
        private boolean trips_initialized = false;

        private void updateInitializationStatus() {

            if (routes_initialized && stops_initialized && stop_times_initialized && trips_initialized) {

                // Get SharedPreferences that stores the state of the database
                final SharedPreferences preferences = getSharedPreferences(AppDatabase.DATABASE_SHARED_PREF_KEY, MODE_PRIVATE);

                boolean key_exists = preferences.contains(AppDatabase.DATABASE_IS_INITIALIZED_SHARED_PREF_KEY);
                preferences.edit().putBoolean(AppDatabase.DATABASE_IS_INITIALIZED_SHARED_PREF_KEY, true).apply();
            }
        }


        private void checkDatabaseIntegrity() {

            // Get SharedPreferences that stores the state of the database
            final SharedPreferences preferences = getSharedPreferences(AppDatabase.DATABASE_SHARED_PREF_KEY, MODE_PRIVATE);

            boolean key_exists = preferences.contains(AppDatabase.DATABASE_IS_INITIALIZED_SHARED_PREF_KEY);
            boolean db_init_bool = key_exists && preferences.getBoolean(AppDatabase.DATABASE_IS_INITIALIZED_SHARED_PREF_KEY, false);

            // Check if database has already been initialized
            if (key_exists && db_init_bool) {

                routes_initialized = true;
                stop_times_initialized = true;
                stops_initialized = true;
                trips_initialized = true;
                Log.d(LOG_TAG, "Database is already initialized. Nothing to do.");

            } else {

                // DB not initialized
                Log.d(LOG_TAG, "Initializing the database");

                if (!routes_initialized) {
                    // Create new thread to init table
                    Thread initRoutes = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            initRoutesTable(context);
//                logAllEntries(database.getBusRouteDao().loadAll());
                        }
                    });
                    initRoutes.start();
                }

                if (!stops_initialized) {
                    // Create new thread to init table
                    final Thread initStops = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            initStopsTable(context);
//                logAllEntries(database.getBusStopDao().loadAll());
                        }
                    });
                    initStops.start();
                }

                if (!stop_times_initialized) {
                    // Create new thread to init table
                    final Thread initStopTimes = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            initStopTimesTable(context);
//                logAllEntries(database.getBusStopTimeDao().loadAll());
                        }
                    });
                    initStopTimes.start();
                }

                if (!trips_initialized) {
                    // Create new thread to init table
                    final Thread initTrips = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            initTripsTable(context);
//                logAllEntries(database.getBusTripDao().loadAll());
                        }
                    });
                    initTrips.start();
                }


            }
            // Update database state info stored in SharedPreferences
            preferences.edit().putBoolean(AppDatabase.DATABASE_IS_INITIALIZED_SHARED_PREF_KEY, true).apply();
        }

        private void initRoutesTable(Context context) {

            InputStream stream = context.getResources().openRawResource(R.raw.routes);

            InputStreamReader inputStreamReader = new InputStreamReader(stream, Charset.forName("UTF-8" /*Name of Charset to convert to*/));

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
                e.printStackTrace();
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
                            int comma = line.indexOf(",");
                            route_short_name = line.substring(0, comma);
                            line = line.substring(comma + 1);
                        }

                        if (line.contains(",")) {
                            int comma = line.indexOf(",");
                            route_long_name = line.substring(0, comma);
                            line = line.substring(comma + 1);
                        }

                        if (line.contains(",")) {
                            int comma = line.indexOf(",");
                            route_type = Integer.parseInt(line.substring(0, comma));
                            line = line.substring(comma + 1);
                        }

                        route_id = Integer.parseInt(line);

                        ContentValues values = new ContentValues();
                        values.put(StaticDbHelper.COLUMN_NAME_ROUTE_ID, route_id);
                        values.put(StaticDbHelper.COLUMN_NAME_ROUTE_SHORT_NAME, route_short_name);
                        values.put(StaticDbHelper.COLUMN_NAME_ROUTE_LONG_NAME, route_long_name);
                        values.put(StaticDbHelper.COLUMN_NAME_ROUTE_TYPE, route_type);

                        getContentResolver().insert(StaticDbHelper.TABLE_NAME_ROUTES_CONTENT_URI, values);

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            routes_initialized = true;
            updateInitializationStatus();
            Log.d(LOG_TAG, "routes table initialized");


        }

        private void initStopsTable(Context context) {

            InputStream stream = context.getResources().openRawResource(R.raw.stops);

            InputStreamReader inputStreamReader = new InputStreamReader(stream, Charset.forName("UTF-8" /*Name of Charset to convert to*/));

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
                e.printStackTrace();
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
                            int comma = line.indexOf(",");
                            stop_id = Integer.parseInt(line.substring(0, comma));
                            line = line.substring(comma + 1);
                        }

                        if (line.contains(",")) {
                            int comma = line.indexOf(",");
                            stop_code = line.substring(0, comma);
                            line = line.substring(comma + 1);
                        }

                        if (line.contains(",")) {
                            int comma = line.indexOf(",");
                            //TODO implement stack based method to ignore , between ""
                            //TODO restore "Sec-7 / 8 Xing" to "Sec-7,8 Xing" in line 2586
                        /*// Prevent parsing comma that is part of value
                        if (line.substring(0, comma).contains("\"")) {
                            if (line.substring(comma + 1).contains("\"")) {
                                comma += line.substring(comma + 1).indexOf("\"");
                            }
                        }*/

                            stop_name = line.substring(0, comma);
                            line = line.substring(comma + 1);
                        }

                        if (line.contains(",")) {
                            int comma = line.indexOf(",");
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
                        getContentResolver().insert(StaticDbHelper.TABLE_NAME_STOPS_CONTENT_URI, values);

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            stops_initialized = true;
            updateInitializationStatus();
            Log.d(LOG_TAG, "stops table initialized.");


        }

        private void initStopTimesTable(Context context) {

            InputStream stream = context.getResources().openRawResource(R.raw.stop_times);

            InputStreamReader inputStreamReader = new InputStreamReader(stream, Charset.forName("UTF-8" /*Name of Charset to convert to*/));

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
                e.printStackTrace();
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
                                    int comma = fLine.indexOf(",");
                                    trip_id = Integer.parseInt(fLine.substring(0, comma));
                                    fLine = fLine.substring(comma + 1);
                                }

                                if (fLine.contains(",")) {
                                    int comma = fLine.indexOf(",");
                                    arrival_time = fLine.substring(0, comma);
                                    fLine = fLine.substring(comma + 1);
                                }

                                if (fLine.contains(",")) {
                                    int comma = fLine.indexOf(",");
                                    departure_time = fLine.substring(0, comma);
                                    fLine = fLine.substring(comma + 1);
                                }


                                if (fLine.contains(",")) {
                                    int comma = fLine.indexOf(",");
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

                                getContentResolver().insert(TABLE_NAME_STOP_TIMES_CONTENT_URI, values);

                            }
                        }
                    };

                    runnable.run();


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            stop_times_initialized = true;
            updateInitializationStatus();
            Log.d(LOG_TAG, "stop_times table initialized.");

        }

        private void initTripsTable(Context context) {

            InputStream stream = context.getResources().openRawResource(R.raw.trips);

            InputStreamReader inputStreamReader = new InputStreamReader(stream, Charset.forName("UTF-8" /*Name of Charset to convert to*/));

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
                e.printStackTrace();
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
                            int comma = line.indexOf(",");
                            route_id = Integer.parseInt(line.substring(0, comma));
                            line = line.substring(comma + 1);
                        }

                        if (line.contains(",")) {
                            int comma = line.indexOf(",");
                            service_id = Integer.parseInt(line.substring(0, comma));
                            line = line.substring(comma + 1);
                        }

                        trip_id = Integer.parseInt(line);

                        ContentValues values = new ContentValues();
                        values.put(COLUMN_NAME_ROUTE_ID, route_id);
                        values.put(COLUMN_NAME_SERVICE_ID, service_id);
                        values.put(COLUMN_NAME_TRIP_ID, trip_id);
                        getContentResolver().insert(StaticDbHelper.TABLE_NAME_TRIPS_CONTENT_URI, values);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            trips_initialized = true;
            updateInitializationStatus();
            Log.d(LOG_TAG, "trips table initialized");


        }

        // For debugging purposes only
        private <T> void logAllEntries(List<T> list) {
            for (T item : list) {
                Log.v(LOG_TAG, item.toString());
            }
        }

    }

}

