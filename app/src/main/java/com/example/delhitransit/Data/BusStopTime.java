package com.example.delhitransit.Data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "stop_times", foreignKeys = {@ForeignKey(entity = BusStop.class,
        parentColumns = "stop_id", childColumns = "stop_id", onDelete = CASCADE),
        @ForeignKey(entity = BusTrip.class, parentColumns = "trip_id", childColumns = "trip_id", onDelete = CASCADE)})
public class BusStopTime {

    private int trip_id;
    private String arrival_time;
    private String departure_time;
    private long stop_id;
    @PrimaryKey
    private int stop_sequence;

    public BusStopTime(int trip_id, String arrival_time, String departure_time, long stop_id, int stop_sequence) {
        this.trip_id = trip_id;
        this.arrival_time = arrival_time;
        this.departure_time = departure_time;
        this.stop_id = stop_id;
        this.stop_sequence = stop_sequence;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public long getStop_id() {
        return stop_id;
    }

    public void setStop_id(long stop_id) {
        this.stop_id = stop_id;
    }

    public int getStop_sequence() {
        return stop_sequence;
    }

    public void setStop_sequence(int stop_sequence) {
        this.stop_sequence = stop_sequence;
    }
}
