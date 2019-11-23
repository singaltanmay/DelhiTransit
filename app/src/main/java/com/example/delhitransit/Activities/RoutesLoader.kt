package com.example.delhitransit.Activities

import android.content.Context
import android.database.Cursor
import android.util.Log
import androidx.loader.content.AsyncTaskLoader
import com.example.delhitransit.R


class RoutesLoader(context: Context) : AsyncTaskLoader<Cursor>(context) {

    private val LOG_TAG = this.javaClass.simpleName

    override fun onStartLoading() {
        forceLoad()
    }

    override fun loadInBackground(): Cursor? {
        val instance = AppService.getInstance()
        return instance.getAllStopsWithinRange(28.715917, 77.170867,instance.getStopRange(), null)
    }



}