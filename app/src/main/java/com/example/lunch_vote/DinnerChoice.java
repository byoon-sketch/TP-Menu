package com.example.lunch_vote;

import java.util.ArrayList;
import java.util.List;

/*
A class to hold data derived from the Firebase Database about the Dinner menu,
for the autocomplete Textviews in the Dinner class
 */
public class DinnerChoice {
    //creating an array list to store the data in
    static ArrayList<DinnerChoice> choice = new ArrayList<>();
    String dinnerName;

    //constructor
    DinnerChoice(String dinnerName) {
        this.dinnerName = dinnerName;
    }

    public static ArrayList<DinnerChoice> getCourses() {
        return choice;
    }

    //setChoice method to set the autocomplete Textviews
    public static void setChoice(List<DinnerChoice> c) {
        choice = (ArrayList<DinnerChoice>) c;
    }

    //Getters and Setters
    public String getDinnerName(){
        return dinnerName;
    }

    public void setDinnerName(String dinnerName){
        this.dinnerName = dinnerName;
    }

    //toString method
    public String toString(){
        return "" + dinnerName;
    }
}
