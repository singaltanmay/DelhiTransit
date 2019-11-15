package com.example.delhitransit

data class BusPositionUpdate(var vehicleID : String = "",var tripID: String? = null,var routeID: String? = null,var latitude: Float = 0.toFloat(),var longitude: Float = 0.toFloat(),var speed: Float = 0.toFloat(),var timestamp: Long = 0){

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
