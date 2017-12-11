package com.example.itguest.movietrailerapp;

import java.io.Serializable;

/**
 * Created by ITGuest on 12/11/2017.
 */

public class Trailer implements Serializable
{
    private int id;
    private String title;
    private String description;
    private String video_url;
    private int rating;

    public Trailer(){}

    public Trailer(int id, String title, String description, String video_url, int rating)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.video_url = video_url;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
