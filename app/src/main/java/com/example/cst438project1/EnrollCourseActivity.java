package com.example.cst438project1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import androidx.room.Room;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cst438project1.DB.AccountDAO;
import com.example.cst438project1.DB.AccountLog;
import com.example.cst438project1.DB.AppDatabase;
import com.example.cst438project1.DB.CourseDAO;
import com.example.cst438project1.DB.CourseDatabase;
import com.example.cst438project1.DB.CourseLog;
import com.example.cst438project1.DB.EnrollDAO;
import com.example.cst438project1.DB.EnrollDatabase;
import com.example.cst438project1.DB.EnrollLog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * EnrollCourseActivity enables users to enroll in a class that was created
 * in the AddCourseActivity.
 */

public class EnrollCourseActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button enrollButton;
    Button menuButton;
    private EnrollDAO enrollDAO;
    private EnrollDatabase db;

    private CourseDAO courseDAO;
    private CourseDatabase db2;

    AtomicInteger userId;
    List<Boolean> enrolled;
    HashSet<Integer> enrollmentList = new HashSet<Integer>();

    //Arrays for both Course and Enroll

    List<EnrollLog> getEnrollArray(){
        return enrollDAO.getEnrollByUserId(userId.get());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_course);
        final String[] information = getIntent().getStringArrayExtra("info");

        // Get the enroll database
        db = Room.databaseBuilder(getApplicationContext(), EnrollDatabase.class, EnrollDatabase.databaseName)
                .allowMainThreadQueries()
                .build();

        enrollDAO = db.getEnrollDAO();

        // Get the course database
        db2 = Room.databaseBuilder(getApplicationContext(), CourseDatabase.class, CourseDatabase.databaseCourses)
                .allowMainThreadQueries()
                .build();

        courseDAO = db2.getCourseDAO();

        //Button
        enrollButton = findViewById(R.id.enrollButton);
        menuButton = findViewById(R.id.menuButton);

        userId = new AtomicInteger(-1);
        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras != null){
                userId.set(extras.getInt("userId"));
            }
        }

        //Lists
        List<CourseLog> courses = courseDAO.getCourseLog();
        System.out.println(courses.size());
        System.out.println(courses.size());
        ArrayList<CharSequence> courseTitles = new ArrayList<>();


        for (CourseLog iterator: courses) {
            CharSequence title = iterator.getTitle();
            courseTitles.add(title);
        }
        final List<EnrollLog> enrollments = getEnrollArray();

        for(EnrollLog e: enrollments){
            enrollmentList.add(e.getCourseId());
        }

        enrolled = new ArrayList<>();
        for(CourseLog c: courses){
            enrolled.add(enrollmentList.contains(c.getCourseID()));
        }

        //Check if a course has been added
        if(courses.size() == 0){
            AlertDialog.Builder b = new AlertDialog.Builder(this);
            b.setTitle("REMINDER").setMessage("Add course before viewing page")
                    .setPositiveButton("DISMISS", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            //finish();
                        }
                    });
            b.create();
            b.show();
            return;
        }

        final Spinner sp = findViewById(R.id.courseSpinner);

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courseTitles);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final String text = parent.getItemAtPosition(position).toString();

        //Enrolled Button Pressed
        enrollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseLog selectedCourse = courseDAO.getCourseFromTitle(text);
                int courseId = selectedCourse.getCourseID();

                //adding the new enrollment into database
                if(!enrollmentList.contains(courseId)){
                    EnrollLog newEnroll = new EnrollLog(userId.get(), courseId);
                    EnrollDAO enrollmentDAO = enrollDAO;
                    enrollmentDAO.insert(newEnroll);

                    //Notifies that user was enrolled in course
                    Toast.makeText(getApplicationContext(), "Successfully Enrolled in " + text, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Already Enrolled in " + text, Toast.LENGTH_SHORT).show();
                }
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EnrollCourseActivity.this, MenuActivity.class);
                final String[] information = getIntent().getStringArrayExtra("info");
                i.putExtra("info", information);
                startActivity(i);
            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}