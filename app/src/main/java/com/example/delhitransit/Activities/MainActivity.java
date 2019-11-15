package com.example.delhitransit.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.delhitransit.BusPositionUpdate;
import com.example.delhitransit.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<? extends BusPositionUpdate>> {

    //LOG_TAG
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private static BusListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG, "Current time : " + System.currentTimeMillis() / 1000);


        initAppService();
        initNavFab();
        initUpdatesList();

    }

    private void initAppService() {
        // Launches app background service that provides Database access and fetches data from the internet
        Intent intent = new Intent(MainActivity.this, AppService.class);
        startService(intent);
        Log.v(LOG_TAG, "Starting AppService");
    }

    private void initNavFab(){
        FloatingActionButton floatingActionButton = findViewById(R.id.navigateFAB);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StopsSearchActivity.class));
            }
        });
    }

    private void initUpdatesList(){
        // Recycler View to show data fetched from server
        RecyclerView busListView = findViewById(R.id.bus_list);
        busListView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BusListAdapter(null);
        busListView.setAdapter(adapter);

        // Initialize loader that keeps recycler view updated
        getLoaderManager().initLoader(2924, null, this);
    }

    @Override
    public Loader<List<? extends BusPositionUpdate>> onCreateLoader(int i, Bundle bundle) {
        return new VehiclePositionLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<? extends BusPositionUpdate>> loader, List<? extends BusPositionUpdate> feedEntities) {
        // Log the number of entries received by loader
        Log.v(LOG_TAG, "List Size Received by Loader : " + feedEntities.size());

        // Set new data-set on the adapter
        adapter.setDataset((List<BusPositionUpdate>) feedEntities);
        // Update the adapter
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(Loader<List<? extends BusPositionUpdate>> loader) {
        // Set null data-set on the adapter
        adapter.setDataset(null);
        // Clear the adapter
        adapter.notifyDataSetChanged();
    }

}
