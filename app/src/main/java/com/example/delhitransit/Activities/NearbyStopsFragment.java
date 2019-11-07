package com.example.delhitransit.Activities;

import android.app.SearchManager;
import android.content.Context;
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
import androidx.fragment.app.FragmentActivity;

import com.example.delhitransit.Database.StaticDbHelper;
import com.example.delhitransit.R;

public class NearbyStopsFragment extends Fragment {

    private static String LOG_TAG = NearbyStopsFragment.class.getSimpleName();
    private static final String ROUTE_SOURCE_KEY = "xxfn398a";
    private static final String ROUTE_DESTINATION_KEY = "3fh90n398a";

    private Bundle saveBundle;

    private View rootView;
    private AppService service;
    private StopCursorAdapter adapter;
    private Context context;
    private FragmentActivity activity;
    private androidx.appcompat.widget.SearchView sourceSearchView;
    private androidx.appcompat.widget.SearchView destinationSearchView;

    @Override
    public void onStart() {
        super.onStart();
        if (getArguments() != null) saveBundle = getArguments();
        if (sourceSearchView != null && destinationSearchView != null) restoreSearchTerms();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        context = getContext();
        activity = getActivity();


        rootView = inflater.inflate(R.layout.fragment_nearby_stops, container, false);
        ListView listView = rootView.findViewById(R.id.nearby_stops_list_view);

        service = AppService.getInstance();

        adapter = new StopCursorAdapter(context, service.getAllStops());
        listView.setAdapter(adapter);

        setupSearch();


        return rootView;
    }

    private void setupSearch() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                SearchManager searchManager = (SearchManager) activity.getSystemService(Context.SEARCH_SERVICE);
                sourceSearchView = rootView.findViewById(R.id.fromSearchView);
                destinationSearchView = rootView.findViewById(R.id.toSearchView);
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
                        Log.v(LOG_TAG, "Query from callback " + sourceSearchView.getQuery());

                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        return onQueryTextSubmit(newText);
                    }
                });
                destinationSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        return onQueryTextSubmit(newText);
                    }
                });


            }
        });

        thread.start();

    }

    private void restoreSearchTerms(){
        if (saveBundle != null) {
            sourceSearchView.setQuery(saveBundle.getString(ROUTE_SOURCE_KEY), false);
            destinationSearchView.setQuery(saveBundle.getString(ROUTE_DESTINATION_KEY), false);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        saveFragState();
    }

    private Bundle saveFragState() {
        Bundle bundle = new Bundle();
        bundle.putString(ROUTE_SOURCE_KEY, sourceSearchView.getQuery().toString());
        bundle.putString(ROUTE_DESTINATION_KEY, destinationSearchView.getQuery().toString());
        final StopsSearchActivity myactivity = (StopsSearchActivity) activity;
        myactivity.saveFragState(bundle);
        return bundle;
    }

    private class StopCursorAdapter extends CursorAdapter {

        public StopCursorAdapter(Context context, Cursor c) {
            super(context, c);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            return LayoutInflater.from(context).inflate(R.layout.nearby_stops_item, viewGroup, false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {

            TextView textView = view.findViewById(R.id.card_content);

            int columnIndexOrThrow = cursor.getColumnIndexOrThrow(StaticDbHelper.COLUMN_NAME_STOP_NAME);
            String string = cursor.getString(columnIndexOrThrow);

            textView.setText(string);

        }


    }

}
