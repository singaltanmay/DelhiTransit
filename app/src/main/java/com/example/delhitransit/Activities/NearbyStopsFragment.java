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

import com.example.delhitransit.Data.AppDatabase;
import com.example.delhitransit.Data.DataClasses.BusStop;
import com.example.delhitransit.R;

import java.util.List;

public class NearbyStopsFragment extends Fragment {


    public NearbyStopsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nearby_stops, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.nearbly_stops_recycler_view);
        FragmentActivity activity = getActivity();
        StopsAdapter adapter = new StopsAdapter();
        adapter.mDataset = AppDatabase.getInstance(activity).getBusStopDao().loadAll();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        return view;
    }

    private class StopsAdapter extends RecyclerView.Adapter<StopsAdapter.MyViewHolder> {

        private List<BusStop> mDataset;

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.nearby_stops_item, parent, false);

            MyViewHolder vh = new MyViewHolder(frameLayout);
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            FrameLayout layout = ((FrameLayout) holder.view);
            TextView textView = layout.findViewById(R.id.card_content);
            textView.setText(mDataset.get(position).toString());

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
