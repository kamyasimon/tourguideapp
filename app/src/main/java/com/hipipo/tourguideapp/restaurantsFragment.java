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

public class restaurantsFragment extends Fragment {
    ListView restaurantlist;

    ArrayAdapter<String> restaurantAdapter;
    ArrayList<Tasks> myReserves = new ArrayList<Tasks>();

    public restaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //add the listitems to the restaurantlist
        myReserves.add(new Tasks(getString(R.string.restaurantcafejavas), getString(R.string.thrillLocationone), R.drawable.dayoffrestaurant, getString(R.string.thrillLocationoneaddress), getString(R.string.restaurantcafejavashrs)));
        myReserves.add(new Tasks(getString(R.string.restaurantdayoff), getString(R.string.thrillLocationtwo), R.drawable.cafejavas, getString(R.string.thrillLocationtwoaddress), getString(R.string.restaurantdayoffhrs)));
        myReserves.add(new Tasks(getString(R.string.restaurantroadfood), getString(R.string.thrillLocationthree), R.drawable.hitable, getString(R.string.thrillLocationthreeaddress), getString(R.string.restaurantroadfoodhrs)));
        myReserves.add(new Tasks(getString(R.string.restauranthitable), getString(R.string.thrillLocationfour), R.drawable.roadfood, getString(R.string.restauranthitablehrs)));
        //set fragment context pushed to constractor in custom array adapter
        tourThrillsAdapter thrillTourAdapter = new tourThrillsAdapter(this.getContext(), myReserves);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thrills, container, false);
        restaurantlist = view.findViewById(R.id.thrillsListview);
        restaurantlist.setAdapter(thrillTourAdapter);
        ///Set an onclick lister to launch the deatils intent
        restaurantlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get the current song from the ArrayList (songs) with the position of the clicked item.
                Tasks currentTask = myReserves.get(position);
                //get the song name and artist name from the currentPlayingSong object
                String Touractivity = currentTask.getTourActivities();
                String Tourlocation = currentTask.getTourLocations();
                String TourAddress = currentTask.getTourAddress();
                String TourOpenHours = currentTask.getWorkHours();
                int Tourimage = currentTask.getTourImages();
                Intent detailScreen = new Intent(view.getContext(), Thrills.class);
                detailScreen.putExtra("activity", Touractivity);
                detailScreen.putExtra("location", Tourlocation);
                detailScreen.putExtra("address", TourAddress);
                detailScreen.putExtra("image", String.valueOf(Tourimage));
                detailScreen.putExtra("time", TourOpenHours);
                startActivity(detailScreen);
            }
        });

        return view;
    }
}