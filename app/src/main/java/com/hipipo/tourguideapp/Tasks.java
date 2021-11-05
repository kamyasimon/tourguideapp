package com.hipipo.tourguideapp;

public class Tasks {
    private String tourActivities;
    private String tourLocations;
    private int tourImages;
    private String tourAddress;



    public Tasks(String tourActivities, String tourLocations, int tourImages, String tourAddress) {
        this.tourActivities = "Activity: " + tourActivities;
        this.tourLocations = "Location: " + tourLocations;
        this.tourImages = tourImages;
        this.tourAddress = tourAddress;
    }

    public String getTourLocations() {
        return this.tourLocations;
    }

    public String getTourActivities() {
        return this.tourActivities;
    }

    public int getTourImages() {
        return tourImages;
    }

    public String getTourAddress() {
        return this.tourAddress;
    }

}
