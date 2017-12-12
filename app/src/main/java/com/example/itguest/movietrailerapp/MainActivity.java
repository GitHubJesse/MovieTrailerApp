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

        //flushDatabase();
        /** SEEDING DATABASE */
        //seedDatabase();
        /** DONE SEEDING */

        //Set up a variable to read from the add Trailer button
        btnAddTrailer = (Button) findViewById(R.id.btnAddTrailer);

        //Set onClickListener to intent to a new page and display a form for adding a new trailer
        btnAddTrailer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Create new intent to move to the addTrailerForm
                Intent addNewTrailerForm = new Intent(MainActivity.this, addNewTrailerForm.class);
                //Set flag to start a new task fresha dn destroy the old task
                addNewTrailerForm.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                //Start new activity and destroy the old one
                startActivity(addNewTrailerForm);
                MainActivity.this.finish();
            }
        });


    //Retrieve all trailer records from the Database
    ArrayList<Trailer> trailers = trailerDB.getTrailers();

    //Set up variable to access the trailers list
    listViewTrailers = (ListView) findViewById(R.id.listViewTrailers);

    //Create adapter object to modify the values in the listView
    ListAdapter adapter = new TrailerListAdapter(this, trailers);
    listViewTrailers.setAdapter(adapter);

    listViewTrailers.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//            Trailer trailer = (Trailer)adapterView.getItemAtPosition(position);
//            Intent intent = Intent(MainActivity.this, ViewSelectedTrailer.class);
//            //Set flag to start a new task fresh and destroy the old task
//            ViewSelectedTrailer.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//            //Start new activity and destroy the old one
//            startActivity(ViewSelectedTrailer);
//            MainActivity.this.finish();
        }
    });

    //listViewTrailers.setOnItemClickListener()

    }
    public void seedDatabase()
    {
        int DEFAULT_RATING = 0;
        trailerDB.addTrailer(new Trailer(1,"Jurassic World: Fallen Kingdom","Four years after the destruction of the Jurassic World theme park, Owen Grady and Claire Dearing return to the island of Isla Nublar to save the remaining dinosaurs from a volcano that's about to erupt. They soon encounter terrifying new breeds of gigantic dinos while uncovering a conspiracy that threatens the entire planet.", "vn9mMeWcgoM",DEFAULT_RATING));
        trailerDB.addTrailer(new Trailer(2,"Star Wars: The Last Jedi","Rey develops her newly discovered abilities with the guidance of Luke Skywalker, who is unsettled by the strength of her powers. Meanwhile, the Resistance prepares to do battle with the First Order.","Q0CbN8sfihY",DEFAULT_RATING));
        trailerDB.addTrailer(new Trailer(3,"Deadpool 2 'Wet on Wet'","Wisecracking mercenary Deadpool battles ninjas, the yakuza and a pack of aggressive canines as he embarks on a new adventure.","8-Cjsnq8kVU",DEFAULT_RATING));
        trailerDB.addTrailer(new Trailer(4,"People You May Know","Four middle-aged friends living in Los Angeles confront a new reality.","eJ4n2PKpppE",DEFAULT_RATING));
        trailerDB.addTrailer(new Trailer(5,"Rampage","Primatologist Davis Okoye shares an unshakable bond with George, an extraordinarily intelligent, silverback gorilla that's been in his care since birth. When a rogue genetic experiment goes wrong, it causes George, a wolf and a reptile to grow to a monstrous size. As the mutated beasts embark on a path of destruction, Okoye teams up with a discredited genetic engineer and the military to secure an antidote and prevent a global catastrophe.","coOKvrsmQiI",DEFAULT_RATING));
    }

    public void flushDatabase()
    {
        for(int i=0;i<500;i++)
        {
            trailerDB.deleteTrailer(i);
        }
    }
}
