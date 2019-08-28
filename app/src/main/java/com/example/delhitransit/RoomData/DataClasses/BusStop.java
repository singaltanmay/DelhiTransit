package com.example.delhitransit.RoomData.DataClasses;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "stops")
public class BusStop {

    @PrimaryKey
    private long stop_id;

    private String stop_code;
    private String stop_name;
    private double stop_lat;
    private double stop_lon;

    public BusStop(long stop_id, String stop_code, String stop_name, double stop_lat, double stop_lon) {
        this.stop_id = stop_id;
        this.stop_code = stop_code;
        this.stop_name = stop_name;
        this.stop_lat = stop_lat;
        this.stop_lon = stop_lon;
    }

    public long getStop_id() {
        return stop_id;
    }

    public void setStop_id(long stop_id) {
        this.stop_id = stop_id;
    }

    public String getStop_code() {
        return stop_code;
    }

    public void setStop_code(String stop_code) {
        this.stop_code = stop_code;
    }

    public String getStop_name() {
        return stop_name;
    }

    public void setStop_name(String stop_name) {
        this.stop_name = stop_name;
    }

    public double getStop_lat() {
        return stop_lat;
    }

    public void setStop_lat(double stop_lat) {
        this.stop_lat = stop_lat;
    }

    public double getStop_lon() {
        return stop_lon;
    }

    public void setStop_lon(double stop_lon) {
        this.stop_lon = stop_lon;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nStop ID:\t");
        builder.append(stop_id);
        builder.append("\nStop Code:\t");
        builder.append(stop_code);
        builder.append("\nStop Name:\t");
        builder.append(stop_name);
        builder.append("\nStop Coordinates:\t");
        builder.append(stop_lat);
        builder.append(",");
        builder.append(stop_lon);
        return builder.toString();
    }
}
