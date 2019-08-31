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
        sUriMatcher.addURI(StaticDbHelper.STATIC_CONTENT_AUTHORITY, StaticDbHelper.TABLE_NAME_STOPS, STOPS);
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

        Log.v(LOG_TAG, "Added stop code : " + values.getAsString(StaticDbHelper.COLUMN_NAME_STOP_CODE));

        // Notify about change
        getContext().getContentResolver().notifyChange(uri, null);

        // return the uri of inserted row
        return ContentUris.withAppendedId(uri, rowID);

    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {

        switch (sUriMatcher.match(uri)) {
            case STOPS:
                int numDeletedRows = deleteItem(s, strings, StaticDbHelper.TABLE_NAME_STOPS);
                if (numDeletedRows != 0) getContext().getContentResolver().notifyChange(uri, null);
                return numDeletedRows;
            case STOPS_ID:
                s = StaticDbHelper.COLUMN_NAME_STOP_ID + "=?";
                strings = new String[]{String.valueOf(ContentUris.parseId(uri))};
                int numDeletedRowss = deleteItem(s, strings, StaticDbHelper.TABLE_NAME_STOPS);
                if (numDeletedRowss != 0) getContext().getContentResolver().notifyChange(uri, null);
                return numDeletedRowss;
            default:
                throw new IllegalArgumentException(invalidUriErrorGenerator(uri));

        }
    }

    private int deleteItem(String selection, String[] selectionArgs, String tableName) {
        SQLiteDatabase database = mDbHelper.getWritableDatabase();
        return database.delete(tableName, selection, selectionArgs);
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {

        int NO_UPDATE = -1;

        if (values.size() == 0) return NO_UPDATE;

        switch (sUriMatcher.match(uri)) {
            case STOPS:
                int numItemsUpdated = updateItem(values, selection, selectionArgs, StaticDbHelper.TABLE_NAME_STOPS);
                if (numItemsUpdated != 0) getContext().getContentResolver().notifyChange(uri, null);
                return numItemsUpdated;
            case STOPS_ID:
                selection = StaticDbHelper.COLUMN_NAME_STOP_ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                int numItemsUpdatedd = updateItem(values, selection, selectionArgs, StaticDbHelper.TABLE_NAME_STOPS);
                if (numItemsUpdatedd != 0)
                    getContext().getContentResolver().notifyChange(uri, null);
                return numItemsUpdatedd;
            default:
                throw new IllegalArgumentException(invalidUriErrorGenerator(uri));
        }
    }


    private int updateItem(ContentValues values, String selection, String[] selectionArgs, String tableName) {

        SQLiteDatabase database = mDbHelper.getWritableDatabase();
        return database.update(tableName, values, selection, selectionArgs);

    }


    // Generates error message to throw in exception
    private String invalidUriErrorGenerator(Uri uri) {
        return "The provided Uri " + uri.toString() + " is not valid";
    }

}
