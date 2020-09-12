package com.example.cst438project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        final String userName = getIntent().getStringExtra("username");
        final String passWord = getIntent().getStringExtra("password");
        final String fName = getIntent().getStringExtra("fName");
        final String lName = getIntent().getStringExtra("lName");

//        TextView usernameTextView = findViewById(R.id.usernameTextView);
        //Add button to go back to profile Activity and include 4 lines below also
//        i.putExtra("username", userName);
//        i.putExtra("fName", fName);
//        i.putExtra("lName", lName);
//        i.putExtra("password", passWord);

        // changes to the database to be added
    }
}