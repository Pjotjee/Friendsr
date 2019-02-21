package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FriendsAdapter extends ArrayAdapter<Friend> {
    // create an arraylist to store friends
    private ArrayList<Friend> friends;

    public FriendsAdapter(Context context, int resource, ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        Friend friend = friends.get(position);
        ImageView image = convertView.findViewById(R.id.imageView);
        image.setImageResource(friend.getDrawableId());
        TextView textV = convertView.findViewById(R.id.textView);
        textV.setText(friend.getName());
        return convertView;


        }
}
