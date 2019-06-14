package com.example.delhitransit.Data.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.delhitransit.Data.DataClasses.BusStopTime;

import java.util.List;

@Dao
public interface BusStopTimeDao {


    @Query("SELECT * FROM routes")
    List<BusStopTime> loadAllStopTimes();

    @Insert
    void insertRoute(BusStopTime stopTime);

}
