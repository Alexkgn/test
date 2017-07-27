package com.alexkgn.listapp.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.alexkgn.listapp.data.Picture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 24.07.2017.
 */

public class DbHelper extends SQLiteOpenHelper implements IDbHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "database.db";

    private static final String PRIMARY_AUTOINCREMENT = " PRIMARY KEY AUTOINCREMENT";
    private static final String COMMA_SEP = ", ";

    private static final String TYPE_TEXT = " TEXT";
    private static final String TYPE_INTEGER = " INTEGER";
    private static final String TYPE_BLOB = " BLOB";

    public static final String CREATE_TAVLE = "CREATE TABLE "
            + DatabaseContract.PictureEntry.TABLE_NAME + " (" +
            DatabaseContract.PictureEntry._ID + TYPE_INTEGER + PRIMARY_AUTOINCREMENT + COMMA_SEP +
            DatabaseContract.PictureEntry.COLUMN_TITLE + TYPE_TEXT + COMMA_SEP +
            DatabaseContract.PictureEntry.COLUMN_DESCRIPTION + TYPE_TEXT + COMMA_SEP +
            DatabaseContract.PictureEntry.COLUMN_PICTURE + TYPE_BLOB +
            " ); ";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TAVLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public boolean savePicture(@NonNull Picture picture) {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(DatabaseContract.PictureEntry.COLUMN_TITLE, picture.getTitle());
            values.put(DatabaseContract.PictureEntry.COLUMN_DESCRIPTION, picture.getDescription());
            values.put(DatabaseContract.PictureEntry.COLUMN_PICTURE, picture.getPicture());
            db.insert(DatabaseContract.PictureEntry.TABLE_NAME, null, values);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
        return true;
    }

    @Override
    public List<Picture> getPictureList() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                DatabaseContract.PictureEntry.TABLE_NAME,
                null, null, null, null, null, null
        );
        List<Picture> pictures = new ArrayList<>();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                Picture picture = getCityFromCursor(cursor);
                if (picture != null) {
                    pictures.add(picture);
                }
            }
            cursor.close();
        }
        return pictures;
    }

    @Nullable
    private Picture getCityFromCursor(@NonNull final Cursor cursor) {
        try {
            int pictureId = cursor.getInt(
                    cursor.getColumnIndexOrThrow(DatabaseContract.PictureEntry._ID)
            );
            String title = cursor.getString(
                    cursor.getColumnIndexOrThrow(DatabaseContract.PictureEntry.COLUMN_TITLE)
            );
            String description = cursor.getString(
                    cursor.getColumnIndexOrThrow(DatabaseContract.PictureEntry.COLUMN_DESCRIPTION)
            );
            byte[] picture = cursor.getBlob(
                    cursor.getColumnIndexOrThrow(DatabaseContract.PictureEntry.COLUMN_PICTURE)
            );
            Picture pic = new Picture();
            pic.setId(pictureId);
            pic.setTitle(title);
            pic.setDescription(description);
            pic.setPicture(picture);
            return pic;
        } catch (IllegalArgumentException exception) {
            return null;
        }
    }
}
