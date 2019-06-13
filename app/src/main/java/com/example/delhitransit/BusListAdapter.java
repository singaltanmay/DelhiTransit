package com.example.delhitransit;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BusListAdapter extends RecyclerView.Adapter<BusListAdapter.MyViewHolder> {

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

    public void setmDataset(List<GtfsRealtime.FeedEntity> mDataset) {
        this.mDataset = mDataset;
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public BusListAdapter(List<GtfsRealtime.FeedEntity> myDataset) {
        mDataset = myDataset;
    }

}