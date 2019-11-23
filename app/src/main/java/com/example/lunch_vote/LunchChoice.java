package com.example.lunch_vote;

import java.util.ArrayList;
import java.util.List;

/*
A class to hold data derived from the Firebase Database about the Lunch menu,
for the autocomplete Textviews in the Lunch class
 */
public class LunchChoice {
    //creating an array list to store the data in
    static ArrayList<LunchChoice> choices = new ArrayList<>();
    String lunchName;

    //constructor
    LunchChoice(String lunchName) {
        this.lunchName = lunchName;
    }

    public static ArrayList<LunchChoice> getCourses() {
        return choices;
    }

    ////setChoices method to set the autocomplete Textviews
    public static void setChoices(List<LunchChoice> c) {
        choices = (ArrayList<LunchChoice>) c;
    }

    //Getters and Setters
    public String getLunchName(){
        return lunchName;
    }

    public void setLunchName(String lunchName){
        this.lunchName = lunchName;
    }

    //toString method
    public String toString(){
        return "" + lunchName;
    }
}