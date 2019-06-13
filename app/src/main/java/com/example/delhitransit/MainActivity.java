package com.example.delhitransit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;

import com.example.delhitransit.Data.AppDatabase;
import com.example.delhitransit.Data.BusRoute;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<GtfsRealtime.FeedEntity>> {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private static BusListAdapter adapter;
    private static AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = AppDatabase.getInstance(getApplicationContext());
        BusRoute route = new BusRoute("Short name", "Long name", 3, 1384);


        RecyclerView busListView = findViewById(R.id.bus_list);
        busListView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BusListAdapter(null);
        busListView.setAdapter(adapter);

        getLoaderManager().initLoader(2924, null, this);

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
