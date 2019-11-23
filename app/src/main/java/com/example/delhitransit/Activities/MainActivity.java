package com.example.delhitransit.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.delhitransit.BusPositionUpdate;
import com.example.delhitransit.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<? extends BusPositionUpdate>>, OnMapReadyCallback {

    //LOG_TAG
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG, "Current time : " + System.currentTimeMillis() / 1000);

        initAppService();
        initNavFab();
        initUpdatesList();
        initMap();

    }

    private void initAppService() {
        // Launches app background service that provides Database access and fetches data from the internet
        Intent intent = new Intent(MainActivity.this, AppService.class);
        startService(intent);
        Log.v(LOG_TAG, "Starting AppService");
    }

    private void initNavFab() {
        FloatingActionButton floatingActionButton = findViewById(R.id.navigateFAB);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StopsSearchActivity.class));
            }
        });
    }

    private void initUpdatesList() {

        // Initialize loader that keeps recycler view updated
        getSupportLoaderManager().initLoader(2924, null, this);
    }

    private void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


    @Override
    public Loader<List<? extends BusPositionUpdate>> onCreateLoader(int i, Bundle bundle) {
        return new VehiclePositionLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<? extends BusPositionUpdate>> loader, List<? extends BusPositionUpdate> feedEntities) {
        // Log the number of entries received by loader
        Log.v(LOG_TAG, "List Size Received by Loader : " + feedEntities.size());

    }

    @Override
    public void onLoaderReset(Loader<List<? extends BusPositionUpdate>> loader) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_open_app_pref: {

                startActivity(new Intent(MainActivity.this, SettingsActivity.class));

                break;
            }
        }

        return false;
    }
}
