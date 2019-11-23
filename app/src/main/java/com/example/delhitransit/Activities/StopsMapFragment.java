package com.example.delhitransit.Activities;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.delhitransit.BusStop;
import com.example.delhitransit.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import static android.content.Context.LOCATION_SERVICE;
import static androidx.constraintlayout.widget.Constraints.TAG;

public class StopsMapFragment extends Fragment implements OnMapReadyCallback, LocationListener {


    private final Context mContext;

    public StopsMapFragment(Context mContext) {
        // Required empty public constructor
        this.mContext = mContext;
    }

    private AppService service;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_stops_map, container, false);

        /**
         * App's service which handles all database related tasks in the background on a separate thread
         */
        service = AppService.getInstance();

        TextView textView = rootView.findViewById(R.id.fragTextView);

        /*Cursor allStopsWithinRange = service.getAllStopsWithinRange(28.7012333333333, 77.2212666666667, service.getStopRange(), null);
        ArrayList<BusStop> busStops = BusStop.parser.parseCursor(allStopsWithinRange);

        for (BusStop busStop : busStops) {
            textView.append(busStop.getStopID() + "\t" + busStop.getStopName() + "\n");
        }*/
        initMap();

        return rootView;
    }

    private void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap mMap) {

        boolean isNetworkEnabled;
        boolean isGPSEnabled;
        LocationManager locationManager;
        Location location = null;
        String provider_info = null;
        try {


            locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);
            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);


            if (isGPSEnabled) {
                provider_info = LocationManager.GPS_PROVIDER;

            } else if (isNetworkEnabled) {
                provider_info = LocationManager.NETWORK_PROVIDER;

            }

            if (!provider_info.isEmpty()) {

                if (locationManager != null) {
                    locationManager.requestLocationUpdates(provider_info, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    location = locationManager.getLastKnownLocation(provider_info);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Impossible to connect to LocationManager", e);
        }


        Cursor allStopsWithinRange = service.getAllStopsWithinRange(location.getLatitude(), location.getLongitude(), service.getStopRange(), null);
        ArrayList<BusStop> busStops = BusStop.parser.parseCursor(allStopsWithinRange);
        LatLng myLocation= new LatLng(location.getLatitude(), location.getLongitude());
        for (BusStop busStop : busStops) {
            LatLng marker = new LatLng(-34, 151);
            mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_stop_icon)).position(marker).title(busStop.getStopName()));
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
