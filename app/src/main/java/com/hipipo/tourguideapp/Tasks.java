package com.hipipo.tourguideapp;

public class Tasks {
    private String tourActivities;
    private String tourLocations;
    private int tourImages;
    private String tourAddress;



    public Tasks(String tourActivities, String tourLocations, int tourImages) {
        this.tourActivities = "Activity: " + tourActivities;
        this.tourLocations = "Location: " + tourLocations;
        this.tourImages = tourImages;
    }

    public String getTourLocations() {
        return tourLocations;
    }

    public String getTourActivities() {
        return tourActivities;
    }

    public int getTourImages() {
        return tourImages;
    }
    public int getTourAddress() {
        return getTourAddress();
    }

}
