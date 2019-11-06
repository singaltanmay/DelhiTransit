package com.example.delhitransit.Activities;

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
import androidx.fragment.app.Fragment;

import com.example.delhitransit.Database.StaticDbHelper;
import com.example.delhitransit.R;

public class NearbyStopsFragment extends Fragment {

    private static String LOG_TAG = NearbyStopsFragment.class.getSimpleName();

    View rootView;
    AppService service;
    StopCursorAdapter adapter;
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        context = getContext();

        rootView = inflater.inflate(R.layout.fragment_nearby_stops, container, false);
        ListView listView = rootView.findViewById(R.id.nearby_stops_list_view);

        service = AppService.getInstance();

        adapter = new StopCursorAdapter(context, service.getAllStops());
                listView.setAdapter(adapter);


        return rootView;
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
