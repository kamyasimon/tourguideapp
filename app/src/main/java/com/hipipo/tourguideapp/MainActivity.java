package com.hipipo.tourguideapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

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
        fragmentAdapter = new FragmentAdapter(fragments,getLifecycle());
        viewPager.setAdapter(fragmentAdapter);




        tabs.addTab(tabs.newTab().setText("Thrills"));
        tabs.addTab(tabs.newTab().setText("Events"));
        tabs.addTab(tabs.newTab().setText("Restaurants"));
        tabs.addTab(tabs.newTab().setText("Monuments"));

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