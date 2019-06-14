package com.example.delhitransit.Data;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.example.delhitransit.Data.DAO.BusRouteDao;
import com.example.delhitransit.Data.DAO.BusStopDao;
import com.example.delhitransit.Data.DataClasses.BusRoute;
import com.example.delhitransit.Data.DataClasses.BusStop;
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

    public static List<GtfsRealtime.FeedEntity> fetchPositionData() {


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
                //For debugging purposes only
//                logAllEntries(database.getBusRouteDao().loadAllRoutes());
            }
        });

        initRoutes.run();

        final Thread initStops = new Thread(new Runnable() {
            @Override
            public void run() {
                initStopTable(context);
//                logAllEntries(database.getBusStopDao().loadAllBusStops());
            }
        });

        initStops.run();


    }

    // For debugging purposes only
    private static <T> void logAllEntries(List<T> list) {
        for (T item : list) {
            Log.v(LOG_TAG, item.toString());
        }
    }

    private static void initRoutesTable(Context context) {

        BusRouteDao busRouteDao = database.getBusRouteDao();
        busRouteDao.deleteAllRoutes();


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

            // readline() automatically moves to next line after reading
            try {
                line = bufferedReader.readLine();

                //Skip any empty lines
                if (!TextUtils.isEmpty(line)) {

                    String route_short_name = "";
                    String route_long_name = "";
                    int route_type = -1;
                    int route_id;

                    int prev_comma = 0;
                    int next_comma;

                    if (line.contains(",")) {
                        next_comma = line.indexOf(",");
                        route_short_name = line.substring(prev_comma, next_comma);
                        prev_comma = next_comma;
                        line = line.substring(prev_comma + 1);
                    }

                    if (line.contains(",")) {
                        next_comma = line.indexOf(",");
                        route_long_name = line.substring(prev_comma, next_comma);
                        prev_comma = next_comma;
                        line = line.substring(prev_comma + 1);
                    }


                    if (line.contains(",")) {
                        next_comma = line.indexOf(",");
                        route_type = Integer.parseInt(line.substring(0, next_comma));
                        prev_comma = next_comma;
                        line = line.substring(prev_comma + 1);
                    }

                    route_id = Integer.parseInt(line);

                    BusRoute route = new BusRoute(route_short_name, route_long_name, route_type, route_id);
                    busRouteDao.insertRoute(route);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        Log.d(LOG_TAG, "routes table initialized, Rows inserted: " + busRouteDao.loadAllRoutes().size());


    }

    private static void initStopTable(Context context) {

        BusStopDao busStopDao = database.getBusStopDao();
        busStopDao.deleteAllStops();

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

            // readline() automatically moves to next line after reading
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

        Log.d(LOG_TAG, "stops table initialized, Rows inserted: " + busStopDao.loadAllBusStops().size());


    }

}
