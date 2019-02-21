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
        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
        RatingBar view = findViewById(R.id.ratingBar);
        view.setOnRatingBarChangeListener( new OnRatingBarChangeListener());
        namePerson = retrievedFriend.getName();

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        float aStoredRate = prefs.getFloat(namePerson, 0);

        if (aStoredRate != 0) {
            retrievedFriend.setRating(aStoredRate);
        }

        TextView name = findViewById(R.id.name);
        name.setText(retrievedFriend.getName()); //set name of character
        TextView bio = findViewById(R.id.bio);
        bio.setText(retrievedFriend.getBio()); //set bio of character
        RatingBar bar = findViewById(R.id.ratingBar);
        bar.setRating(retrievedFriend.getRating()); //set rating of character
        ImageView image = findViewById(R.id.profilePic);
        image.setImageResource(retrievedFriend.getDrawableId()); //set profilepic of character
    }

    private class OnRatingBarChangeListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            editor.putFloat(namePerson, rating);
            editor.apply();
        }

    }
}
