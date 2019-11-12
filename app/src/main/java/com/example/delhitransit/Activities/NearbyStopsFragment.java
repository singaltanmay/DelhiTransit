package com.example.delhitransit.Activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.example.delhitransit.Database.StaticDbHelper;
import com.example.delhitransit.R;

public class NearbyStopsFragment extends Fragment {

    private static String LOG_TAG = NearbyStopsFragment.class.getSimpleName();
    private static final String ROUTE_SOURCE_KEY = "xxfn398a";
    private static final String ROUTE_DESTINATION_KEY = "3fh90n398a";
    private View rootView;
    private AppService service;
    private StopCursorAdapter adapter;
    private Context context;
    private StopsSearchActivity activity;
    private androidx.appcompat.widget.SearchView sourceSearchView;
    private androidx.appcompat.widget.SearchView destinationSearchView;
    private SharedPreferences sharedPreferences;

    @Override
    public void onStart() {
        super.onStart();
        if (sourceSearchView != null && destinationSearchView != null) restoreSearchTerms();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        context = getContext();
        activity = (StopsSearchActivity) getActivity();
        service = AppService.getInstance();
        sharedPreferences = activity.getSharedPreferences();

        rootView = inflater.inflate(R.layout.fragment_nearby_stops, container, false);
        ListView listView = rootView.findViewById(R.id.nearby_stops_list_view);

        adapter = new StopCursorAdapter(context, service.getAllStops());
        listView.setAdapter(adapter);

        setupSearch();

        Log.v(LOG_TAG,"No of routes found: " + service.findAllPaths("Hari Nagar Clock Tower","DDU Hospital").getCount());

        return rootView;
    }

    private void setupSearch() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                sourceSearchView = rootView.findViewById(R.id.fromSearchView);
                destinationSearchView = rootView.findViewById(R.id.toSearchView);

                SearchManager searchManager = (SearchManager) activity.getSystemService(Context.SEARCH_SERVICE);
                restoreSearchTerms();
                sourceSearchView.setSearchableInfo(searchManager.getSearchableInfo(activity.getComponentName()));
                destinationSearchView.setSearchableInfo(searchManager.getSearchableInfo(activity.getComponentName()));
                sourceSearchView.setQueryRefinementEnabled(true);
                destinationSearchView.setQueryRefinementEnabled(true);
                sourceSearchView.setSubmitButtonEnabled(true);
                destinationSearchView.setSubmitButtonEnabled(true);

                sourceSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        Log.d(LOG_TAG, "Q sub " + query);
                        updateSharedPrefValue();
                        return true;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        return false;
                    }
                });
                destinationSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        Log.d(LOG_TAG, "Q sub " + query);
                        updateSharedPrefValue();
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        return false;
                    }
                });


            }
        });

        thread.start();

    }

    private void restoreSearchTerms() {
        sourceSearchView.setQuery(sharedPreferences.getString(ROUTE_SOURCE_KEY, null), false);
        destinationSearchView.setQuery(sharedPreferences.getString(ROUTE_DESTINATION_KEY, null), false);
    }

    @Override
    public void onPause() {
        super.onPause();
        updateSharedPrefValue();
    }

    private void updateSharedPrefValue() {

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(ROUTE_SOURCE_KEY, sourceSearchView.getQuery().toString());
        editor.putString(ROUTE_DESTINATION_KEY, destinationSearchView.getQuery().toString());

        editor.apply();
    }

    private class StopCursorAdapter extends CursorAdapter {

        StopCursorAdapter(Context context, Cursor c) {
            super(context, c);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            return LayoutInflater.from(context).inflate(R.layout.nearby_stops_item, viewGroup, false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {

            TextView textView = view.findViewById(R.id.card_content);

            int snameIDX = cursor.getColumnIndexOrThrow(StaticDbHelper.COLUMN_NAME_STOP_NAME);
            String stopName = cursor.getString(snameIDX);

            int sidIDX = cursor.getColumnIndexOrThrow(StaticDbHelper.COLUMN_NAME_STOP_ID);
            int stopID = cursor.getInt(sidIDX);

            textView.setText(stopID + "\t" + stopName);

        }

    }

}
