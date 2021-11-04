package com.hipipo.tourguideapp;

import android.app.LauncherActivity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class tourThrillsAdapter extends ArrayAdapter<Tasks> {


    public tourThrillsAdapter(@NonNull Context context,ArrayList<Tasks> Tasks) {
        super(context, 0, Tasks);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.minilist,parent,false);


        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        Tasks currentTask = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView thrillTourActivity = (TextView) listItemView.findViewById(R.id.thrillTaskText);

        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        thrillTourActivity.setText(currentTask.getTourActivities());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView thrillTourLocation = (TextView) listItemView.findViewById(R.id.thrillLocationText);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        thrillTourLocation.setText(currentTask.getTourLocations());

        ///set the image for the List item
        ImageView tourImage =  listItemView.findViewById(R.id.tourImages);
        //tourImage.setImageResource(currentTask.getTourImages());


        return listItemView;
    }
}
