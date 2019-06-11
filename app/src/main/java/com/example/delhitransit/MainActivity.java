package com.example.delhitransit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream file = null;

        try {
            file = (InputStream) new FileInputStream("src/VehiclePositions.pb");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        GtfsRealtime.FeedMessage feedMessage = null;
        try {
            feedMessage = GtfsRealtime.FeedMessage.parseFrom(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(feedMessage.toString());

        List<GtfsRealtime.FeedEntity> entityList = feedMessage.getEntityList();

        for (GtfsRealtime.FeedEntity entity : entityList) {

            System.out.println("id: " + entity.getId() + " route: " + entity.getVehicle().getTrip().getRouteId() + " coordinates: " + entity.getVehicle().getPosition().getLatitude() + " " + entity.getVehicle().getPosition().getLongitude() + " speed: " + entity.getVehicle().getPosition().getSpeed());

        }

    }
}
