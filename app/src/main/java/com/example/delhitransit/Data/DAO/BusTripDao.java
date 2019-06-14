package com.example.delhitransit.Data.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.delhitransit.Data.DataClasses.BusTrip;

import java.util.List;

@Dao
public interface BusTripDao {

    @Query("SELECT * FROM trips")
    List<BusTrip> loadAllTrips();

    @Insert
    void insertTrip(BusTrip trip);

}
