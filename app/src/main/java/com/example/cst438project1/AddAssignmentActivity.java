package com.example.cst438project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import androidx.room.Room;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cst438project1.DB.AssignmentDAO;
import com.example.cst438project1.DB.AssignmentDatabase;
import com.example.cst438project1.DB.AssignmentLog;
import com.example.cst438project1.DB.CourseDAO;
import com.example.cst438project1.DB.CourseDatabase;
import com.example.cst438project1.DB.CourseLog;

public class AddAssignmentActivity extends AppCompatActivity {

    EditText details;
    EditText maxScore;
    EditText earnedScore;
    EditText dueDate;
    EditText categoryId;
    EditText courseId;

    Button saveButton;

    private AssignmentDatabase db;
    private AssignmentDAO mAssignmentDAO;

    private CourseDAO courseDAO;
    private CourseDatabase dbCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assignment);

        db = Room.databaseBuilder(getApplicationContext(), AssignmentDatabase.class, AssignmentDatabase.databaseName)
                .allowMainThreadQueries()
                .build();
        mAssignmentDAO = db.getAssigmentDAO();

        dbCourse = Room.databaseBuilder(getApplicationContext(), CourseDatabase.class, CourseDatabase.databaseCourses)
                .allowMainThreadQueries()
                .build();

        courseDAO = dbCourse.getCourseDAO();

        details = findViewById(R.id.assignmentDetails);
        maxScore = findViewById(R.id.maxScore);
        earnedScore = findViewById(R.id.earnedScore);
        dueDate = findViewById(R.id.dueDate);
        categoryId = findViewById(R.id.categoryId);
        courseId = findViewById(R.id.courseId);

        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String detailsInfo = details.getText().toString();

                String max =  maxScore.getText().toString();
                double maxValue = 0;
                if (!"".equals(max)){
                    maxValue = Double.parseDouble(max);
                }

                String earned =  earnedScore.getText().toString();
                double earnedValue = 0;
                if (!"".equals(earned)){
                    earnedValue = Double.parseDouble(earned);
                }

                String dueDates = dueDate.getText().toString();

                String categoryID =categoryId.getText().toString();
                int categoryValue = 0;
                if (!"".equals(categoryID)){
                    categoryValue =Integer.parseInt(categoryID);
                }

                String courseID =courseId.getText().toString();
                int courseValue = 0;
                if (!"".equals(courseID)){
                    courseValue =Integer.parseInt(courseID);
                }

                AssignmentLog newAssignment = new AssignmentLog(detailsInfo, maxValue, earnedValue, dueDates, categoryValue, courseValue);
                mAssignmentDAO.insert(newAssignment);

                Toast.makeText(getApplicationContext(), "Assignment created successfully", Toast.LENGTH_SHORT).show();

                final String text = getIntent().getStringExtra("courseName");

                Intent i = new Intent(AddAssignmentActivity.this, ViewCourseActivity.class);
                final String [] information = getIntent().getStringArrayExtra("info");
                i.putExtra("info", information);
                i.putExtra("courseName", text);
                startActivity(i);

            }
        });
    }

}