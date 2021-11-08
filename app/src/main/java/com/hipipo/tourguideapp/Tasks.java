package com.hipipo.tourguideapp;

public class Tasks {
    private String tourActivities;
    private String tourLocations;
    private int tourImages;
    private String tourAddress;
    private String workHours;

    public Tasks(String tourActivities, String tourLocations, int tourImages, String tourAddress) {
        this.tourActivities = tourActivities;
        this.tourLocations = tourLocations;
        this.tourImages = tourImages;
        this.tourAddress = tourAddress;
    }

    public Tasks(String tourActivities, String tourLocations, int tourImages, String tourAddress, String workHours) {
        this.tourActivities = tourActivities;
        this.tourLocations = tourLocations;
        this.tourImages = tourImages;
        this.tourAddress = tourAddress;
        this.workHours = workHours;
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

    public String getWorkHours() {
        return this.workHours;
    }

}
