package com.example.cst438project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
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
import java.util.List;

public class SelectCourseActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //UI element declarations
    Button viewCourseButton;
    Button menuButton;
    private EnrollDAO enrollDAO;
    private EnrollDatabase dbEnroll;
    private CourseDAO courseDAO;
    private CourseDatabase dbCourse;
    private AccountDAO accountDAO;
    private AppDatabase dbAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_course);

        // Get the enroll database
        dbEnroll = Room.databaseBuilder(getApplicationContext(), EnrollDatabase.class, EnrollDatabase.databaseName)
                .allowMainThreadQueries()
                .build();

        enrollDAO = dbEnroll.getEnrollDAO();

        // Get the course database
        dbCourse = Room.databaseBuilder(getApplicationContext(), CourseDatabase.class, CourseDatabase.databaseCourses)
                .allowMainThreadQueries()
                .build();

        courseDAO = dbCourse.getCourseDAO();

        // Get the account database
        dbAccount = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, AppDatabase.databaseName)
                .allowMainThreadQueries()
                .build();

        accountDAO = dbAccount.getAccountDAO();

        // Button Declarations
        viewCourseButton = findViewById(R.id.ViewCourseButton);
        menuButton = findViewById(R.id.menuButton);

        // Get a list of the Courses the user is in
        final String[] information = getIntent().getStringArrayExtra("info");
        //assert information != null;
        String username = information[0];
        AccountLog userAccount = accountDAO.getUserByName(username);
        int userID = userAccount.getAccountId()-1;
        List<EnrollLog> enrolledCourses = enrollDAO.getEnrollByUserId(userID);

        // If list is 0
        if (enrolledCourses.size() == 0) {
            Toast.makeText(this, "Error, no enrolled courses", Toast.LENGTH_LONG);
        }

        // CharSequence ArrayList for Spinner, populated with currently enrolled courses
        ArrayList<CharSequence> courseTitles = new ArrayList<>();
        for (EnrollLog iterator: enrolledCourses) {
            int titleID = iterator.getCourseId();
            CourseLog titleCourse = courseDAO.getCourseWithId(titleID);
            CharSequence title = titleCourse.getTitle();
            courseTitles.add(title);
        }


        // Declare Spinner
        final Spinner sp = findViewById(R.id.courseSpinner);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courseTitles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(this);

        // Return (to menu) button
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectCourseActivity.this, MenuActivity.class);
                final String[] information = getIntent().getStringArrayExtra("info");
                i.putExtra("info", information);
                startActivity(i);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final String text = parent.getItemAtPosition(position).toString();

        // Pressed View Course Button
        viewCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseLog selectedCourse = courseDAO.getCourseFromTitle(text);
                int courseID = selectedCourse.getCourseID();

                Intent i = new Intent(SelectCourseActivity.this, ViewCourseActivity.class);
                final String [] information = getIntent().getStringArrayExtra("info");
                i.putExtra("info", information);
                i.putExtra("courseName", text);
                startActivity(i);
            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}