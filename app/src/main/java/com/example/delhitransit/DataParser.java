package com.example.delhitransit;

import android.util.Log;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataParser {

    private static final String LOG_TAG = DataParser.class.getSimpleName();

    public static final String BASE_URL = "https://otd.delhi.gov.in/api/realtime/";
    private static final String API_KEY = "ObnMpq02enRlNc8m2iuOnR97GLnfKQUj";

    private static boolean isLoaded = false;
    private static List<GtfsRealtime.FeedEntity> feedEntity;

    public static List<GtfsRealtime.FeedEntity> fetchPositionData() {

        makeRetrofitRequest();

        while (!isLoaded) {
        }
        isLoaded = false;

        return feedEntity;

    }

    private static void makeRetrofitRequest() {
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getAPIClient()
                .getVehiclePositions(API_KEY);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                Log.d(LOG_TAG, response.message());
                isLoaded = true;

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(LOG_TAG, "Retrofit Call Failed!");
                isLoaded = true;
            }
        });
    }


}
