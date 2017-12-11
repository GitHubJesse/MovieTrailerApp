package com.example.itguest.movietrailerapp;


import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TrailerListAdapter extends ArrayAdapter<Trailer>
{
    TrailerListAdapter(Context context, ArrayList<Trailer> trailers)
    {
        super(context, R.layout.trailer_list_item, trailers);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        @SuppressLint("ViewHolder") View customView = inflater.inflate(R.layout.trailer_list_item,parent,false);

        //Select a single item from the trailer list
        Trailer trailerItem = getItem(position);

        //Set up a var to access the trailer list item title textview + video thumbnail
        TextView textViewVideoTitle = (TextView) customView.findViewById(R.id.textViewTitle);
        ImageView trailerThumbnail = (ImageView) customView.findViewById(R.id.videoThumbnail);

        //Grab the current item's title and set it's value to the textview
        textViewVideoTitle.setText(trailerItem.getTitle());

        //Retrieve YouTube Thumbnail via Picasso
        Picasso.with(getContext())
                //Load the url path the the thumbnail
                .load("https://img.youtube.com/vi/"+trailerItem.getVideo_url()+"/0.jpg")
                //Resize to fit into the list display
                .resize(250,200)
                //Set the imageView to set the thumbnail into
                .into(trailerThumbnail);

        return customView;
    }
}
