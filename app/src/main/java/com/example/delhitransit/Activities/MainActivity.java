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

import com.example.delhitransit.Data.DataClasses.BusPosition;
import com.example.delhitransit.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<BusPosition>> {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private static BusListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG, "Current time : " + System.currentTimeMillis() / 1000 );

        launchAppService();

        RecyclerView busListView = findViewById(R.id.bus_list);
        busListView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BusListAdapter(null);
        busListView.setAdapter(adapter);

        getLoaderManager().initLoader(2924, null, this);

    }

    private void launchAppService() {
        Intent intent = new Intent(MainActivity.this, DatabaseInitializerService.class);
        startService(intent);
        Log.d(LOG_TAG, "Starting DatabaseInitializerService");
    }

    @Override
    public Loader<List<BusPosition>> onCreateLoader(int i, Bundle bundle) {
        return new VehiclePositionLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<BusPosition>> loader, List<BusPosition> feedEntities) {
        Log.d(LOG_TAG, "List Size Recieved by Loader : " + feedEntities.size());
        adapter.setDataset(feedEntities);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(Loader<List<BusPosition>> loader) {
        adapter.setDataset(null);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.main_activity_action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_open_nearby_stops_fragment:
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(android.R.id.content, new NearbyStopsFragment());
                transaction.commit();
                break;
        }

        return true;
    }
}
