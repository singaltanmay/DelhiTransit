package com.example.delhitransit.Activities

import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class StopsSearchActivity : AppCompatActivity() {

    private val LOG_TAG = this.javaClass.simpleName;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(android.R.id.content, NearbyStopsFragment())
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


    private fun doMySearch(query: String) {

        Log.v(LOG_TAG, "Query received : $query")

    }
}
