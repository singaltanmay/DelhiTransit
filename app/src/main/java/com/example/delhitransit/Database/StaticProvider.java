package com.example.delhitransit.Database;

import android.content.UriMatcher;

public class StaticProvider {

    private static final int STOPS = 0;
    private static final int STOPS_ID = 1;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        //TODO sUriMatcher.addURI(BaseContract.);
    }

}
