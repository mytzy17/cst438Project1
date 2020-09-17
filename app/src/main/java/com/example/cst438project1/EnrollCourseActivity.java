package com.example.cst438project1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cst438project1.DB.AccountDAO;
import com.example.cst438project1.DB.AccountLog;
import com.example.cst438project1.DB.AppDatabase;
import com.example.cst438project1.DB.CourseDAO;
import com.example.cst438project1.DB.CourseDatabase;
import com.example.cst438project1.DB.EnrollDAO;
import com.example.cst438project1.DB.EnrollDatabase;
import com.example.cst438project1.DB.EnrollLog;

public class EnrollCourseActivity extends AppCompatActivity {

    Button enrollButton;
    EditText courseName;
    private AccountDAO accountLogDAO;
    private AppDatabase db;

    private EnrollDAO enrollDAO;
    private EnrollDatabase db2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_course);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, AppDatabase.databaseName)
                .allowMainThreadQueries()
                .build();

        accountLogDAO = db.getAccountDAO();


        db2 = Room.databaseBuilder(getApplicationContext(), EnrollDatabase.class, EnrollDatabase.databaseName)
                .allowMainThreadQueries()
                .build();

        enrollDAO = db2.getEnrollDAO();

        enrollButton = findViewById(R.id.enrollButton);
        courseName = findViewById(R.id.courseName);

        enrollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String course = courseName.getText().toString();

                if(course.equals("")){
                    AlertDialog.Builder b = new AlertDialog.Builder(EnrollCourseActivity.this);
                    b.setMessage("Incomplete Field");
                    b.setPositiveButton("DISMISS", null);

                    b.show();
                    return;
                }

            }
        });


    }
}