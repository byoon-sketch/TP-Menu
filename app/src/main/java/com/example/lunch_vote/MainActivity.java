package com.example.lunch_vote;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/*
A program to allow users to vote for lunch for lunch and dinner,
based on a menu from a Firebase database.

A class to serve as a hub for the Lunch and Dinner Activities

Benjamin Yoon
11/18/2019
Version 1.1 - | email TextView removed, replaced with name. This has no function,
I just did not want to leave that space blank.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    //onCreate method to set the scene
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //onClickLunch method to take the user to the Lunch activity to vote... uses intents
    public void onClickLunch(View view){
        Intent intent = new Intent(this, Lunch.class);
        startActivity(intent);
    }

    //onClickDinner method to take the user to the Dinner activity to vote... uses intents
    public void onClickDinner(View view){
        Intent intent = new Intent(this, Dinner.class);
        startActivity(intent);
    }

}
