package com.example.delhitransit.Activities

import android.content.Context
import android.database.Cursor
import androidx.loader.content.AsyncTaskLoader


class RoutesLoader(context: Context) : AsyncTaskLoader<Cursor>(context) {

    override fun onStartLoading() {
        forceLoad()
    }

    override fun loadInBackground(): Cursor? = AppService.getInstance().allStops

}