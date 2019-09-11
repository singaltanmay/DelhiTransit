package com.example.delhitransit.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.BaseColumns;

public class DynamicDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "dynamicData.db";
    public static final int DATABASE_VERSION = 1;
    private Context context;

    // Default Constructor
    public DynamicDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public static final String DYNAMIC_CONTENT_AUTHORITY = BaseContract.CONTENT_AUTHORITY + ".Database.DynamicProvider";
    public static final Uri DYNAMIC_CONTENT_URI = Uri.parse("content://" + DYNAMIC_CONTENT_AUTHORITY);

    // Names of various columns
    public static final String COLUMN_NAME_ID = BaseColumns._ID;
    public static final String COLUMN_NAME_VEHICLE_ID = "vehicle_id";
    public static final String COLUMN_NAME_TRIP_ID = StaticDbHelper.COLUMN_NAME_TRIP_ID;
    public static final String COLUMN_NAME_ROUTE_ID = StaticDbHelper.COLUMN_NAME_ROUTE_ID;
    public static final String COLUMN_NAME_VEHICLE_LATITUDE = "vehicle_latitude";
    public static final String COLUMN_NAME_VEHICLE_LONGITUDE = "vehicle_longitude";
    public static final String COLUMN_NAME_VEHICLE_SPEED = "vehicle_speed";
    public static final String COLUMN_NAME_UPDATE_TIMESTAMP = "update_timestamp";

    // Names of various tables
    public static final String TABLE_NAME_VEHICLE_POSITION_UPDATE = "position_update";

    // Uri pointing to this particular table
    public static final Uri TABLE_NAME_VEHICLE_POSITION_UPDATE_CONTENT_URI = Uri.withAppendedPath(DYNAMIC_CONTENT_URI, TABLE_NAME_VEHICLE_POSITION_UPDATE);

    // Create stops table
    public static final String SQL_CREATE_VEHICLE_POSITION_UPDATE_TABLE =
            "CREATE TABLE " + TABLE_NAME_VEHICLE_POSITION_UPDATE + " (" +
                    COLUMN_NAME_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_NAME_VEHICLE_ID + " TEXT, " +
                    COLUMN_NAME_TRIP_ID + " TEXT, " +
                    COLUMN_NAME_ROUTE_ID + " TEXT, " +
                    COLUMN_NAME_VEHICLE_LATITUDE + " DOUBLE, " +
                    COLUMN_NAME_VEHICLE_LONGITUDE + " DOUBLE, " +
                    COLUMN_NAME_VEHICLE_SPEED + " DOUBLE, " +
                    COLUMN_NAME_UPDATE_TIMESTAMP + " INTEGER);";

    private void dropTable(SQLiteDatabase database, String tableName) {
        database.execSQL("DROP TABLE IF EXISTS " + tableName);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_VEHICLE_POSITION_UPDATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        dropTable(sqLiteDatabase, TABLE_NAME_VEHICLE_POSITION_UPDATE);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
