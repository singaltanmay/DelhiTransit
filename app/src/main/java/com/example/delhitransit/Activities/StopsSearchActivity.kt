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
    var fragBundle = Bundle()
    var sharedPreferences: SharedPreferences? = null
    var nearbyStopsFragment: NearbyStopsFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        actionBar?.setDisplayHomeAsUpEnabled(true)

        Log.d(LOG_TAG, "Q sub new activity")

        sharedPreferences = getSharedPreferences("LastSearch", Context.MODE_PRIVATE)

        val routeSourceKey = NearbyStopsFragment.ROUTE_SOURCE_KEY
        val routeDestinationKey = NearbyStopsFragment.ROUTE_DESTINATION_KEY
        fragBundle.putString(routeSourceKey, sharedPreferences?.getString(routeSourceKey, null))
        fragBundle.putString(routeDestinationKey, sharedPreferences?.getString(routeDestinationKey, null))

        val transaction = supportFragmentManager.beginTransaction()
        nearbyStopsFragment = NearbyStopsFragment()
        transaction.replace(android.R.id.content, nearbyStopsFragment!!)
        transaction.commit()

        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent) {
        setIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        // Verify the action and get the query
        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                doMySearch(query)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        val editor = sharedPreferences?.edit()

        val routeSourceKey = NearbyStopsFragment.ROUTE_SOURCE_KEY
        val routeDestinationKey = NearbyStopsFragment.ROUTE_DESTINATION_KEY

        val source = fragBundle.getString(routeSourceKey)
        val destination = fragBundle.getString(routeDestinationKey)

        editor?.putString(routeSourceKey, source)
        editor?.putString(routeDestinationKey, destination)

        editor?.apply()

        Log.d(LOG_TAG, "Last search before destroy $source to + $destination")
    }

    private fun doMySearch(query: String) {
        val routeSourceKey = NearbyStopsFragment.ROUTE_SOURCE_KEY
        nearbyStopsFragment?.saveBundle?.putString(routeSourceKey, query)
        nearbyStopsFragment?.restoreSearchTerms()
        Log.v(LOG_TAG, "Query received : $query")
    }
}
