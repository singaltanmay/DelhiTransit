package com.example.delhitransit.Data;


import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.delhitransit.Data.DAO.BusPositionDao;
import com.example.delhitransit.Data.DAO.BusRouteDao;
import com.example.delhitransit.Data.DAO.BusStopDao;
import com.example.delhitransit.Data.DAO.BusStopTimeDao;
import com.example.delhitransit.Data.DAO.BusTripDao;
import com.example.delhitransit.Data.DataClasses.BusPositionUpdate;
import com.example.delhitransit.Data.DataClasses.BusRoute;
import com.example.delhitransit.Data.DataClasses.BusStop;
import com.example.delhitransit.Data.DataClasses.BusStopTime;
import com.example.delhitransit.Data.DataClasses.BusTrip;

@Database(entities = {BusRoute.class, BusStop.class, BusStopTime.class, BusTrip.class, BusPositionUpdate.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_SHARED_PREF_KEY = "ubpsieg7832";
    public static final String DATABASE_IS_INITIALIZED_SHARED_PREF_KEY = "isInitialized";
    private static final String LOG_TAG = AppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "staticData";

    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context) {

        if (sInstance == null) {
             synchronized (LOCK) {
            Log.d(LOG_TAG, "Creating new database instance");
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, AppDatabase.DATABASE_NAME)
                    .allowMainThreadQueries()/*TODO Implement on separate thread*/
                    .build();
             }
        }
        Log.d(LOG_TAG, "Getting the database instance");
        return sInstance;

    }

    public abstract BusRouteDao getBusRouteDao();

    public abstract BusStopDao getBusStopDao();

    public abstract BusStopTimeDao getBusStopTimeDao();

    public abstract BusTripDao getBusTripDao();

    public abstract BusPositionDao getBusPositionDao();

}
