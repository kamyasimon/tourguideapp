package com.hipipo.tourguideapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabs;
    ViewPager2 viewPager;
    FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allviews();
    }

    public void allviews() {
        tabs = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        FragmentManager fragments = getSupportFragmentManager();
        fragmentAdapter = new FragmentAdapter(fragments, getLifecycle());
        viewPager.setAdapter(fragmentAdapter);

        tabs.addTab(tabs.newTab().setText(getText(R.string.thrillsTab)));
        tabs.addTab(tabs.newTab().setText(R.string.eventsTab));
        tabs.addTab(tabs.newTab().setText(R.string.restaurantsTab));
        tabs.addTab(tabs.newTab().setText(R.string.monumentsTab));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}