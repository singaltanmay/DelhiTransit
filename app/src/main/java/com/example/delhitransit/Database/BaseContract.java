package com.example.delhitransit.Database;

import android.net.Uri;
import android.provider.BaseColumns;

public class BaseContract {

    //Empty constructor to prevent instantiation
    private BaseContract() {
    }

    // Refers to particular application
    public static final String CONTENT_AUTHORITY = "com.example.delhitransit";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // Refers to particular database
    public static final String PATH_BUS_STOPS = "";


    public static class StopsEntry implements BaseColumns {

        // Refers to this particular database
        public static final String STOPS_CONTENT_AUTHORITY = BaseContract.CONTENT_AUTHORITY + ".Database.StopsProvider";
        public static final Uri STOPS_CONTENT_URI = Uri.parse("content://" + STOPS_CONTENT_AUTHORITY);

        //  Name of the table
        public static final String TABLE_NAME = "busStops";

        // Uri pointing to this particular table
        public static final Uri CONTENT_URI = Uri.withAppendedPath(STOPS_CONTENT_URI, StopsEntry.TABLE_NAME);

        //  Names of various columns
        public static final String _ID = "stop_id";
        public static final String COLUMN_NAME_STOP_CODE = "stop_code";
        public static final String COLUMN_NAME_STOP_NAME = "stop_name";
        public static final String COLUMN_NAME_STOP_LATITUDE = "stop_latitude";
        public static final String COLUMN_NAME_STOP_LONGITUDE = "stop_longitude";

    }


}
