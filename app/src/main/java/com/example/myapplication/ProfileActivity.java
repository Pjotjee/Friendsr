package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private SharedPreferences.Editor editor;
    private String namePerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        // get the intent from the MainActivity
        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");
        editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
        RatingBar view = findViewById(R.id.ratingBar);
        view.setOnRatingBarChangeListener( new OnRatingBarChangeListener());
        namePerson = retrievedFriend.getName();
        // set the ratings
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        float aStoredRate = prefs.getFloat(namePerson, 0);
        if (aStoredRate != 0) {
            retrievedFriend.setRating(aStoredRate);
        }
        //set the name
        TextView name = findViewById(R.id.name);
        name.setText(retrievedFriend.getName());
        //set the bio
        TextView bio = findViewById(R.id.bio);
        bio.setText(retrievedFriend.getBio());
        //set rating
        RatingBar bar = findViewById(R.id.ratingBar);
        bar.setRating(retrievedFriend.getRating());
        //set profilepic
        ImageView image = findViewById(R.id.profilePic);
        image.setImageResource(retrievedFriend.getDrawableId());
    }

    // ratingbar class
    private class OnRatingBarChangeListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            editor.putFloat(namePerson, rating);
            editor.apply();
        }

    }
}
