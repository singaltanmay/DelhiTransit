package com.example.delhitransit.RoomData.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.delhitransit.RoomData.DataClasses.BusPositionUpdate;

import java.util.List;

@Dao
public interface BusPositionDao {

    @Query("SELECT * FROM positions")
    List<BusPositionUpdate> loadAll();

    @Query("DELETE FROM positions")
    void deleteAll();

    @Query("SELECT COUNT(vehicleID) FROM positions")
    int getNumberOfRows();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBusPosition(BusPositionUpdate position);
}
