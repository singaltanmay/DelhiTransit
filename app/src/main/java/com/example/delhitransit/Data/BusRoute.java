package com.example.delhitransit.Data;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "routes")
public class BusRoute {

    //All entries have this as null
    private String route_short_name;
    private String route_long_name;
    private int route_type;

    @PrimaryKey
    private int route_id;

    @Ignore
    public BusRoute(String route_long_name, int route_type, int route_id) {
        this.route_short_name = "";
        this.route_long_name = route_long_name;
        this.route_type = route_type;
        this.route_id = route_id;
    }

    public BusRoute(String route_short_name, String route_long_name, int route_type, int route_id) {
        this.route_short_name = route_short_name;
        this.route_long_name = route_long_name;
        this.route_type = route_type;
        this.route_id = route_id;
    }

    public String getRoute_short_name() {
        return route_short_name;
    }

    public void setRoute_short_name(String route_short_name) {
        this.route_short_name = route_short_name;
    }

    public String getRoute_long_name() {
        return route_long_name;
    }

    public void setRoute_long_name(String route_long_name) {
        this.route_long_name = route_long_name;
    }

    public int getRoute_type() {
        return route_type;
    }

    public void setRoute_type(int route_type) {
        this.route_type = route_type;
    }

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }
}
