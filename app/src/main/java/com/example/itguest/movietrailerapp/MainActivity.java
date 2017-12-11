package com.example.itguest.movietrailerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper trailerDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create an instance of the DatabaseHelper Class
        trailerDB = new DatabaseHelper(this);

        //Set up a variable to read from the add Trailer button
        Button btnAddTrailer = (Button) findViewById(R.id.btnAddTrailer);

        //Set onClickListener to intent to a new page and display a form for adding a new trailer
//        btnAddTrailer.setOnClickListener({
              //Create new intent to move to the addTrailerForm
//            Intent addNewTrailerForm = new Intent(MainActivity.this, addNewTrailerForm.class);
              //Set flag to start a new task fresha dn destroy the old task
//            addNewTrailerForm.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

              //Start new activity and destroy the old one
//            startActivity(addNewTrailerForm);
//            MainActivity.this.finish();
//        });
    }

    //Retrieve all trailer records from the Database
    ArrayList<Trailer> trailers = trailerDB.getTrailers();

    //Set up variable to access the trailers list
    ListView listViewTrailers = (ListView) findViewById(R.id.listViewTrailers);

    //Create adapter object to modify the values in the listView
//    ListAdapter adapter = new TrailerListAdapter(this, trailers);
//    listViewTrailers.setAdapter(adapter);
//
//    listViewTrailers.setOnItemClickListener()
}
