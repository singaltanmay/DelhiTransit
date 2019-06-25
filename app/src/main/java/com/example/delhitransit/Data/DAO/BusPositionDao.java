package com.example.delhitransit.Data.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.delhitransit.Data.DataClasses.BusPosition;

import java.util.List;

@Dao
public interface BusPositionDao {

    @Query("SELECT * FROM positions")
    List<BusPosition> loadAll();

    @Query("DELETE FROM positions")
    void deleteAll();

    @Query("SELECT COUNT(vehicleID) FROM positions")
    int getNumberOfRows();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBusPosition(BusPosition position);
}
