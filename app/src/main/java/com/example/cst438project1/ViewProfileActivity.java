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

        TextView usernameTextView = findViewById(R.id.usernameTextView);
        TextView fullNameTextView = findViewById(R.id.fullName);

        final String[] information = getIntent().getStringArrayExtra("info");

        final String userName = information[0];
        final String passWord = information[3];
        final String fName = information[1];
        final String lName = information[2];

        usernameTextView.setText("Your Username: " + userName);
        fullNameTextView.setText(fName + " " + lName);

        Button mainMenuButton = findViewById(R.id.menuButton);
        Button editProfileButton = findViewById(R.id.editProfileButton);

        mainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewProfileActivity.this, MenuActivity.class);
                i.putExtra("info", information);
                startActivity(i);
            }
        });

        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewProfileActivity.this, EditProfileActivity.class);
                i.putExtra("info", information);
                startActivity(i);
            }
        });
    }
}