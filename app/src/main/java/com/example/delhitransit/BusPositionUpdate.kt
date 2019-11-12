package com.example.delhitransit

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "positions")
class BusPositionUpdate {

    @PrimaryKey
    var vehicleID = ""
        private set

    var tripID: String? = null
        private set
    var routeID: String? = null
        private set
    var latitude: Float = 0.toFloat()
        private set
    var longitude: Float = 0.toFloat()
        private set
    var speed: Float = 0.toFloat()
        private set
    var timestamp: Long = 0
        private set

    constructor(vehicleID: String, tripID: String, routeID: String, latitude: Float, longitude: Float, speed: Float, timestamp: Long) {
        this.vehicleID = vehicleID
        this.tripID = tripID
        this.routeID = routeID
        this.latitude = latitude
        this.longitude = longitude
        this.speed = speed
        this.timestamp = timestamp
    }

    @Ignore
    constructor()

    @Ignore
    fun parseFrom(entity: GtfsRealtime.FeedEntity): BusPositionUpdate {
        this.vehicleID = entity.id

        val vehicle = entity.vehicle
        val trip = vehicle.trip
        val position = vehicle.position

        this.tripID = trip.tripId
        this.routeID = trip.routeId

        this.latitude = position.latitude
        this.longitude = position.longitude
        this.speed = position.speed

        this.timestamp = vehicle.timestamp

        return this
    }

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("\nVehicle ID:\t")
        builder.append(vehicleID)
        builder.append("\nTrip ID:\t")
        builder.append(tripID)
        builder.append("\nRoute ID:\t")
        builder.append(routeID)
        builder.append("\nBus Coordinates:\t")
        builder.append(latitude)
        builder.append(",")
        builder.append(longitude)
        builder.append("\nSpeed:\t")
        builder.append(speed)
        builder.append("\nTimestamp:\t")
        builder.append(timestamp)
        return builder.toString()
    }
}
