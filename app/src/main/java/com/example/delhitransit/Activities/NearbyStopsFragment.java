package com.example.delhitransit.Activities;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.delhitransit.R;

public class NearbyStopsFragment extends Fragment {

    private static String LOG_TAG = NearbyStopsFragment.class.getSimpleName();

    View rootView;
    AppService service;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_nearby_stops, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.nearby_stops_recycler_view);

        service = AppService.getInstance();

        Log.d(LOG_TAG,"Instance of AppService received : " + service);

        return rootView;
    }

}
