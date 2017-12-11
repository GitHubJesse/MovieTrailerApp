package com.example.itguest.movietrailerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper{
    public final static String DATABASE_NAME = "Movies.db";
    public final static String TABLE_NAME = "movie";
    public final static String COL_1 = "id";
    public final static String COL_2 = "title";
    public final static String COL_3 = "description";
    public final static String COL_4 = "video_url";
    public final static String COL_5 = "rating";


    public DatabaseHelper(Context context)//, String name, SQLiteDatabase.CursorFactory factory, int version) {
    {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    /**
     * DB Creation Statements
     */

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createSQL = "CREATE TABLE " + TABLE_NAME + " (" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                           COL_2 + " TEXT," +
                                                           COL_3 + " TEXT," +
                                                           COL_4 + " TEXT," +
                                                           COL_5 + " DOUBLE)";
        sqLiteDatabase.execSQL(createSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /**
     * Trailer Class SQL Queries
     */

    public ArrayList<Trailer> getTrailers() {
        //SELECT ALL TRAILERS FROM DB
        String selectSQL = "SELECT * FROM " + TABLE_NAME + " WHERE 1;";

        //Instance a readable database and select all trailer records to be displayed
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor resultSet = sqLiteDatabase.rawQuery(selectSQL, null);

        //Select the 1st item from the results
        resultSet.moveToFirst();

        ArrayList<Trailer> trailerList = new ArrayList<>();

        //While the cursor has not reached the end of the results
        while (!resultSet.isAfterLast()) {
            Trailer trailer = new Trailer();

            //Set attributes of the selected trailer to the current Trailer object
            trailer.setId(resultSet.getInt(resultSet.getColumnIndex(COL_1)));
            trailer.setTitle(resultSet.getString(resultSet.getColumnIndex(COL_2)));
            trailer.setDescription(resultSet.getString(resultSet.getColumnIndex(COL_3)));
            trailer.setVideo_url(resultSet.getString(resultSet.getColumnIndex(COL_4)));
            trailer.setRating(resultSet.getInt(resultSet.getColumnIndex(COL_5)));

            //Add the Trailer object to the ArrayList then move to the next trailer in the resultSet
            trailerList.add(trailer);
            resultSet.moveToNext();
        }

        //Close the DB + resultSet
        sqLiteDatabase.close();
        resultSet.close();

        //Return the Trailer ArrayList
        return trailerList;
    }

    public void addTrailer(Trailer trailer)
    {
        //Create a container for the trailer data values
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, trailer.getTitle());
        contentValues.put(COL_3, trailer.getDescription());
        contentValues.put(COL_4, trailer.getVideo_url());

        //Ensure a negative value is never show as a rating
        if(trailer.getRating() > 0)
            contentValues.put(COL_5, trailer.getRating());

        //Instance a writable database and insert the values
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        //Close the DB
        sqLiteDatabase.close();
    }

    public void deleteTrailer(int id)
    {
        //Set up SQL query to delete a trailer record from the DB
        String deleteSQL = "DELETE FROM " + TABLE_NAME + " WHERE " + COL_1 + " = " + id;

        //Instance a writable database and delete a selected trailer record
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(deleteSQL);

        //Close the DB
        sqLiteDatabase.close();
    }

    public void updateRating(int id)
    {
        //Set up SQL query to update the rating column in the trailer record
        String updateSQL = "UPDATE " + TABLE_NAME + " SET " + COL_5 + " WHERE " + COL_1 + " = " + id;
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        //Update the rating column for the selected trailer record
        sqLiteDatabase.execSQL(updateSQL);

        //Close the DB
        sqLiteDatabase.close();
    }
}
