package com.example.delhitransit.RoomData.DataClasses;

import androidx.room.Entity;

@Entity(tableName = "stop_times", primaryKeys = {"trip_id", "stop_sequence"})
//foreignKeys = {@ForeignKey(entity = BusStop.class,
//        parentColumns = "stop_id", childColumns = "stop_id", onDelete = CASCADE)
//        @ForeignKey(entity = BusTrip.class, parentColumns = "trip_id", childColumns = "trip_id", onDelete = CASCADE)}

public class BusStopTime {

    private int trip_id;
    private long arrival_time;
    private long departure_time;
    private long stop_id;
    private int stop_sequence;

    public BusStopTime(int trip_id, long arrival_time, long departure_time, long stop_id, int stop_sequence) {
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

    public long getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(long arrival_time) {
        this.arrival_time = arrival_time;
    }

    public long getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(long departure_time) {
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
