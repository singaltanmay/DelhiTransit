package com.example.delhitransit.Data.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.delhitransit.Data.DataClasses.BusPositionUpdate;

import java.util.List;

@Dao
public interface BusPositionDao {

    @Query("SELECT * FROM BusPositionUpdate")
    List<BusPositionUpdate> loadAll();

    @Query("DELETE FROM BusPositionUpdate")
    void deleteAll();

    @Query("SELECT COUNT(vehicleID) FROM BusPositionUpdate")
    int getNumberOfRows();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBusPosition(BusPositionUpdate position);
}
