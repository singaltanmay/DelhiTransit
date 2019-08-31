package com.example.delhitransit.Database;

import android.net.Uri;

public class BaseContract {

    //Empty constructor to prevent instantiation
    private BaseContract() {
    }

    // Refers to particular application
    public static final String CONTENT_AUTHORITY = "com.example.delhitransit";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);



}
