package com.example.delhitransit.database;

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

public class DynamicProvider extends ContentProvider {

    private static final String LOG_TAG = DynamicProvider.class.getSimpleName();

    private static final int POSITION_UPDATE = 0;
    private static final int POSITION_UPDATE_ID = 1;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(DynamicDbHelper.Companion.getDYNAMIC_CONTENT_AUTHORITY(), DynamicDbHelper.TABLE_NAME_VEHICLE_POSITION_UPDATE, POSITION_UPDATE);
        sUriMatcher.addURI(DynamicDbHelper.Companion.getDYNAMIC_CONTENT_AUTHORITY(), DynamicDbHelper.TABLE_NAME_VEHICLE_POSITION_UPDATE+ "/#", POSITION_UPDATE_ID);
    }

    private DynamicDbHelper mDbHelper;

    @Override
    public boolean onCreate() {
        mDbHelper = new DynamicDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase database = mDbHelper.getReadableDatabase();

        switch (sUriMatcher.match(uri)) {
            case POSITION_UPDATE:
                return broadQuery(database, DynamicDbHelper.TABLE_NAME_VEHICLE_POSITION_UPDATE, projection, selection, selectionArgs, sortOrder);
            case POSITION_UPDATE_ID:
                return narrowQuery(DynamicDbHelper.COLUMN_NAME_VEHICLE_ID, database, DynamicDbHelper.TABLE_NAME_VEHICLE_POSITION_UPDATE, uri, projection, selection, selectionArgs, sortOrder);
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
            case POSITION_UPDATE:
                return ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + BaseContract.INSTANCE.getCONTENT_AUTHORITY() + "/" + DynamicDbHelper.TABLE_NAME_VEHICLE_POSITION_UPDATE;
            case POSITION_UPDATE_ID:
                return ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + BaseContract.INSTANCE.getCONTENT_AUTHORITY() + "/" + DynamicDbHelper.TABLE_NAME_VEHICLE_POSITION_UPDATE;
            default:
                throw new IllegalStateException(invalidUriErrorGenerator(uri));
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {

        Uri rope;

        switch (sUriMatcher.match(uri)) {
            case POSITION_UPDATE:
                rope = insertItem(DynamicDbHelper.TABLE_NAME_VEHICLE_POSITION_UPDATE, contentValues, uri);
                break;
            default:
                throw new IllegalArgumentException(invalidUriErrorGenerator(uri));
        }

        return rope;
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

        switch (sUriMatcher.match(uri)) {
            case POSITION_UPDATE:
                int numDeletedRow = deleteItem(s, strings, DynamicDbHelper.TABLE_NAME_VEHICLE_POSITION_UPDATE);
                if (numDeletedRow != 0) getContext().getContentResolver().notifyChange(uri, null);
                return numDeletedRow;
            case POSITION_UPDATE_ID:
                //TODO change and fix
                s = DynamicDbHelper.COLUMN_NAME_ID + "=?";
                strings = new String[]{String.valueOf(ContentUris.parseId(uri))};
                int numDeletedRows4 = deleteItem(s, strings, DynamicDbHelper.TABLE_NAME_VEHICLE_POSITION_UPDATE);
                if (numDeletedRows4 != 0)
                    getContext().getContentResolver().notifyChange(uri, null);
                return numDeletedRows4;
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
            case POSITION_UPDATE:
                int numItemUpate = updateItem(values, selection, selectionArgs, DynamicDbHelper.TABLE_NAME_VEHICLE_POSITION_UPDATE);
                if (numItemUpate != 0) getContext().getContentResolver().notifyChange(uri, null);
                return numItemUpate;
            case POSITION_UPDATE_ID:
                selection = DynamicDbHelper.COLUMN_NAME_ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                int numItemsUpdaddx = updateItem(values, selection, selectionArgs, DynamicDbHelper.TABLE_NAME_VEHICLE_POSITION_UPDATE);
                if (numItemsUpdaddx != 0)
                    getContext().getContentResolver().notifyChange(uri, null);
                return numItemsUpdaddx;
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
