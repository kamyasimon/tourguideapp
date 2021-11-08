package com.hipipo.tourguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Thrills extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thrills);
        displayTourDetails();
    }

    public void displayTourDetails() {
        Intent tourDetail = getIntent();
        String activity = tourDetail.getStringExtra("activity");
        String location = tourDetail.getStringExtra("location");
        String address = tourDetail.getStringExtra("address");
        String image = tourDetail.getStringExtra("image");
        String workHours = tourDetail.getStringExtra("time");

        ///HERE IS WHERE THE ISSUE IS COMING FROM.../////
        ImageView tourImage = findViewById(R.id.yourThrillImage);
        int imageId = getResources().getIdentifier(image, "Drawable", getPackageName());
        tourImage.setImageResource(imageId);
        ////the above is the issue

        TextView tourActivity = findViewById(R.id.tourActivity);
        tourActivity.setText(activity);

        TextView tourLocation = findViewById(R.id.tourLocation);
        tourLocation.setText(location);

        TextView tourAddress = findViewById(R.id.tourAddress);
        if (workHours != null) {
            tourAddress.setText(address + '\n' + workHours);
        } else {
            tourAddress.setText(address);
        }

    }

}