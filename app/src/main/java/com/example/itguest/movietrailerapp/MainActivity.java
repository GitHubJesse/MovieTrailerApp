package com.example.itguest.movietrailerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.itguest.movietrailerapp.R.id.parent;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper trailerDB;
    Button btnAddTrailer;
    ListView listViewTrailers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create an instance of the DatabaseHelper Class
        trailerDB = new DatabaseHelper(this);

        /** SEEDING DATABASE */

        trailerDB.addTrailer(new Trailer(1));
        trailerDB.addTrailer(new Trailer(2));
        trailerDB.addTrailer(new Trailer(3));
        trailerDB.addTrailer(new Trailer(4));
        trailerDB.addTrailer(new Trailer(5));

        /** DONE SEEDING */

        //Set up a variable to read from the add Trailer button
        btnAddTrailer = (Button) findViewById(R.id.btnAddTrailer);

        //Set onClickListener to intent to a new page and display a form for adding a new trailer
//        btnAddTrailer.setOnClickListener({
//            //Create new intent to move to the addTrailerForm
//            Intent addNewTrailerForm = new Intent(MainActivity.this, addNewTrailerForm.class);
//            //Set flag to start a new task fresha dn destroy the old task
//            addNewTrailerForm.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//            //Start new activity and destroy the old one
//            startActivity(addNewTrailerForm);
//            MainActivity.this.finish();
//        });


    //Retrieve all trailer records from the Database
    ArrayList<Trailer> trailers = trailerDB.getTrailers();

    //Set up variable to access the trailers list
    listViewTrailers = (ListView) findViewById(R.id.listViewTrailers);

    //Create adapter object to modify the values in the listView
    ListAdapter adapter = new TrailerListAdapter(this, trailers);
    listViewTrailers.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//            Trailer trailer = (Trailer)adapterView.getItemAtPosition(position);
//            Intent intent = Intent(MainActivity.this, ViewSelectedTrailer.class);
//            //Set flag to start a new task fresha dn destroy the old task
//            ViewSelectedTrailer.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//            //Start new activity and destroy the old one
//            startActivity(ViewSelectedTrailer);
//            MainActivity.this.finish();
        }
    });

    //listViewTrailers.setOnItemClickListener()

    }
}
