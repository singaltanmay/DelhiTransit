package com.example.delhitransit.Data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BusStopDao {


    @Query("SELECT * FROM stops")
    List<BusStop> loadAllBusStops();

    @Insert
    void insertBusStop(BusStop stop);

}
