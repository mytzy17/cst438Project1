package com.example.cst438project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button profileButton = findViewById(R.id.profileButton);
        final String userName = getIntent().getStringExtra("username");
        final String passWord = getIntent().getStringExtra("password");
        final String fName = getIntent().getStringExtra("fName");
        final String lName = getIntent().getStringExtra("lName");

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Create our intent
                Intent i = new Intent(MenuActivity.this, ViewProfileActivity.class);

                i.putExtra("username", userName);
                i.putExtra("fName", fName);
                i.putExtra("lName", lName);
                i.putExtra("password", passWord);
                startActivity(i);
            }
        });

    }
}