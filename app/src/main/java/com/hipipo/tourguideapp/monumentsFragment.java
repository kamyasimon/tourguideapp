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

public class monumentsFragment extends Fragment {
    ListView monumentList;

    ArrayAdapter<String> monumentsAdapter;
    ArrayList<Tasks> myMonument = new ArrayList<Tasks>();

    public monumentsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //add the listitems to the thrillList
        myMonument.add(new Tasks(getString(R.string.monumentMoroto), getString(R.string.thrillLocationone), R.drawable.morotorock, getString(R.string.monumentmorotoHrs)));
        myMonument.add(new Tasks(getString(R.string.monumentMweya), getString(R.string.thrillLocationtwo), R.drawable.mweyasafari, getString(R.string.monumentMweyaHrs)));
        myMonument.add(new Tasks(getString(R.string.monumentPlungpool), getString(R.string.thrillLocationthree), R.drawable.thegap, getString(R.string.monumentplungpoolHrs)));
        myMonument.add(new Tasks(getString(R.string.monumentRoadTrip), getString(R.string.thrillLocationfour), R.drawable.craterlake, getString(R.string.monumentroadHrs)));

        //set fragment context pushed to constractor in custom array adapter
        tourThrillsAdapter thrillTourAdapter = new tourThrillsAdapter(this.getContext(), myMonument);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thrills, container, false);
        monumentList = view.findViewById(R.id.thrillsListview);
        monumentList.setAdapter(thrillTourAdapter);

        ///Set an onclick lister to launch the deatils intent
        monumentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get the current song from the ArrayList (songs) with the position of the clicked item.
                Tasks currentTask = myMonument.get(position);
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