package com.example.delhitransit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<GtfsRealtime.FeedEntity>> {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private static BusListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        InputStream file = null;
//
//        try {
//            file = (InputStream) new FileInputStream("src/VehiclePositions.pb");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        GtfsRealtime.FeedMessage feedMessage = null;
//        try {
//            feedMessage = GtfsRealtime.FeedMessage.parseFrom(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(feedMessage.toString());
//
//        List<GtfsRealtime.FeedEntity> entityList = feedMessage.getEntityList();
//
//        for (GtfsRealtime.FeedEntity entity : entityList) {
//
//            System.out.println("id: " + entity.getId() + " route: " + entity.getVehicle().getTrip().getRouteId() + " coordinates: " + entity.getVehicle().getPosition().getLatitude() + " " + entity.getVehicle().getPosition().getLongitude() + " speed: " + entity.getVehicle().getPosition().getSpeed());
//
//        }


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
        adapter.mDataset = feedEntities;
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(Loader<List<GtfsRealtime.FeedEntity>> loader) {
        adapter.mDataset = null;
        adapter.notifyDataSetChanged();
    }

    private class BusListAdapter extends RecyclerView.Adapter<BusListAdapter.MyViewHolder> {


        private List<GtfsRealtime.FeedEntity> mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class MyViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView textView;

            public MyViewHolder(TextView v) {
                super(v);
                textView = v;
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public BusListAdapter(List<GtfsRealtime.FeedEntity> myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public BusListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // create a new view
            TextView v = (TextView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_bus, parent, false);

            MyViewHolder vh = new MyViewHolder(v);
            return vh;
        }


        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(mDataset.get(position).getId());
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            if (mDataset != null) {
                return mDataset.size();
            }
            return 0;
        }

    }


    private static class VehiclePositionLoader extends AsyncTaskLoader<List<GtfsRealtime.FeedEntity>> {


        private String LOG_TAG = VehiclePositionLoader.class.getSimpleName();

        private VehiclePositionLoader(@NonNull Context context) {
            super(context);
        }


        @Override
        protected void onStartLoading() {
            forceLoad();
        }

        @Nullable
        @Override
        public List<GtfsRealtime.FeedEntity> loadInBackground() {
            Log.d(LOG_TAG, "Begin Loading");
            List<GtfsRealtime.FeedEntity> entityList = DataParser.fetchPositionData();

            for (GtfsRealtime.FeedEntity entity : entityList) {
                Log.v(LOG_TAG, entity.getId() + entity.getVehicle().getStopId());
            }

            return entityList;
        }
    }

}
