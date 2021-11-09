package com.hipipo.tourguideapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class eventsFragment extends Fragment {
    ListView eventsList;
    ArrayAdapter<String> eventsAdapter;
    ArrayList<Tasks> myEvents = new ArrayList<Tasks>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myEvents.add(new Tasks(getString(R.string.eventWines), getString(R.string.thrillLocationone), R.drawable.wineanddine, getString(R.string.eventDanceday)));
        myEvents.add(new Tasks(getString(R.string.eventDance), getString(R.string.thrillLocationtwo), R.drawable.dancestudio, getString(R.string.eventDanceday)));
        myEvents.add(new Tasks(getString(R.string.eventCultureDance), getString(R.string.thrillLocationthree), R.drawable.culturaldance, getString(R.string.eventCulturalDanceday)));

        //set fragment context pushed to constractor in custom array adapter
        tourThrillsAdapter eventsTourAdapter = new tourThrillsAdapter(this.getContext(), myEvents);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thrills, container, false);
        eventsList = view.findViewById(R.id.thrillsListview);
        eventsList.setAdapter(eventsTourAdapter);

        ///Set an onclick lister to launch the deatils intent
        eventsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get the current song from the ArrayList (songs) with the position of the clicked item.
                Tasks currentTask = myEvents.get(position);
                //get the song name and artist name from the currentPlayingSong object
                String Touractivity = currentTask.getTourActivities();
                String Tourlocation = currentTask.getTourLocations();
                String TourAddress = currentTask.getTourAddress();
                int Tourimage = currentTask.getTourImages();
                Intent detailScreen = new Intent(view.getContext(), Thrills.class);
                detailScreen.putExtra("activity", Touractivity);
                detailScreen.putExtra("location", Tourlocation);
                detailScreen.putExtra("address", TourAddress);
                detailScreen.putExtra("image", String.valueOf(Tourimage));
                startActivity(detailScreen);
            }
        });

        return view;
    }
}