package com.example.delhitransit.Data.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.delhitransit.Data.DataClasses.BusRoute;

import java.util.List;

@Dao
public interface BusRouteDao {

    @Query("SELECT * FROM routes")
    List<BusRoute> loadAll();

    @Query("SELECT * FROM routes WHERE route_id = :id")
    BusRoute loadHavingRouteID(int id);

    @Query("DELETE FROM routes")
    void deleteAll();

    @Query("SELECT COUNT(route_id) FROM routes")
    int getNumberOfRows();

    @Insert
    void insertRoute(BusRoute route);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateRoute(BusRoute route);

}
