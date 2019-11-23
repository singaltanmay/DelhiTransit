package com.example.delhitransit.Activities

import android.content.Context
import android.database.Cursor
import android.text.TextUtils
import androidx.loader.content.AsyncTaskLoader
import com.example.delhitransit.R


class RoutesLoader(context: Context) : AsyncTaskLoader<Cursor>(context) {

    override fun onStartLoading() {
        forceLoad()
    }

    override fun loadInBackground(): Cursor? = AppService.getInstance().getAllStopsWithinRange(28.715917, 77.170867,getStopRange(), null)

    fun getStopRange() : Double {
        val sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_preferences_shared_pref_key), Context.MODE_PRIVATE)
        val string = sharedPreferences?.getString(context.getString(R.string.nearby_stops_range_key), context.getString(R.string.nearby_stops_range_default_value))
        return java.lang.Double.parseDouble(string!!)
    }

}