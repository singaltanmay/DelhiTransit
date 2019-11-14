package com.example.delhitransit.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.delhitransit.BusPositionUpdate;
import com.example.delhitransit.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<BusPositionUpdate>> {

    //LOG_TAG
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private static BusListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG, "Current time : " + System.currentTimeMillis() / 1000);

        // Launches app background service that provides database access and fetches data from the internet
        launchAppService();

        // Recycler View to show data fetched from server
        RecyclerView busListView = findViewById(R.id.bus_list);
        busListView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BusListAdapter(null);
        busListView.setAdapter(adapter);

        // Initialize loader that keeps recycler view updated
        getLoaderManager().initLoader(2924, null, this);


    }

    private void launchAppService() {
        Intent intent = new Intent(MainActivity.this, AppService.class);
        startService(intent);
        Log.v(LOG_TAG, "Starting AppService");
    }

    @Override
    public Loader<List<BusPositionUpdate>> onCreateLoader(int i, Bundle bundle) {
        return new VehiclePositionLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<BusPositionUpdate>> loader, List<BusPositionUpdate> feedEntities) {
        // Log the number of entries received by loader
        Log.v(LOG_TAG, "List Size Received by Loader : " + feedEntities.size());

        // Set new data-set on the adapter
        adapter.setDataset(feedEntities);
        // Update the adapter
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(Loader<List<BusPositionUpdate>> loader) {
        // Set null data-set on the adapter
        adapter.setDataset(null);
        // Clear the adapter
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate action menu
        new MenuInflater(this).inflate(R.menu.main_activity_action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            // Replace content with NearbyStopsFragment
            case R.id.action_open_nearby_stops_fragment:
                //https://developer.android.com/guide/topics/search/search-dialog
//                Log.d(LOG_TAG, "Search status : " + onSearchRequested());

//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(android.R.id.content, new NearbyStopsFragment());
//                transaction.commit();

                startActivity(new Intent(MainActivity.this, StopsSearchActivity.class));

                break;
        }

        return true;
    }
}
