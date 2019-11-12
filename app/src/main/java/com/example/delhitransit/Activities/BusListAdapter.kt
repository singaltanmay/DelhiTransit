package com.example.delhitransit.Activities

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import com.example.delhitransit.BusPositionUpdate
import com.example.delhitransit.R

class BusListAdapter(private var mDataset: List<BusPositionUpdate>?) : RecyclerView.Adapter<BusListAdapter.MyViewHolder>() {

    inner class MyViewHolder(// each data item is just a string in this case
            var textView: TextView) : RecyclerView.ViewHolder(textView)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // create a new view
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_bus, parent, false) as TextView

        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = mDataset!![position].toString()
    }

    override fun getItemCount(): Int {
        return if (mDataset != null) {
            mDataset!!.size
        } else 0
    }

    fun setDataset(mDataset: List<BusPositionUpdate>) {
        this.mDataset = mDataset
    }

}