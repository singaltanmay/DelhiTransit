package com.example.delhitransit

import android.database.Cursor
import com.example.delhitransit.Database.StaticDbHelper

data class BusStop(val dbID: Int, val stopID: Int, val stopCode: String, val stopName: String, val stopLat: Double, val stopLong: Double) {

    companion object parser {

        fun parseCursor(cursor: Cursor): ArrayList<BusStop> {

            val result = arrayListOf<BusStop>()

            val baseID = cursor.getColumnIndex(StaticDbHelper.COLUMN_NAME_BASE_ID)
            val stopID = cursor.getColumnIndex(StaticDbHelper.COLUMN_NAME_STOP_ID)
            val stopCode = cursor.getColumnIndex(StaticDbHelper.COLUMN_NAME_STOP_CODE)
            val stopName = cursor.getColumnIndex(StaticDbHelper.COLUMN_NAME_STOP_NAME)
            val stopLat = cursor.getColumnIndex(StaticDbHelper.COLUMN_NAME_STOP_LATITUDE)
            val stopLong = cursor.getColumnIndex(StaticDbHelper.COLUMN_NAME_STOP_LONGITUDE)

            while (cursor.moveToNext()) {

                var value_id: Int = -1
                var value_stop_id: Int = -1
                var value_stop_code = ""
                var value_stop_name = ""
                var value_stop_lat = 0.0
                var value_stop_lon = 0.0


                if (baseID != -1) value_id = cursor.getInt(baseID)
                if (stopID != -1) value_stop_id = cursor.getInt(stopID)
                if (stopCode != -1) value_stop_code = cursor.getString(stopCode)
                if (stopName != -1) value_stop_name = cursor.getString(stopName)
                if (stopLat != -1) value_stop_lat = cursor.getDouble(stopLat)
                if (stopLong != -1) value_stop_lon = cursor.getDouble(stopLong)

                result.add(BusStop(value_id, value_stop_id, value_stop_code, value_stop_name, value_stop_lat, value_stop_lon))

            }

            cursor.close()

            return result
        }

    }


}

