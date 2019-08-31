package com.example.delhitransit.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class StaticDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "staticData";
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

    // Names of various tables
    public static final String TABLE_NAME_STOPS = "stops";

    public static final  String TABLE_STOPS_CONTENT_AUTHORITY = STATIC_CONTENT_AUTHORITY + "." + TABLE_NAME_STOPS;
    public static final Uri TABLE_NAME_STOPS_CONTENT_URI = Uri.parse("content://" + TABLE_STOPS_CONTENT_AUTHORITY);

    // Create stops table
    public static final String SQL_CREATE_STOPS_TABLE =
            "CREATE TABLE " + TABLE_NAME_STOPS + " (" +
                    COLUMN_NAME_STOP_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_NAME_STOP_CODE + " TEXT, " +
                    COLUMN_NAME_STOP_NAME + " TEXT, " +
                    COLUMN_NAME_STOP_LATITUDE + " DOUBLE, " +
                    COLUMN_NAME_STOP_LONGITUDE + " DOUBLE);";

    // Drop stops table
    public static final String SQL_DROP_STOPS_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME_STOPS;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_STOPS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DROP_STOPS_TABLE);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
