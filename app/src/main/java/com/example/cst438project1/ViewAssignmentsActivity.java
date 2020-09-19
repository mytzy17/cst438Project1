package com.example.cst438project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ViewAssignmentsActivity extends AppCompatActivity {

    Button editButton;
    Button addButton;
    Button deleteButton;
    Button returnButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_assignments);

        editButton = findViewById(R.id.editButton);
        addButton = findViewById(R.id.addButton);
        deleteButton = findViewById(R.id.deleteButton);
        returnButton = findViewById(R.id.returnButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ViewAssignments", "Add Assignment Activity was called");
                Intent i = new Intent(ViewAssignmentsActivity.this, AddAssignmentActivity.class);
                startActivity(i);
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ViewAssignments", "Add Assignment Activity was called");
                Intent i = new Intent(ViewAssignmentsActivity.this, EditAssignmentActivity.class);
                startActivity(i);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ViewAssignments", " View Course Activity was called");
                Intent i = new Intent(ViewAssignmentsActivity.this, ViewCourseActivity.class);
                startActivity(i);
            }
        });



    }
}