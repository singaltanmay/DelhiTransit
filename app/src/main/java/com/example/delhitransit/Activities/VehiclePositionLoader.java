package com.example.delhitransit.Activities;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.delhitransit.Data.DataParser;
import com.example.delhitransit.GtfsRealtime;

import java.util.List;

public class VehiclePositionLoader extends AsyncTaskLoader<List<GtfsRealtime.FeedEntity>> {


    private String LOG_TAG = VehiclePositionLoader.class.getSimpleName();

    public VehiclePositionLoader(@NonNull Context context) {
        super(context);
    }


    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<GtfsRealtime.FeedEntity> loadInBackground() {
        Log.d(LOG_TAG, "Begin Loading");
        List<GtfsRealtime.FeedEntity> entityList = DataParser.fetchPositionUpdateData();

//        for (GtfsRealtime.FeedEntity entity : entityList) {
//            Log.v(LOG_TAG, entity.getId() + entity.getVehicle().getStopId());
//        }

        return entityList;
    }
}