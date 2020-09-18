package com.example.cst438project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cst438project1.DB.AccountLog;
import com.example.cst438project1.DB.AppDatabase;

import java.util.concurrent.atomic.AtomicInteger;

public class MenuActivity extends AppCompatActivity {

    Button enrollButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button profileButton = findViewById(R.id.profileButton);
        Button addCourseButton = findViewById(R.id.addCourse);
        enrollButton = findViewById(R.id.enrollButton);

        final String[] information = getIntent().getStringArrayExtra("info");
        final String userName = information[0];
        final String passWord = information[3];
        final String fName = information[1];
        final String lName = information[2];

        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create our intent
                Intent i = new Intent(MenuActivity.this, AddCourseActivity.class);
                final String[] information = getIntent().getStringArrayExtra("info");
                i.putExtra("info", information);
                startActivity(i);
            }
        });

        enrollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create our intent
                Intent i = new Intent(MenuActivity.this, EnrollCourseActivity.class);
                final String[] information = getIntent().getStringArrayExtra("info");
                i.putExtra("info", information);
                startActivity(i);
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //Create our intent
            Intent i = new Intent(MenuActivity.this, ViewProfileActivity.class);
            i.putExtra("username", userName);
            i.putExtra("info", information);
            startActivity(i);
            }
        });

    }
}