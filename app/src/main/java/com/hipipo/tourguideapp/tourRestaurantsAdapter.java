package com.hipipo.tourguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class tourRestaurantsAdapter extends ArrayAdapter<Tasks> {

    public tourRestaurantsAdapter(@NonNull Context context, ArrayList<Tasks> Tasks) {
        super(context, 0, Tasks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.minilist, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Tasks currentTask = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView restaurantTourActivity = (TextView) listItemView.findViewById(R.id.thrillTaskText);

        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        restaurantTourActivity.setText(currentTask.getTourActivities());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView restaurantTourLocation = (TextView) listItemView.findViewById(R.id.thrillLocationText);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        restaurantTourLocation.setText(currentTask.getTourLocations());

        return listItemView;
    }
}
