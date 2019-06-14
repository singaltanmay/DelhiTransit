package com.example.delhitransit.Data.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.delhitransit.Data.DataClasses.BusStop;

import java.util.List;

@Dao
public interface BusStopDao {


    @Query("SELECT * FROM stops")
    List<BusStop> loadAllBusStops();

    @Query("DELETE FROM stops")
    void deleteAllStops();

    @Insert
    void insertBusStop(BusStop stop);

}
