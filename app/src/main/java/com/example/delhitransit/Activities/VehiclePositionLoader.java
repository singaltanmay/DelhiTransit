package com.example.delhitransit.Activities;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.delhitransit.Data.DataClasses.BusPosition;

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

        AppService service = AppService.getInstance();

        Log.d(LOG_TAG, "Received service : "  + service);

        return service.fetchAllPosition(getContext());
    }
}