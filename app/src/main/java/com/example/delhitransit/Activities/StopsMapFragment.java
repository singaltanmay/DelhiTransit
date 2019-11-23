package com.example.delhitransit.Activities;


import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.delhitransit.BusStop;
import com.example.delhitransit.R;

import java.util.ArrayList;

public class StopsMapFragment extends Fragment {


    public StopsMapFragment() {
        // Required empty public constructor
    }

    private AppService service;

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

        Cursor allStopsWithinRange = service.getAllStopsWithinRange(28.7012333333333, 77.2212666666667, service.getStopRange(), null);
        ArrayList<BusStop> busStops = BusStop.parser.parseCursor(allStopsWithinRange);

        for (BusStop busStop : busStops) {
            textView.append(busStop.getStopID() + "\t" + busStop.getStopName() + "\n");
        }

        return rootView;
    }

}
