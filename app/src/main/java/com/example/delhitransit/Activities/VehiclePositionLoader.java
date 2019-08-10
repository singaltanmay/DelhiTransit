package com.example.delhitransit.Activities;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.delhitransit.Data.DataClasses.BusPosition;
import com.example.delhitransit.Data.DataParser;

import java.util.List;

public class VehiclePositionLoader extends AsyncTaskLoader<List<BusPosition>> {


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
    public List<BusPosition> loadInBackground() {
        Log.d(LOG_TAG, "Begin Loading");


        return DataParser.fetchAllPosition(getContext());
    }
}