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


    public static class StaticEntry implements BaseColumns {

        // Refers to this particular database
        public static final String STATIC_CONTENT_AUTHORITY = BaseContract.CONTENT_AUTHORITY + ".Database.StaticProvider";
        public static final Uri STOPS_CONTENT_URI = Uri.parse("content://" + STATIC_CONTENT_AUTHORITY);



    }


}
