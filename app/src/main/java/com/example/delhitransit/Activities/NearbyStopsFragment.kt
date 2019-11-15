package com.example.delhitransit.activities

import android.app.SearchManager
import android.content.Context
import android.content.SharedPreferences
import android.database.Cursor
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment

import com.example.delhitransit.database.StaticDbHelper
import com.example.delhitransit.R

class NearbyStopsFragment : Fragment() {

    // Equivalent to a static block in Java (kinda)
    companion object {
        private val LOG_TAG = NearbyStopsFragment::class.java.simpleName
        private const val ROUTE_SOURCE_KEY = "route_SKey"
        private const val ROUTE_DESTINATION_KEY = "route_DKey"
    }

    private var mRootView: View? = null
    private var mService: AppService? = null
    private var mAdapter: StopCursorAdapter? = null
    private var mContext: Context? = null
    private var mActivity: StopsSearchActivity? = null
    private var sourceSearchView: SearchView? = null
    private var destinationSearchView: SearchView? = null
    private var mPreferences: SharedPreferences? = null


    override fun onStart() {
        super.onStart()
        if (sourceSearchView != null && destinationSearchView != null) restoreSearchTerms()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mContext = getContext()
        mActivity = getActivity() as StopsSearchActivity?
        mService = AppService.getInstance()
        mPreferences = mActivity?.sharedPreferences

        mRootView = inflater.inflate(R.layout.fragment_nearby_stops, container, false)
        val mListView = mRootView!!.findViewById<ListView>(R.id.nearby_stops_list_view)

        mAdapter = StopCursorAdapter(mContext!!, mService!!.allStops)
        mListView.adapter = mAdapter

        setupSearch()

        Log.v(LOG_TAG, "No of routes found: " + mService!!.findAllPaths("2270"/*"Hari Nagar Clock Tower"*/, "978"/*"DDU Hospital"*/).count)

        return mRootView
    }

    private fun setupSearch() {

        Thread(Runnable {
            sourceSearchView = mRootView?.findViewById(R.id.fromSearchView)
            destinationSearchView = mRootView?.findViewById(R.id.toSearchView)

            val searchManager = mActivity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
            restoreSearchTerms()

            sourceSearchView?.setSearchableInfo(searchManager.getSearchableInfo(mActivity!!.componentName))
            destinationSearchView?.setSearchableInfo(searchManager.getSearchableInfo(mActivity!!.componentName))
            sourceSearchView?.isQueryRefinementEnabled = true
            destinationSearchView?.isQueryRefinementEnabled = true
            sourceSearchView?.isSubmitButtonEnabled = true
            destinationSearchView?.isSubmitButtonEnabled = true

            sourceSearchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    Log.d(LOG_TAG, "Q sub $query")
                    updateSharedPrefValue()
                    return true
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    return false
                }
            })
            destinationSearchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    Log.d(LOG_TAG, "Q sub $query")
                    updateSharedPrefValue()
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    return false
                }
            })
        }).start()

    }

    private fun restoreSearchTerms() {
        sourceSearchView?.setQuery(mPreferences?.getString(ROUTE_SOURCE_KEY, null), false)
        destinationSearchView?.setQuery(mPreferences?.getString(ROUTE_DESTINATION_KEY, null), false)
    }

    override fun onPause() {
        super.onPause()
        updateSharedPrefValue()
    }

    private fun updateSharedPrefValue() {
        val editor = mPreferences?.edit()

        if (editor != null) {
            editor.putString(ROUTE_SOURCE_KEY, sourceSearchView?.query.toString())
            editor.putString(ROUTE_DESTINATION_KEY, destinationSearchView?.query.toString())
            editor.apply()
        }
    }

    private inner class StopCursorAdapter internal constructor(context: Context, c: Cursor) : CursorAdapter(context, c) {

        override fun newView(context: Context, cursor: Cursor, viewGroup: ViewGroup): View {
            return LayoutInflater.from(context).inflate(R.layout.nearby_stops_item, viewGroup, false)
        }

        override fun bindView(view: View, context: Context, cursor: Cursor) {

            val textView = view.findViewById<TextView>(R.id.card_content)

            val snameIDX = cursor.getColumnIndexOrThrow(StaticDbHelper.COLUMN_NAME_STOP_NAME)
            val stopName = cursor.getString(snameIDX)

            val sidIDX = cursor.getColumnIndexOrThrow(StaticDbHelper.COLUMN_NAME_STOP_ID)
            val stopID = cursor.getInt(sidIDX)

            val text = stopID.toString() + "\t" + stopName
            textView.text = text

        }

    }

}
