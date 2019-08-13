package com.example.delhitransit.Activities;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;


import com.example.delhitransit.Data.AppDatabase;
import com.example.delhitransit.Data.DAO.BusPositionDao;
import com.example.delhitransit.Data.DAO.BusRouteDao;
import com.example.delhitransit.Data.DAO.BusStopDao;
import com.example.delhitransit.Data.DAO.BusStopTimeDao;
import com.example.delhitransit.Data.DAO.BusTripDao;
import com.example.delhitransit.Data.DataClasses.BusPosition;
import com.example.delhitransit.Data.DataClasses.BusRoute;
import com.example.delhitransit.Data.DataClasses.BusStop;
import com.example.delhitransit.Data.DataClasses.BusStopTime;
import com.example.delhitransit.Data.DataClasses.BusTrip;
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


public class AppService extends Service {

    private static final String LOG_TAG = AppService.class.getSimpleName();
    private static Context context;
    private AppDatabase database;

    public AppService() {
        Log.d(LOG_TAG, "Service constructed");
        context = this;
    }

    @Override
    public IBinder onBind(Intent intent) {

        // Get a single instance of database to be used for all operations
        // This ensures data integrity as only single instance of DB initialized by application
        database = AppDatabase.getInstance(context.getApplicationContext());

        DatabaseInitializer initializer = new DatabaseInitializer();
        initializer.checkDatabaseIntegrity();

        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }

    public static AppService getInstance(){
        if (context != null) return (AppService)context;
        else return new AppService();
    }

    private long convertTimeToEpoch(String timestamp) {
        try {

            long epoch = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/01/1970 " + timestamp).getTime() / 1000;
            Log.d(LOG_TAG, "Human, Epoch " + timestamp + "\t" + epoch);
            return epoch;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public List<BusPosition> fetchAllPosition(final Context context) {

        final List<BusPosition> positionList = new ArrayList<>();

        List<GtfsRealtime.FeedEntity> feedEntities = fetchUpdateFromServer();

        for (GtfsRealtime.FeedEntity entity : feedEntities) {
            positionList.add(new BusPosition().parseFrom(entity));
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                updatePositionDatabase(positionList, context);
            }
        });

        thread.start();

        return positionList;

    }

    private void updatePositionDatabase(List<BusPosition> list, Context context) {

        AppDatabase instance = AppDatabase.getInstance(context);
        BusPositionDao busPositionDao = instance.getBusPositionDao();

        for (BusPosition position : list) {
            busPositionDao.insertBusPosition(position);
        }


    }

    public List<GtfsRealtime.FeedEntity> fetchUpdateFromServer() {


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

//    private List<BusPosition> updatePositionsTable() {
//
//        List<GtfsRealtime.FeedEntity> feedEntities = fetchUpdateFromServer();
//
//        List<BusPosition> positionArrayList = new ArrayList<>();
//
//        BusPositionDao busPositionDao = database.getBusPositionDao();
//
//        for (GtfsRealtime.FeedEntity entity : feedEntities) {
//            BusPosition position = new BusPosition().parseFrom(entity);
//            positionArrayList.add(position);
//            busPositionDao.insertBusPosition(position);
//        }
//
//        return positionArrayList;
//
//    }


    /* Class responsible for all initialization operation on the
     permanent data containing table of the database*/
    private class DatabaseInitializer{

        private final String LOG_TAG = DatabaseInitializer.class.getSimpleName();

        private boolean routes_initialized = false;
        private boolean stops_initalized = false;
        private boolean stop_times_initialized = false;
        private boolean trips_initialized = false;

        private void updateInitializationStatus(){

            if (routes_initialized && stops_initalized && stop_times_initialized && trips_initialized){

                // Get SharedPreferences that stores the state of the database
                final SharedPreferences preferences = getSharedPreferences(AppDatabase.DATABASE_SHARED_PREF_KEY, MODE_PRIVATE);

                boolean key_exists = preferences.contains(AppDatabase.DATABASE_IS_INITIALIZED_SHARED_PREF_KEY);
                boolean db_init_bool = key_exists && preferences.getBoolean(AppDatabase.DATABASE_IS_INITIALIZED_SHARED_PREF_KEY, false);

                db_init_bool = true;
                preferences.edit().putBoolean(AppDatabase.DATABASE_IS_INITIALIZED_SHARED_PREF_KEY, true).apply();
            }
        };

        private void checkDatabaseIntegrity(){

            // Get SharedPreferences that stores the state of the database
            final SharedPreferences preferences = getSharedPreferences(AppDatabase.DATABASE_SHARED_PREF_KEY, MODE_PRIVATE);

            boolean key_exists = preferences.contains(AppDatabase.DATABASE_IS_INITIALIZED_SHARED_PREF_KEY);
            boolean db_init_bool = key_exists && preferences.getBoolean(AppDatabase.DATABASE_IS_INITIALIZED_SHARED_PREF_KEY, false);

            // Check if database has already been initialized
            if (key_exists && db_init_bool) {

                routes_initialized = true;
                stop_times_initialized = true;
                stops_initalized= true;
                trips_initialized = true;
                Log.d(LOG_TAG, "Database is already initialized. Nothing to do.");

            }else{

                // DB not initialized
                Log.d(LOG_TAG, "Initializing the database");

                if (!routes_initialized){
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

                if (!stops_initalized){
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

                if (!stop_times_initialized){
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

                if (!trips_initialized){
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

            BusRouteDao busRouteDao = database.getBusRouteDao();
            busRouteDao.deleteAll();


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

                        BusRoute route = new BusRoute(route_short_name, route_long_name, route_type, route_id);
                        busRouteDao.insertRoute(route);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            routes_initialized = true;
            updateInitializationStatus();
            Log.d(LOG_TAG, "routes table initialized, Rows inserted: " + busRouteDao.getNumberOfRows());


        }

        private void initStopsTable(Context context) {

            BusStopDao busStopDao = database.getBusStopDao();
            busStopDao.deleteAll();

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


                        BusStop busStop = new BusStop(stop_id, stop_code, stop_name, stop_lat, stop_lon);
                        busStopDao.insertBusStop(busStop);


                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            stops_initalized = true;
            updateInitializationStatus();
            Log.d(LOG_TAG, "stops table initialized, Rows inserted: " + busStopDao.getNumberOfRows());


        }

        private void initStopTimesTable(Context context) {

            final BusStopTimeDao busStopTimeDao = database.getBusStopTimeDao();
            busStopTimeDao.deleteAll();

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

                                BusStopTime stopTime = new BusStopTime(trip_id, convertTimeToEpoch(arrival_time), convertTimeToEpoch(departure_time), stop_id, stop_sequence);
                                busStopTimeDao.insertRoute(stopTime);

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
            Log.d(LOG_TAG, "stop_times table initialized, Rows inserted: " + busStopTimeDao.loadAll(). size());

        }

        private void initTripsTable(Context context) {

            BusTripDao busTripDao = database.getBusTripDao();
            busTripDao.deleteAll();

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

                        BusTrip busTrip = new BusTrip(route_id, service_id, trip_id);
                        busTripDao.insertTrip(busTrip);

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            trips_initialized = true;
            updateInitializationStatus();
            Log.d(LOG_TAG, "trips table initialized, Rows inserted: " + busTripDao.getNumberOfRows());


        }

        // For debugging purposes only
        private <T> void logAllEntries(List<T> list) {
            for (T item : list) {
                Log.v(LOG_TAG, item.toString());
            }
        }

    }


}

