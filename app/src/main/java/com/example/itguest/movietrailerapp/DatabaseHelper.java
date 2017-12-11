package com.example.itguest.movietrailerapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by itguest on 12/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    public final String DATABASE_NAME = "Movies.db";
    public final String COL_1 = "id";
    public final String COL_2 = "title";
    public final String COL_3 = "description";
    public final String COL_4 = "image_path";
    public final String COL_5 = "rating";


    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
