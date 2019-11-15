package com.example.delhitransit.Activities

import android.content.AsyncTaskLoader
import android.content.Context

import com.example.delhitransit.BusPositionUpdate

class VehiclePositionLoader(context: Context) : AsyncTaskLoader<List<BusPositionUpdate>>(context) {

    override fun onStartLoading() = forceLoad()

    override fun loadInBackground(): List<BusPositionUpdate>? = AppService.getInstance().fetchAllPosition(context)

}