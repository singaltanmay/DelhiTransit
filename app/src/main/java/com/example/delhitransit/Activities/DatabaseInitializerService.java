package com.example.delhitransit.Activities;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;


import com.example.delhitransit.Data.AppDatabase;
import com.example.delhitransit.Data.DataParser;


public class DatabaseInitializerService extends IntentService {

    private static final String LOG_TAG = DatabaseInitializerService.class.getSimpleName();

    public DatabaseInitializerService() {
        super("dbinitservice");
        Log.d(LOG_TAG, "Service constructed");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.d(LOG_TAG, "Service started");

        final SharedPreferences preferences = getSharedPreferences(AppDatabase.DATABASE_SHARED_PREF_KEY, MODE_PRIVATE);

        if (!preferences.contains(AppDatabase.DATABASE_IS_INITIALIZED_SHARED_PREF_KEY) ||
                !preferences.getBoolean(AppDatabase.DATABASE_IS_INITIALIZED_SHARED_PREF_KEY, false)) {
            Log.d(LOG_TAG, "Initializing the database");
            DataParser.initDb(getApplicationContext());
            preferences.edit().putBoolean(AppDatabase.DATABASE_IS_INITIALIZED_SHARED_PREF_KEY, true).apply();
        } else Log.d(LOG_TAG, "Database is already initialized. Nothing to do.");


        Log.d(LOG_TAG, "Killing service");
        this.stopSelf();
        Log.d(LOG_TAG, "Apparently not");
    }

}

