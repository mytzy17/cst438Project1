package com.example.cst438project1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cst438project1.DB.AccountLog;
import com.example.cst438project1.DB.CourseDAO;
import com.example.cst438project1.DB.CourseDatabase;
import com.example.cst438project1.DB.CourseLog;

public class AddCourseActivity extends AppCompatActivity {

    private CourseDatabase db;
    private CourseDAO courseDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        db = Room.databaseBuilder(getApplicationContext(), CourseDatabase.class, CourseDatabase.databaseCourses)
                .allowMainThreadQueries()
                .build();
        courseDAO = db.getCourseDAO();

        Button saveCourseButton = findViewById(R.id.saveCourseButton);
        final EditText courseTitleTextView = findViewById(R.id.courseTitleTextView);
        final EditText startDateTextView = findViewById(R.id.startDateTextView);
        final EditText endDateTextView = findViewById(R.id.endDateTextView);
        final EditText descriptionTextView = findViewById(R.id.descriptionTextView);
        final EditText instructorTextView = findViewById(R.id.instructorTextView);

        saveCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create the variables

                String courseTitle = courseTitleTextView.getText().toString();
                String startDate = startDateTextView.getText().toString();
                String endDate = endDateTextView.getText().toString();
                String description = descriptionTextView.getText().toString();
                String instructor = instructorTextView.getText().toString();

                //Checks whether or not the all fields are filled out!
                if(courseTitle.equals("") || startDate.equals("") || endDate.equals("") || description.equals("") || instructor.equals("")){
                    AlertDialog.Builder b = new AlertDialog.Builder(AddCourseActivity.this);
                    b.setMessage("Incomplete Fields");
                    b.setPositiveButton("DISMISS", null);

                    b.show();
                    return;
                }

                //Info comes from AccountLog, user info
                //AccountLog user = AppDatabase.getAppDatabase(CreateAccountActivity.this).getAccountDAO().getUserByName(userName);
                CourseLog course = new CourseLog(instructor, courseTitle, description, startDate, endDate);

                // Inserting test account into database
                boolean courseExistsAlready = courseDAO.getCourseFromTitle(courseTitle);

                if(!courseExistsAlready){
                    //Adds a new user into the database
                    CourseLog newCourse = new CourseLog(instructor, courseTitle, description, startDate, endDate);
                    courseDAO.insert(newCourse);

                    //Log Record needed I think, code below

                    //notifies the user that their account has been created
                    Toast.makeText(getApplicationContext(), "Course created successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(AddCourseActivity.this, MenuActivity.class);
                    startActivity(i);
                }else{
                    //user already exists
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddCourseActivity.this);
                    builder.setMessage("Try again, course  not available");
                    builder.setPositiveButton("OK", null);

                    builder.show();
                }

            }
        });
    }
}