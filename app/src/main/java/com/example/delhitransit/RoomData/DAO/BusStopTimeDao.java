package com.example.delhitransit.RoomData.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.delhitransit.RoomData.DataClasses.BusStopTime;

import java.util.List;

@Dao
public interface BusStopTimeDao {


    @Query("SELECT * FROM stop_times")
    List<BusStopTime> loadAll();

    @Query("SELECT * FROM stop_times WHERE stop_id = :stop_code")
    List<BusStopTime> loadHavingStopCode(long stop_code);

    @Query("DELETE FROM stop_times")
    void deleteAll();

    @Insert
    void insertRoute(BusStopTime stopTime);

}
