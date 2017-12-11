package com.example.itguest.movietrailerapp;

import android.database.sqlite.SQLiteDatabase;

public class YouTubeConfig {
    public YouTubeConfig()
    {

    }
    private static final String API_KEY = "AIzaSyBniEPY31qR2Ekyev2RALnzK74CitB6BDU";

    public static String getApiKey(){
        return API_KEY;
    }
}
