package com.example.lunch_vote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

/*
A class to allow users to vote for a meal of their choice for dinner,
using autocomplete text views and a Firebase database to get dinner options,
and to store the users' choices in a Firebase database

Benjamin Yoon
11/19/2019
Version 1.3 - added an email EditText | added data to the Firebase
 */
public class Dinner extends AppCompatActivity {
    //declaring the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference();

    //declaring the AutoCompleteTextViews
    AutoCompleteTextView editText;
    AutoCompleteTextView editText2;
    AutoCompleteTextView editText3;
    AutoCompleteTextView editText4;
    AutoCompleteTextView editText5;
    AutoCompleteTextView editText6;
    AutoCompleteTextView editText7;

    //creating an Arraylist of DinnerChoice objects,
    //which is a class that finds and stores dinner options from the Firebase database
    final List<DinnerChoice> dinnerSpecimens = new ArrayList<>();

    //declaring email Edit Textview
    EditText email;

    //declaring a data object,
    //which is a class I made that stores all of the data that will be stored in the Firebase database.
    Data data;

    @Override
    //onCreate method which sets the scene and instantiates the Autocompete text views
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);

        editText = findViewById(R.id.actv);
        ArrayAdapter<DinnerChoice> adapter = new ArrayAdapter<DinnerChoice>(this, android.R.layout.simple_list_item_1, dinnerSpecimens);
        editText.setAdapter(adapter);

        editText2 = findViewById(R.id.actv2);
        ArrayAdapter<DinnerChoice> adapter2 = new ArrayAdapter<DinnerChoice>(this, android.R.layout.simple_list_item_1, dinnerSpecimens);
        editText2.setAdapter(adapter2);

        editText3 = findViewById(R.id.actv3);
        ArrayAdapter<DinnerChoice> adapter3 = new ArrayAdapter<DinnerChoice>(this, android.R.layout.simple_list_item_1, dinnerSpecimens);
        editText3.setAdapter(adapter3);

        editText4 = findViewById(R.id.actv4);
        ArrayAdapter<DinnerChoice> adapter4 = new ArrayAdapter<DinnerChoice>(this, android.R.layout.simple_list_item_1, dinnerSpecimens);
        editText4.setAdapter(adapter4);

        editText5 = findViewById(R.id.actv5);
        ArrayAdapter<DinnerChoice> adapter5 = new ArrayAdapter<DinnerChoice>(this, android.R.layout.simple_list_item_1, dinnerSpecimens);
        editText5.setAdapter(adapter5);

        editText6 = findViewById(R.id.actv6);
        ArrayAdapter<DinnerChoice> adapter6 = new ArrayAdapter<DinnerChoice>(this, android.R.layout.simple_list_item_1, dinnerSpecimens);
        editText6.setAdapter(adapter6);

        editText7 = findViewById(R.id.actv7);
        ArrayAdapter<DinnerChoice> adapter7 = new ArrayAdapter<DinnerChoice>(this, android.R.layout.simple_list_item_1, dinnerSpecimens);
        editText7.setAdapter(adapter7);
    }

    //onStart method to add the data to the dinnerSpecimens Arraylist
    protected void onStart(){
        super.onStart();
        if (dinnerSpecimens.size() < 20) {
            databaseReference.child("DinnerChoice").addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                    for (DataSnapshot child : children) {
                        dinnerSpecimens.add(new DinnerChoice(child.child("Dinnername").getValue(String.class)));
                    }
                    DinnerChoice.setChoice(dinnerSpecimens); //adding the data
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

    }

    //onClick method to add the data that the user voted for to the Firebase database
    public void onClickVote(View view){
        data = new Data();
        email = findViewById(R.id.email);
        data.setEmail(email.getText().toString());
        data.setMonday(editText.getText().toString());
        data.setTuesday(editText2.getText().toString());
        data.setWednesday(editText3.getText().toString());
        data.setThursday(editText4.getText().toString());
        data.setFriday(editText5.getText().toString());
        data.setSaturday(editText6.getText().toString());
        data.setSunday(editText7.getText().toString());
        databaseReference.child("DinnerResult").push().setValue(data);
    }
}
