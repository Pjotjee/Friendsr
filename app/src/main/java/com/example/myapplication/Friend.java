package com.example.myapplication;

import java.io.Serializable;
/* Create the Friend objects and implement Serializable so the Ratings values will be saved.
So when we close and reopen the app the Ratings will still be there.
*/
public class Friend implements Serializable {
    private String name, bio;
    private int drawableId;
    private float rating;
// construct the friend object
    public Friend(String name, String bio, int drawableId) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
