package com.example.delhitransit.Data;

import android.util.Log;

import com.example.delhitransit.GtfsRealtime;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class DataParser {

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
