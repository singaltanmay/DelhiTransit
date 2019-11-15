package com.example.delhitransit.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.net.Uri
import android.provider.BaseColumns

class StaticDbHelper(private val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    private fun dropTable(database: SQLiteDatabase, tableName: String) {
        database.execSQL("DROP TABLE IF EXISTS $tableName")
    }

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_STOPS_TABLE)
        sqLiteDatabase.execSQL(SQL_CREATE_ROUTES_TABLE)
        sqLiteDatabase.execSQL(SQL_CREATE_TRIPS_TABLE)
        sqLiteDatabase.execSQL(SQL_CREATE_STOP_TIMES_TABLE)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        dropTable(sqLiteDatabase, TABLE_NAME_STOPS)
        dropTable(sqLiteDatabase, TABLE_NAME_ROUTES)
        dropTable(sqLiteDatabase, TABLE_NAME_TRIPS)
        dropTable(sqLiteDatabase, TABLE_NAME_STOP_TIMES)
        onCreate(sqLiteDatabase)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    companion object {

        const val DATABASE_NAME = "staticData.db"
        const val DATABASE_VERSION = 1


        val STATIC_CONTENT_AUTHORITY = BaseContract.CONTENT_AUTHORITY + ".database.StaticProvider"
        val STATIC_CONTENT_URI = Uri.parse("content://$STATIC_CONTENT_AUTHORITY")


        //  Names of various columns
        const val COLUMN_NAME_BASE_ID = BaseColumns._ID
        const val COLUMN_NAME_STOP_ID = "stop_id"
        const val COLUMN_NAME_STOP_CODE = "stop_code"
        const val COLUMN_NAME_STOP_NAME = "stop_name"
        const val COLUMN_NAME_STOP_LATITUDE = "stop_latitude"
        const val COLUMN_NAME_STOP_LONGITUDE = "stop_longitude"
        const val COLUMN_NAME_ROUTE_ID = "route_id"
        const val COLUMN_NAME_ROUTE_SHORT_NAME = "route_short_name"
        const val COLUMN_NAME_ROUTE_LONG_NAME = "route_long_name"
        const val COLUMN_NAME_ROUTE_TYPE = "route_type"
        const val COLUMN_NAME_TRIP_ID = "trip_id"
        const val COLUMN_NAME_SERVICE_ID = "service_id"
        const val COLUMN_NAME_ARRIVAL_TIME = "arrival_time"
        const val COLUMN_NAME_DEPARTURE_TIME = "departure_time"
        const val COLUMN_NAME_STOP_SEQUENCE = "stop_sequence"

        // Names of various tables
        const val TABLE_NAME_STOPS = "stops_table"
        const val TABLE_NAME_ROUTES = "routes_table"
        const val TABLE_NAME_TRIPS = "trips_table"
        const val TABLE_NAME_STOP_TIMES = "stop_times_table"

        // Uri pointing to this particular table
        val TABLE_NAME_STOPS_CONTENT_URI = Uri.withAppendedPath(STATIC_CONTENT_URI, TABLE_NAME_STOPS)
        val TABLE_NAME_ROUTES_CONTENT_URI = Uri.withAppendedPath(STATIC_CONTENT_URI, TABLE_NAME_ROUTES)
        val TABLE_NAME_TRIPS_CONTENT_URI = Uri.withAppendedPath(STATIC_CONTENT_URI, TABLE_NAME_TRIPS)
        val TABLE_NAME_STOP_TIMES_CONTENT_URI = Uri.withAppendedPath(STATIC_CONTENT_URI, TABLE_NAME_STOP_TIMES)

        // Create stops table
        const val SQL_CREATE_STOPS_TABLE = "CREATE TABLE $TABLE_NAME_STOPS ($COLUMN_NAME_BASE_ID INTEGER PRIMARY KEY, " +
                "$COLUMN_NAME_STOP_ID INTEGER, $COLUMN_NAME_STOP_CODE TEXT, $COLUMN_NAME_STOP_NAME TEXT, " +
                "$COLUMN_NAME_STOP_LATITUDE DOUBLE, $COLUMN_NAME_STOP_LONGITUDE DOUBLE);"

        // Create routes table
        const val SQL_CREATE_ROUTES_TABLE = "CREATE TABLE $TABLE_NAME_ROUTES ($COLUMN_NAME_BASE_ID INTEGER PRIMARY KEY, " +
                "$COLUMN_NAME_ROUTE_ID INTEGER, $COLUMN_NAME_ROUTE_SHORT_NAME TEXT, " +
                "$COLUMN_NAME_ROUTE_LONG_NAME TEXT, $COLUMN_NAME_ROUTE_TYPE INTEGER);"

        // Create trips table
        const val SQL_CREATE_TRIPS_TABLE = "CREATE TABLE $TABLE_NAME_TRIPS ($COLUMN_NAME_BASE_ID INTEGER PRIMARY KEY, " +
                "$COLUMN_NAME_ROUTE_ID INTEGER, $COLUMN_NAME_TRIP_ID INTEGER, $COLUMN_NAME_SERVICE_ID INTEGER);"

        // Create stop times table
        const val SQL_CREATE_STOP_TIMES_TABLE = "CREATE TABLE $TABLE_NAME_STOP_TIMES ($COLUMN_NAME_BASE_ID INTEGER PRIMARY KEY, " +
                "$COLUMN_NAME_TRIP_ID INTEGER, $COLUMN_NAME_ARRIVAL_TIME INTEGER, $COLUMN_NAME_DEPARTURE_TIME INTEGER, " +
                "$COLUMN_NAME_STOP_ID INTEGER, $COLUMN_NAME_STOP_SEQUENCE INTEGER);"
    }
}
