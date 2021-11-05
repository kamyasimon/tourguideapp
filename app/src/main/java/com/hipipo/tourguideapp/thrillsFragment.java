package com.hipipo.tourguideapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link thrillsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class thrillsFragment extends Fragment {
        ListView thrillList;

        ArrayAdapter <String> thrillAdapter;
        ArrayList<Tasks> myTasks = new ArrayList<Tasks>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public thrillsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment thrillsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static thrillsFragment newInstance(String param1, String param2) {
        thrillsFragment fragment = new thrillsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //add the listitems to the thrillList
        myTasks.add(new Tasks(getString(R.string.thrillTaskone), getString(R.string.thrillLocationone),R.drawable.bangeejumping,getString(R.string.thrillLocationoneaddress)));
        myTasks.add(new Tasks(getString(R.string.thrillTasktwo), getString(R.string.thrillLocationtwo),R.drawable.bodaride,getString(R.string.thrillLocationtwoaddress)));
        myTasks.add(new Tasks(getString(R.string.thrillTaskthree), getString(R.string.thrillLocationthree),R.drawable.thrillswing,getString(R.string.thrillLocationthreeaddress)));
        myTasks.add(new Tasks(getString(R.string.thrillTaskfour), getString(R.string.thrillLocationfour),R.drawable.giraffepark,getString(R.string.thrillLocationfouraddress)));


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

                Intent detailScreen = new Intent(view.getContext(),Thrills.class);
                detailScreen.putExtra("activity", Touractivity);
                detailScreen.putExtra("location", Tourlocation);
                detailScreen.putExtra("address", TourAddress);
                detailScreen.putExtra("image", Tourimage);
                startActivity(detailScreen);
            }
        });

        return view;


    }


}