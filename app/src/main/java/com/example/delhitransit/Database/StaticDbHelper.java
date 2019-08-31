package com.example.delhitransit.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class StaticDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "staticData.db";
    public static final short DATABASE_VERSION = 1;
    private Context context;

    // Default Constructor
    public StaticDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    public static final String STATIC_CONTENT_AUTHORITY = BaseContract.CONTENT_AUTHORITY + ".Database.StaticProvider";
    public static final Uri STATIC_CONTENT_URI = Uri.parse("content://" + STATIC_CONTENT_AUTHORITY);


    //  Names of various columns
    public static final String COLUMN_NAME_STOP_ID = "stop_id";
    public static final String COLUMN_NAME_STOP_CODE = "stop_code";
    public static final String COLUMN_NAME_STOP_NAME = "stop_name";
    public static final String COLUMN_NAME_STOP_LATITUDE = "stop_latitude";
    public static final String COLUMN_NAME_STOP_LONGITUDE = "stop_longitude";
    public static final String COLUMN_NAME_ROUTE_ID = "route_id";
    public static final String COLUMN_NAME_ROUTE_SHORT_NAME = "route_short_name";
    public static final String COLUMN_NAME_ROUTE_LONG_NAME = "route_long_name";
    public static final String COLUMN_NAME_ROUTE_TYPE = "route_type";

    // Names of various tables
    public static final String TABLE_NAME_STOPS = "stops_table";
    public static final String TABLE_NAME_ROUTES = "routes_table";

    // Uri pointing to this particular table
    public static final Uri TABLE_NAME_STOPS_CONTENT_URI = Uri.withAppendedPath(STATIC_CONTENT_URI, TABLE_NAME_STOPS);
    public static final Uri TABLE_NAME_ROUTES_CONTENT_URI = Uri.withAppendedPath(STATIC_CONTENT_URI, TABLE_NAME_ROUTES);

    // Create stops table
    public static final String SQL_CREATE_STOPS_TABLE =
            "CREATE TABLE " + TABLE_NAME_STOPS + " (" +
                    COLUMN_NAME_STOP_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_NAME_STOP_CODE + " TEXT, " +
                    COLUMN_NAME_STOP_NAME + " TEXT, " +
                    COLUMN_NAME_STOP_LATITUDE + " DOUBLE, " +
                    COLUMN_NAME_STOP_LONGITUDE + " DOUBLE);";

    // Create routes table
    public static final String SQL_CREATE_ROUTES_TABLE =
            "CREATE TABLE " + TABLE_NAME_ROUTES + " (" +
                    COLUMN_NAME_ROUTE_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_NAME_ROUTE_SHORT_NAME + " TEXT, " +
                    COLUMN_NAME_ROUTE_LONG_NAME + " TEXT, " +
                    COLUMN_NAME_ROUTE_TYPE + " INTEGER);";

    private void dropTable(SQLiteDatabase database, String tableName) {
        database.execSQL("DROP TABLE IF EXISTS " + tableName);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_STOPS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_ROUTES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        dropTable(sqLiteDatabase, TABLE_NAME_STOPS);
        dropTable(sqLiteDatabase, TABLE_NAME_ROUTES);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
