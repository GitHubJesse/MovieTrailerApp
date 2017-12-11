package com.example.itguest.movietrailerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by itguest on 12/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    public final String DATABASE_NAME = "Movies.db";
    public final String TABLE_NAME = "movie";
    public final String COL_1 = "id";
    public final String COL_2 = "title";
    public final String COL_3 = "description";
    public final String COL_4 = "video_url";
    public final String COL_5 = "rating";


    public DatabaseHelper(Context context) {
        super(context, "Movies.db", null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                           COL_2 + " TEXT," +
                                                           COL_3 + " TEXT," +
                                                           COL_4 + " TEXT," +
                                                           COL_5 + " DOUBLE)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

//    public void addMovie(Trailer trailer)
//    {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_2);
//        contentValues.put(COL_3);
//        contentValues.put(COL_4);
//        contentValues.put(COL_5);
//    }
}
