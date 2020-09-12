package com.example.cst438project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        TextView usernameTextView = findViewById(R.id.userName);
        TextView fullNameTextView = findViewById(R.id.fullName);
        TextView courseTextView = findViewById(R.id.courseTextView);

        final String userName = getIntent().getStringExtra("username");
        final String passWord = getIntent().getStringExtra("password");
        final String fName = getIntent().getStringExtra("fName");
        final String lName = getIntent().getStringExtra("lName");

        usernameTextView.setText("Your Username: " + userName);
        fullNameTextView.setText(fName + " " + lName);

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