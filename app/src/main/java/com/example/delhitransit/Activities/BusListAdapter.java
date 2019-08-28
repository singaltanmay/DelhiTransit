package com.example.delhitransit.Activities;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.delhitransit.RoomData.DataClasses.BusPositionUpdate;
import com.example.delhitransit.R;

import java.util.List;

public class BusListAdapter extends RecyclerView.Adapter<BusListAdapter.MyViewHolder> {

    private List<BusPositionUpdate> mDataset;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;

        public MyViewHolder(TextView v) {
            super(v);
            textView = v;
        }
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
        holder.textView.setText(mDataset.get(position).toString());
    }

    @Override
    public int getItemCount() {
        if (mDataset != null) {
            return mDataset.size();
        }
        return 0;
    }

    public void setDataset(List<BusPositionUpdate> mDataset) {
        this.mDataset = mDataset;
    }

    public BusListAdapter(List<BusPositionUpdate> myDataset) {
        mDataset = myDataset;
    }

}