package com.example.android.coloradotourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JesseRawlings on 11/7/17.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    //Constructor
    public PlaceAdapter(Context context, ArrayList<Place> places) {
        super(context, 0, places);
    }

    //Override the getView method to attach the correct name and image to each view
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Place currentPlace = getItem(position);

        //Set image of listview item to current places image
        ImageView itemImage = (ImageView) listItemView.findViewById(R.id.item_image);
        itemImage.setImageResource(currentPlace.getImageResourseId());

        //Set the name of the place
        TextView itemName = (TextView) listItemView.findViewById(R.id.item_name);
        itemName.setText((CharSequence) currentPlace.getName());

        return listItemView;
    }
}
