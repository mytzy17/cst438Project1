package com.example.cst438project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ViewProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        EditText usernameTextView = findViewById(R.id.userName);
        EditText fNameTextView = findViewById(R.id.firstName);
        EditText lNameTextView = findViewById(R.id.lastName);
        EditText courseTextView = findViewById(R.id.courseTextView);

        final String userName = getIntent().getStringExtra("username");
        final String passWord = getIntent().getStringExtra("password");
        final String fName = getIntent().getStringExtra("fName");
        final String lName = getIntent().getStringExtra("lName");

        usernameTextView.setText(userName);
        fNameTextView.setText(fName);
        lNameTextView.setText(lName);

        courseTextView.setText("Tested courses");

        Button mainMenuButton = findViewById(R.id.mainMenuButton);
        Button editProfileButton = findViewById(R.id.editProfileButton);

        mainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create our intent
                Intent i = new Intent(ViewProfileActivity.this, MenuActivity.class);
                startActivity(i);
            }
        });

        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create our intent
                Intent i = new Intent(ViewProfileActivity.this, EditProfileActivity.class);
                startActivity(i);
            }
        });
    }
}