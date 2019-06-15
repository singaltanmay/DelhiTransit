package com.example.delhitransit.Data.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.delhitransit.Data.DataClasses.BusTrip;

import java.util.List;

@Dao
public interface BusTripDao {

    @Query("SELECT * FROM trips")
    List<BusTrip> loadAll();


    @Query("DELETE FROM trips")
    void deleteAll();


    @Query("SELECT COUNT(trip_id) FROM trips")
    int getNumberOfRows();


    @Insert
    void insertTrip(BusTrip trip);

}
