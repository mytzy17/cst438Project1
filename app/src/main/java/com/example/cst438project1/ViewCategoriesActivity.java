package com.example.cst438project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.cst438project1.DB.GradeDAO;
import com.example.cst438project1.DB.GradeDatabase;
import com.example.cst438project1.DB.GradeLog;

public class ViewCategoriesActivity extends AppCompatActivity {

    private GradeDAO gradeDAO;

    private GradeDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_categories);

        db = Room.databaseBuilder(getApplicationContext(), GradeDatabase.class, GradeDatabase.databaseName)
                .allowMainThreadQueries()
                .build();
        gradeDAO = db.getGradeDAO();

        Button addGradeButton = findViewById(R.id.addButton);
        addGradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewCategoriesActivity.this, AddCategoryActivity.class);
                startActivity(i);
            }
        });


        //User will be taken to the Login Activity
        Button editGradeButton = findViewById(R.id.editButton);
        editGradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewCategoriesActivity.this, EditCategoryActivity.class);
                startActivity(i);
            }
        });

        Button deleteGradeButton = findViewById(R.id.deleteButton);
        deleteGradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewCategoriesActivity.this, ViewCourseActivity.class);
//                final String courseName = getIntent().getStringExtra("courseName");
//                GradeLog grade = gradeDAO.getGradeWithTitle(courseName);
                startActivity(i);
            }
        });

        Button menuButton = findViewById(R.id.mainMenuButton);
        deleteGradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewCategoriesActivity.this, MenuActivity.class);
                final String[] courseID = getIntent().getStringArrayExtra("courseID");
                i.putExtra("courseID", courseID);
                startActivity(i);
            }
        });
    }
}