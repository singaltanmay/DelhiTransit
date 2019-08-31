package com.example.delhitransit.Activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.delhitransit.RoomData.AppDatabase;
import com.example.delhitransit.RoomData.DAO.BusRouteDao;
import com.example.delhitransit.RoomData.DAO.BusTripDao;
import com.example.delhitransit.RoomData.DataClasses.BusRoute;
import com.example.delhitransit.RoomData.DataClasses.BusStop;
import com.example.delhitransit.RoomData.DataClasses.BusStopTime;
import com.example.delhitransit.RoomData.DataClasses.BusTrip;
import com.example.delhitransit.R;

import java.util.List;

public class NearbyStopsFragment extends Fragment {

    private final FragmentActivity activity = getActivity();
    private final AppDatabase database = AppDatabase.getInstance(activity);

    public NearbyStopsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nearby_stops, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.nearbly_stops_recycler_view);
        StopsAdapter adapter = new StopsAdapter();
        //TODO get data from table
        adapter.mDataset = null;
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        return view;
    }

    private class StopsAdapter extends RecyclerView.Adapter<StopsAdapter.MyViewHolder> {

        private List<BusStop> mDataset;


        private BusTripDao busTripDao = database.getBusTripDao();
        private BusRouteDao busRouteDao = database.getBusRouteDao();

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.nearby_stops_item, parent, false);

            MyViewHolder vh = new MyViewHolder(frameLayout);
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            BusStop currentStop = mDataset.get(position);

            FrameLayout layout = ((FrameLayout) holder.view);
            TextView textView = layout.findViewById(R.id.card_content);

            StringBuilder builder = new StringBuilder();

            builder.append(currentStop.getStop_name());

            List<BusStopTime> busStopTimes = database.getBusStopTimeDao().loadHavingStopCode(currentStop.getStop_id());


            for (BusStopTime x : busStopTimes) {
                int trip_id = x.getTrip_id();
                List<BusTrip> busTrips = busTripDao.loadHavingTripID(trip_id);

                for (BusTrip y : busTrips) {

                    int route_id = y.getRoute_id();
                    BusRoute route = busRouteDao.loadHavingRouteID(route_id);
                    String route_long_name = route.getRoute_long_name();
                    builder.append("\n");
                    builder.append(route_long_name);

                }

            }

            textView.setText(builder.toString());

        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }

        private class MyViewHolder extends RecyclerView.ViewHolder {

            public View view;

            public MyViewHolder(View v) {
                super(v);
                this.view = v;
            }

        }

    }

}
