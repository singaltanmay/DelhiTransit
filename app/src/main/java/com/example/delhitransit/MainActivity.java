package com.example.delhitransit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        InputStream file = null;
//
//        try {
//            file = (InputStream) new FileInputStream("src/VehiclePositions.pb");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        GtfsRealtime.FeedMessage feedMessage = null;
//        try {
//            feedMessage = GtfsRealtime.FeedMessage.parseFrom(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(feedMessage.toString());
//
//        List<GtfsRealtime.FeedEntity> entityList = feedMessage.getEntityList();
//
//        for (GtfsRealtime.FeedEntity entity : entityList) {
//
//            System.out.println("id: " + entity.getId() + " route: " + entity.getVehicle().getTrip().getRouteId() + " coordinates: " + entity.getVehicle().getPosition().getLatitude() + " " + entity.getVehicle().getPosition().getLongitude() + " speed: " + entity.getVehicle().getPosition().getSpeed());
//
//        }

        VehiclePositionLoader loader = new VehiclePositionLoader(this);
        loader.loadInBackground();

    }


    private class VehiclePositionLoader extends AsyncTaskLoader<List<GtfsRealtime.FeedEntity>> {


        private String LOG_TAG = VehiclePositionLoader.class.getSimpleName();

        private VehiclePositionLoader(@NonNull Context context) {
            super(context);
        }


        @Override
        protected void onStartLoading() {
            forceLoad();
        }

        @Nullable
        @Override
        public List<GtfsRealtime.FeedEntity> loadInBackground() {
            return DataParser.fetchPositionData();
        }
    }

}
