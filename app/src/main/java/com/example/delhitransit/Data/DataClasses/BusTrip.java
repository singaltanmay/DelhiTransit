package com.example.delhitransit.Data.DataClasses;

import androidx.room.Entity;
import androidx.room.ForeignKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "trips",
        primaryKeys = {"route_id", "trip_id"})
//        foreignKeys = @ForeignKey(entity = BusRoute.class, parentColumns = "route_id", childColumns = "route_id", onDelete = CASCADE)

public class BusTrip {

    private int route_id;
    private int service_id;
    private int trip_id;

    public BusTrip(int route_id, int service_id, int trip_id) {
        this.route_id = route_id;
        this.service_id = service_id;
        this.trip_id = trip_id;
    }

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }
}
