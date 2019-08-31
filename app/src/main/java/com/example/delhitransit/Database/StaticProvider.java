package com.example.delhitransit.Database;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StaticProvider extends ContentProvider {

    private static final String LOG_TAG = StaticProvider.class.getSimpleName();

    private static final int STOPS = 0;
    private static final int STOPS_ID = 1;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(BaseContract.StaticEntry.STATIC_CONTENT_AUTHORITY, StaticDbHelper.TABLE_NAME_STOPS, STOPS);
    }

    private StaticDbHelper mDbHelper;

    @Override
    public boolean onCreate() {
        mDbHelper = new StaticDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase database = mDbHelper.getReadableDatabase();
        Cursor cursor;

        switch (sUriMatcher.match(uri)) {
            case STOPS:
                cursor = database.query(StaticDbHelper.TABLE_NAME_STOPS, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case STOPS_ID:
                selection = StaticDbHelper.COLUMN_NAME_STOP_ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(StaticDbHelper.TABLE_NAME_STOPS, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException(invalidUriErrorGenerator(uri));
        }

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case STOPS:
                return ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + BaseContract.CONTENT_AUTHORITY + "/" + StaticDbHelper.TABLE_NAME_STOPS;
            case STOPS_ID:
                return ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + BaseContract.CONTENT_AUTHORITY + "/" + StaticDbHelper.TABLE_NAME_STOPS;
            default:
                throw new IllegalStateException(invalidUriErrorGenerator(uri));
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {

        switch (sUriMatcher.match(uri)) {
            case STOPS:
                insertItem(StaticDbHelper.TABLE_NAME_STOPS, contentValues, uri);
                break;

            default:
                throw new IllegalArgumentException(invalidUriErrorGenerator(uri));
        }

        return null;
    }

    private Uri insertItem(String table_name, ContentValues values, Uri uri) {

        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        long rowID = database.insert(table_name, null, values);

        if (rowID == -1) Log.e(LOG_TAG, "The provided Uri " + uri.toString() + " is not valid");

        // Notify about change
        getContext().getContentResolver().notifyChange(uri, null);

        // return the uri of inserted row
        return ContentUris.withAppendedId(uri, rowID);

    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }


    // Generates error message to throw in exception
    private String invalidUriErrorGenerator(Uri uri) {
        return "The provided Uri " + uri.toString() + " is not valid";
    }

}
