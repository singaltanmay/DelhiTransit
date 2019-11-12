package com.example.delhitransit.Activities

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class StopsSearchActivity : AppCompatActivity() {

    private val LOG_TAG = this.javaClass.simpleName
    var sharedPreferences: SharedPreferences? = null
    var nearbyStopsFragment: NearbyStopsFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        actionBar?.setDisplayHomeAsUpEnabled(true)

        sharedPreferences = getSharedPreferences("LastSearch", Context.MODE_PRIVATE)

        val transaction = supportFragmentManager.beginTransaction()
        nearbyStopsFragment = NearbyStopsFragment()
        transaction.replace(android.R.id.content, nearbyStopsFragment!!)
        transaction.commit()

        // TODO implement voice search
        /*// Verify the action and get the query
        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                Log.d(LOG_TAG, "Q sub intent $query")
            }
        }*/


    }

}
