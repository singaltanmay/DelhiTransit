package com.example.delhitransit.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;

import com.example.delhitransit.GtfsRealtime;
import com.example.delhitransit.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<GtfsRealtime.FeedEntity>> {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private static BusListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkFirstRun();

        RecyclerView busListView = findViewById(R.id.bus_list);
        busListView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BusListAdapter(null);
        busListView.setAdapter(adapter);

        getLoaderManager().initLoader(2924, null, this);

    }

    private void checkFirstRun() {
        Intent intent = new Intent(MainActivity.this, DatabaseInitializerService.class);
        startService(intent);
        Log.d(LOG_TAG, "Starting DatabaseInitializerService");
    }

    @Override
    public Loader<List<GtfsRealtime.FeedEntity>> onCreateLoader(int i, Bundle bundle) {
        return new VehiclePositionLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<GtfsRealtime.FeedEntity>> loader, List<GtfsRealtime.FeedEntity> feedEntities) {
        Log.d(LOG_TAG, "List Size Recieved by Loader : " + feedEntities.size());
        adapter.setmDataset(feedEntities);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(Loader<List<GtfsRealtime.FeedEntity>> loader) {
        adapter.setmDataset(null);
        adapter.notifyDataSetChanged();
    }

}
