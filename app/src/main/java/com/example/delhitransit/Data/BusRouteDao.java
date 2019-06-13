package com.example.delhitransit.Data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BusRouteDao {

    @Query("SELECT * FROM routes")
    public List<BusRoute> loadAllRoutes();

    @Insert
    void insertRoute(BusRoute route);

}
