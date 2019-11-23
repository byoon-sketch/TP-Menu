package com.example.lunch_vote;
/*
A class to hold data about a users' votes to be added to the Firebase database
Benjamin Yoon
11/22/2019
Version 1.0
 */
public class Data {
    //instance data - the data that will be put into the database
    private String Email;
    private String Monday;
    private String Tuesday;
    private String Wednesday;
    private String Thursday;
    private String Friday;
    private String Saturday;
    private String Sunday;

    //necessary constructor to call the object
    public Data() {

    }

    //setters and getters to set the data based on the autocomplete text views
    //and to get the data to store
    public String getEmail(){
        return Email;
    }

    public void setEmail(String Email){
        this.Email = Email;
    }

    public String getMonday(){
        return Monday;
    }

    public void setMonday(String Monday){
        this.Monday = Monday;
    }

    public String getTuesday(){
        return Tuesday;
    }

    public void setTuesday(String Tuesday){
        this.Tuesday = Tuesday;
    }

    public String getWednesday(){
        return Wednesday;
    }

    public void setWednesday(String Wednesday){
        this.Wednesday = Wednesday;
    }

    public String getThursday(){
        return Thursday;
    }

    public void setThursday(String Thursday){
        this.Thursday = Thursday;
    }

    public String getFriday(){
        return Friday;
    }

    public void setFriday(String Friday){
        this.Friday = Friday;
    }

    public String getSaturday(){
        return Saturday;
    }

    public void setSaturday(String Saturday){
        this.Saturday = Saturday;
    }

    public String getSunday(){
        return Sunday;
    }

    public void setSunday(String Sunday){
        this.Sunday = Sunday;
    }
}


