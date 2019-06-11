package com.example.delhitransit;

import android.util.Log;

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


        } catch (
                Exception e) {
            e.printStackTrace();
        }

        return feedEntityList;

    }

}
