package com.example.delhitransit.Data.DataClasses;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.delhitransit.GtfsRealtime;

@Entity(tableName = "positions")
public class BusPositionUpdate {

    @PrimaryKey
    @NonNull
    private String vehicleID = "";

    private String tripID;
    private String routeID;
    private float latitude;
    private float longitude;
    private float speed;
    private long timestamp;

    public BusPositionUpdate(String vehicleID, String tripID, String routeID, float latitude, float longitude, float speed, long timestamp) {
        this.vehicleID = vehicleID;
        this.tripID = tripID;
        this.routeID = routeID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.speed = speed;
        this.timestamp = timestamp;
    }

    @Ignore
    public BusPositionUpdate() {
    }

    @Ignore
    public BusPositionUpdate parseFrom(GtfsRealtime.FeedEntity entity) {
        this.vehicleID = entity.getId();

        GtfsRealtime.VehiclePosition vehicle = entity.getVehicle();
        GtfsRealtime.TripDescriptor trip = vehicle.getTrip();
        GtfsRealtime.Position position = vehicle.getPosition();

        this.tripID = trip.getTripId();
        this.routeID = trip.getRouteId();

        this.latitude = position.getLatitude();
        this.longitude = position.getLongitude();
        this.speed = position.getSpeed();

        this.timestamp = vehicle.getTimestamp();

        return this;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public String getTripID() {
        return tripID;
    }

    public String getRouteID() {
        return routeID;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getSpeed() {
        return speed;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nVehicle ID:\t");
        builder.append(vehicleID);
        builder.append("\nTrip ID:\t");
        builder.append(tripID);
        builder.append("\nRoute ID:\t");
        builder.append(routeID);
        builder.append("\nBus Coordinates:\t");
        builder.append(latitude);
        builder.append(",");
        builder.append(longitude);
        builder.append("\nSpeed:\t");
        builder.append(speed);
        builder.append("\nTimestamp:\t");
        builder.append(timestamp);
        return builder.toString();
    }
}
