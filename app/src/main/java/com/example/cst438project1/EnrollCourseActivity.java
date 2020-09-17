package com.example.cst438project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.example.cst438project1.DB.AccountDAO;
import com.example.cst438project1.DB.AppDatabase;
import com.example.cst438project1.DB.CourseDAO;
import com.example.cst438project1.DB.CourseDatabase;
import com.example.cst438project1.DB.EnrollDAO;
import com.example.cst438project1.DB.EnrollDatabase;

public class EnrollCourseActivity extends AppCompatActivity {

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

        //Hello just checking here

    }
}