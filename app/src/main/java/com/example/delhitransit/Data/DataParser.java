package com.example.delhitransit.Data;

import android.app.IntentService;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.example.delhitransit.Data.DAO.BusRouteDao;
import com.example.delhitransit.Data.DAO.BusStopDao;
import com.example.delhitransit.Data.DAO.BusStopTimeDao;
import com.example.delhitransit.Data.DAO.BusTripDao;
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
import java.util.List;

public class DataParser {

    private static AppDatabase database;
    private static final String LOG_TAG = DataParser.class.getSimpleName();

    public static List<GtfsRealtime.FeedEntity> fetchPositionUpdateData() {


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

    public static void initDb(final Context context) {


        database = AppDatabase.getInstance(context.getApplicationContext());

        Thread initRoutes = new Thread(new Runnable() {
            @Override
            public void run() {
                initRoutesTable(context);
                logAllEntries(database.getBusRouteDao().loadAll());
            }
        });


        final Thread initStops = new Thread(new Runnable() {
            @Override
            public void run() {
                initStopsTable(context);
//                logAllEntries(database.getBusStopDao().loadAll());
            }
        });


        final Thread initStopTimes = new Thread(new Runnable() {
            @Override
            public void run() {
                initStopTimesTable(context);
//                logAllEntries(database.getBusStopTimeDao().loadAll());
            }
        });


        final Thread initTrips = new Thread(new Runnable() {
            @Override
            public void run() {
                initTripsTable(context);
//                logAllEntries(database.getBusTripDao().loadAll());
            }
        });

        initRoutes.start();
        initStops.start();
        initStopTimes.start();
        initTrips.start();

    }

    // For debugging purposes only
    private static <T> void logAllEntries(List<T> list) {
        for (T item : list) {
            Log.v(LOG_TAG, item.toString());
        }
    }

    private static void initRoutesTable(Context context) {

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

        Log.d(LOG_TAG, "routes table initialized, Rows inserted: " + busRouteDao.getNumberOfRows());


    }

    private static void initStopsTable(Context context) {

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

        Log.d(LOG_TAG, "stops table initialized, Rows inserted: " + busStopDao.getNumberOfRows());


    }

    private static void initStopTimesTable(Context context) {

        BusStopTimeDao busStopTimeDao = database.getBusStopTimeDao();
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

                //Skip any empty lines
                if (!TextUtils.isEmpty(line)) {

                    int trip_id = -1;
                    String arrival_time = "";
                    String departure_time = "";
                    long stop_id = -1;
                    int stop_sequence = -1;

                    if (line.contains(",")) {
                        int comma = line.indexOf(",");
                        trip_id = Integer.parseInt(line.substring(0, comma));
                        line = line.substring(comma + 1);
                    }

                    if (line.contains(",")) {
                        int comma = line.indexOf(",");
                        arrival_time = line.substring(0, comma);
                        line = line.substring(comma + 1);
                    }

                    if (line.contains(",")) {
                        int comma = line.indexOf(",");
                        departure_time = line.substring(0, comma);
                        line = line.substring(comma + 1);
                    }


                    if (line.contains(",")) {
                        int comma = line.indexOf(",");
                        stop_id = Long.parseLong(line.substring(0, comma));
                        line = line.substring(comma + 1);
                    }

                    stop_sequence = Integer.parseInt(line);

                    BusStopTime stopTime = new BusStopTime(trip_id, arrival_time, departure_time, stop_id, stop_sequence);
                    busStopTimeDao.insertRoute(stopTime);

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        Log.d(LOG_TAG, "stop_times table initialized, Rows inserted: " + busStopTimeDao.loadAll().size());


    }

    private static void initTripsTable(Context context) {

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

        Log.d(LOG_TAG, "trips table initialized, Rows inserted: " + busTripDao.getNumberOfRows());


    }

}
