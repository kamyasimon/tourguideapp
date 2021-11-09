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

public class thrillsFragment extends Fragment {
    ListView thrillList;

    ArrayAdapter<String> thrillAdapter;
    ArrayList<Tasks> myTasks = new ArrayList<Tasks>();

    public thrillsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //add the listitems to the thrillList
        myTasks.add(new Tasks(getString(R.string.thrillTaskone), getString(R.string.thrillLocationone), R.drawable.bangeejumping, getString(R.string.thrillLocationoneaddress)));
        myTasks.add(new Tasks(getString(R.string.thrillTasktwo), getString(R.string.thrillLocationtwo), R.drawable.bodaride, getString(R.string.thrillLocationtwoaddress)));
        myTasks.add(new Tasks(getString(R.string.thrillTaskthree), getString(R.string.thrillLocationthree), R.drawable.thrillswing, getString(R.string.thrillLocationthreeaddress)));
        myTasks.add(new Tasks(getString(R.string.thrillTaskfour), getString(R.string.thrillLocationfour), R.drawable.giraffepark, getString(R.string.thrillLocationfouraddress)));

        //set fragment context pushed to constractor in custom array adapter
        tourThrillsAdapter thrillTourAdapter = new tourThrillsAdapter(this.getContext(), myTasks);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thrills, container, false);
        thrillList = view.findViewById(R.id.thrillsListview);
        thrillList.setAdapter(thrillTourAdapter);

        ///Set an onclick lister to launch the deatils intent
        thrillList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get the current song from the ArrayList (songs) with the position of the clicked item.
                Tasks currentTask = myTasks.get(position);
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