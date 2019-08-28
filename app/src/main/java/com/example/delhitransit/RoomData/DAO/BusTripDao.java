package com.example.delhitransit.RoomData.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.delhitransit.RoomData.DataClasses.BusTrip;

import java.util.List;

@Dao
public interface BusTripDao {

    @Query("SELECT * FROM trips")
    List<BusTrip> loadAll();

    @Query("SELECT * FROM trips WHERE trip_id = :trip_id")
    List<BusTrip> loadHavingTripID(int trip_id);


    @Query("DELETE FROM trips")
    void deleteAll();


    @Query("SELECT COUNT(trip_id) FROM trips")
    int getNumberOfRows();


    @Insert
    void insertTrip(BusTrip trip);

}
