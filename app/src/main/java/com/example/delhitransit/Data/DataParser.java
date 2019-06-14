package com.example.delhitransit.Data;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.example.delhitransit.Data.DAO.BusRouteDao;
import com.example.delhitransit.Data.DataClasses.BusRoute;
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
    private static Context context;
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

    public static void initDb(Context context) {

        DataParser.context = context;

        database = AppDatabase.getInstance(DataParser.context.getApplicationContext());

        Thread initRoutes = new Thread(new Runnable() {
            @Override
            public void run() {
                initRoutesTable();
                //For debugging purposes only
//                logAllEntries(database.getBusRouteDao().loadAllRoutes());
            }
        });

        initRoutes.run();


    }

    // For debugging purposes only
    private static <T> void logAllEntries(List<T> list) {
        for (T item : list) {
            Log.v(LOG_TAG, item.toString());
        }
    }

    private static void initRoutesTable() {

        BusRouteDao busRouteDao = database.getBusRouteDao();
        busRouteDao.deleteAllRoutes();


        InputStream stream = DataParser.context.getResources().openRawResource(R.raw.routes);

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
                    int route_id = -1;

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


//    private void readTxtFile() {
//
//        StringBuilder output = new StringBuilder();
//
//        InputStream stream = this.getResources().openRawResource(R.raw.dummy_file);
//
//        if (stream != null) {
//            InputStreamReader inputStreamReader = new InputStreamReader(stream, Charset.forName("UTF-8" /*Name of Charset to convert to*/));
//
//            // Since InputStreamReader can only read one character at a time
//            // but a BufferedReader can read a lot more at once it is being used
//            // to imporve performance (dramatically)
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//            // First line of the stream
//            String line = null;
//            try {
//                line = bufferedReader.readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            // Read till end of stream
//            while (line != null) {
//                // Append line to StringBuilder
//                output.append(line);
//                // readline() automatically moves to next line after reading
//                try {
//                    line = bufferedReader.readLine();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        Log.v(LOG_TAG, output.toString());
//
//    }


}
