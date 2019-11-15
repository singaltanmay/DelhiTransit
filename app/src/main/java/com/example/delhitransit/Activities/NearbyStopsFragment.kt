package com.example.delhitransit.Activities

import android.app.SearchManager
import android.content.Context
import android.content.SharedPreferences
import android.database.Cursor
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.loader.app.LoaderManager
import androidx.loader.content.AsyncTaskLoader
import androidx.loader.content.Loader
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.delhitransit.Database.StaticDbHelper
import com.example.delhitransit.R

class NearbyStopsFragment : Fragment(), LoaderManager.LoaderCallbacks<Cursor> {

    // Equivalent to a static block in Java (kinda)
    companion object {
        private val LOG_TAG = NearbyStopsFragment::class.java.simpleName
        private const val ROUTE_SOURCE_KEY = "route_SKey"
        private const val ROUTE_DESTINATION_KEY = "route_DKey"
    }

    private var mRootView: View? = null
    private var mService: AppService? = null
    private var mAdapter: RoutesCursorAdapter? = null
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

        val mRecyclerView = mRootView!!.findViewById<RecyclerView>(R.id.nearby_stops_recycler_view)
        mRecyclerView.layoutManager = LinearLayoutManager(mContext)
        mAdapter = RoutesCursorAdapter(null)
        mRecyclerView.adapter = mAdapter

        setupSearch()

        loaderManager.initLoader(1921, null, this)

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

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> = RoutesLoader(this as Context)

    override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
        mAdapter?.setDataset(data)
        mAdapter?.notifyDataSetChanged()
    }

    override fun onLoaderReset(loader: Loader<Cursor>) {
        mAdapter?.setDataset(null)
        mAdapter?.notifyDataSetChanged()
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

    private inner class RoutesCursorAdapter(private var mDataset: Cursor?) : RecyclerView.Adapter<RoutesCursorAdapter.MyViewHolder>() {

        val snameIDX = mDataset?.getColumnIndexOrThrow(StaticDbHelper.COLUMN_NAME_STOP_NAME)
        val sidIDX = mDataset?.getColumnIndexOrThrow(StaticDbHelper.COLUMN_NAME_STOP_ID)

        private inner class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(LayoutInflater.from(context).inflate(R.layout.nearby_stops_item, parent, false))

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

            mDataset?.moveToPosition(position)

            val textView = holder.view.findViewById<TextView>(R.id.card_content)

            var stopName: String? = ""
            var stopID: Int? = -1


            if (snameIDX != null) {
                stopName = mDataset?.getString(snameIDX)
            }

            if (sidIDX != null) {
                stopID = mDataset?.getInt(sidIDX)
            }

            val text = stopID.toString() + "\t" + stopName
            textView.text = text
        }

        override fun getItemCount(): Int {
            return if (mDataset != null) {
                mDataset!!.count
            } else 0
        }

        fun setDataset(mDataset: Cursor?) {
            this.mDataset = mDataset
        }

    }

    private inner class RoutesLoader(context: Context) : AsyncTaskLoader<Cursor>(context) {

        override fun loadInBackground(): Cursor? = mService!!.allStops

    }
}