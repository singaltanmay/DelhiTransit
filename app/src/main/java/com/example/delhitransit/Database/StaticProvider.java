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
    private static final int ROUTES = 2;
    private static final int ROUTES_ID = 3;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(StaticDbHelper.STATIC_CONTENT_AUTHORITY, StaticDbHelper.TABLE_NAME_STOPS, STOPS);
        sUriMatcher.addURI(StaticDbHelper.STATIC_CONTENT_AUTHORITY, StaticDbHelper.TABLE_NAME_STOPS + "/#", STOPS_ID);
        sUriMatcher.addURI(StaticDbHelper.STATIC_CONTENT_AUTHORITY, StaticDbHelper.TABLE_NAME_ROUTES, ROUTES);
        sUriMatcher.addURI(StaticDbHelper.STATIC_CONTENT_AUTHORITY, StaticDbHelper.TABLE_NAME_ROUTES + "/#", ROUTES_ID);
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

        switch (sUriMatcher.match(uri)) {
            case STOPS:
                return broadQuery(database, StaticDbHelper.TABLE_NAME_STOPS, projection, selection, selectionArgs, sortOrder);
            case STOPS_ID:
                return narrowQuery(StaticDbHelper.COLUMN_NAME_STOP_ID, database, StaticDbHelper.TABLE_NAME_STOPS, uri, projection, selection, selectionArgs, sortOrder);
            case ROUTES:
                return broadQuery(database, StaticDbHelper.TABLE_NAME_ROUTES, projection, selection, selectionArgs, sortOrder);
            case ROUTES_ID:
                return narrowQuery(StaticDbHelper.COLUMN_NAME_ROUTE_ID, database, StaticDbHelper.TABLE_NAME_ROUTES, uri, projection, selection, selectionArgs, sortOrder);
            default:
                throw new IllegalArgumentException(invalidUriErrorGenerator(uri));
        }

    }

    private Cursor broadQuery(SQLiteDatabase database, String tableName, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return database.query(tableName, projection, selection, selectionArgs, null, null, sortOrder);
    }

    private Cursor narrowQuery(String idCol, SQLiteDatabase database, String tableName, Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        selection = idCol + "=?";
        selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
        return database.query(tableName, projection, selection, selectionArgs, null, null, sortOrder);
    }


    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case STOPS:
                return ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + BaseContract.CONTENT_AUTHORITY + "/" + StaticDbHelper.TABLE_NAME_STOPS;
            case STOPS_ID:
                return ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + BaseContract.CONTENT_AUTHORITY + "/" + StaticDbHelper.TABLE_NAME_STOPS;
            case ROUTES:
                return ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + BaseContract.CONTENT_AUTHORITY + "/" + StaticDbHelper.TABLE_NAME_ROUTES;
            case ROUTES_ID:
                return ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + BaseContract.CONTENT_AUTHORITY + "/" + StaticDbHelper.TABLE_NAME_ROUTES;
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
            case ROUTES:
                insertItem(StaticDbHelper.TABLE_NAME_ROUTES, contentValues, uri);
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
            case ROUTES:
                int numDeletedRows2 = deleteItem(s, strings, StaticDbHelper.TABLE_NAME_ROUTES);
                if (numDeletedRows2 != 0) getContext().getContentResolver().notifyChange(uri, null);
                return numDeletedRows2;
            case ROUTES_ID:
                s = StaticDbHelper.COLUMN_NAME_ROUTE_ID + "=?";
                strings = new String[]{String.valueOf(ContentUris.parseId(uri))};
                int numDeletedRowss4 = deleteItem(s, strings, StaticDbHelper.TABLE_NAME_ROUTES);
                if (numDeletedRowss4 != 0)
                    getContext().getContentResolver().notifyChange(uri, null);
                return numDeletedRowss4;
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
            case ROUTES:
                int numItemsUpdate = updateItem(values, selection, selectionArgs, StaticDbHelper.TABLE_NAME_ROUTES);
                if (numItemsUpdate != 0) getContext().getContentResolver().notifyChange(uri, null);
                return numItemsUpdate;
            case ROUTES_ID:
                selection = StaticDbHelper.COLUMN_NAME_ROUTE_ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                int numItemsUpdateddx = updateItem(values, selection, selectionArgs, StaticDbHelper.TABLE_NAME_ROUTES);
                if (numItemsUpdateddx != 0)
                    getContext().getContentResolver().notifyChange(uri, null);
                return numItemsUpdateddx;
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
