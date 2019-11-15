package com.example.delhitransit.Database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.net.Uri
import android.provider.BaseColumns

class DynamicDbHelper(private val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    private fun dropTable(database: SQLiteDatabase, tableName: String) {
        database.execSQL("DROP TABLE IF EXISTS $tableName")
    }

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_VEHICLE_POSITION_UPDATE_TABLE)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        dropTable(sqLiteDatabase, TABLE_NAME_VEHICLE_POSITION_UPDATE)
        onCreate(sqLiteDatabase)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    companion object {

        const val DATABASE_NAME = "dynamicData.db"
        const val DATABASE_VERSION = 1

        val DYNAMIC_CONTENT_AUTHORITY = BaseContract.CONTENT_AUTHORITY + ".Database.DynamicProvider"
        val DYNAMIC_CONTENT_URI = Uri.parse("content://$DYNAMIC_CONTENT_AUTHORITY")

        // Names of various columns
        const val COLUMN_NAME_ID = BaseColumns._ID
        const val COLUMN_NAME_VEHICLE_ID = "vehicle_id"
        const val COLUMN_NAME_TRIP_ID = StaticDbHelper.COLUMN_NAME_TRIP_ID
        const val COLUMN_NAME_ROUTE_ID = StaticDbHelper.COLUMN_NAME_ROUTE_ID
        const val COLUMN_NAME_VEHICLE_LATITUDE = "vehicle_latitude"
        const val COLUMN_NAME_VEHICLE_LONGITUDE = "vehicle_longitude"
        const val COLUMN_NAME_VEHICLE_SPEED = "vehicle_speed"
        const val COLUMN_NAME_UPDATE_TIMESTAMP = "update_timestamp"

        // Names of various tables
        const val TABLE_NAME_VEHICLE_POSITION_UPDATE = "position_update"

        // Uri pointing to this particular table
        val TABLE_NAME_VEHICLE_POSITION_UPDATE_CONTENT_URI = Uri.withAppendedPath(DYNAMIC_CONTENT_URI, TABLE_NAME_VEHICLE_POSITION_UPDATE)

        // Create vehicle position update table
        const val SQL_CREATE_VEHICLE_POSITION_UPDATE_TABLE = "CREATE TABLE $TABLE_NAME_VEHICLE_POSITION_UPDATE ($COLUMN_NAME_ID INTEGER PRIMARY KEY, " +
                "$COLUMN_NAME_VEHICLE_ID TEXT, $COLUMN_NAME_TRIP_ID TEXT, $COLUMN_NAME_ROUTE_ID TEXT, $COLUMN_NAME_VEHICLE_LATITUDE DOUBLE, " +
                "$COLUMN_NAME_VEHICLE_LONGITUDE DOUBLE, $COLUMN_NAME_VEHICLE_SPEED DOUBLE, $COLUMN_NAME_UPDATE_TIMESTAMP INTEGER);"
    }
}
