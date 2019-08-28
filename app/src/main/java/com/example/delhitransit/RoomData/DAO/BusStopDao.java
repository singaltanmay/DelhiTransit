package com.example.delhitransit.RoomData.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.delhitransit.RoomData.DataClasses.BusStop;

import java.util.List;

@Dao
public interface BusStopDao {


    @Query("SELECT * FROM stops")
    List<BusStop> loadAll();

    @Query("DELETE FROM stops")
    void deleteAll();


    @Query("SELECT COUNT(stop_id) FROM stops")
    int getNumberOfRows();

    @Insert
    void insertBusStop(BusStop stop);

}
