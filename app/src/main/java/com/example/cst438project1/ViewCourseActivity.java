package com.example.cst438project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cst438project1.DB.AssignmentDAO;
import com.example.cst438project1.DB.AssignmentDatabase;
import com.example.cst438project1.DB.AssignmentLog;
import com.example.cst438project1.DB.CourseDAO;
import com.example.cst438project1.DB.CourseDatabase;
import com.example.cst438project1.DB.CourseLog;
import com.example.cst438project1.DB.GradeDAO;
import com.example.cst438project1.DB.GradeDatabase;
import com.example.cst438project1.DB.GradeLog;

import java.util.ArrayList;
import java.util.List;

public class ViewCourseActivity extends AppCompatActivity {

    // UI element declarations
    Button categoriesButton;
    Button menuButton;
    Button assignmentsButton;
    TextView courseTitle;
    TextView courseInstructor;
    TextView courseStartDate;
    TextView courseEndDate;
    TextView courseDescription;
    private CourseDAO courseDAO;
    private CourseDatabase dbCourse;
    private AssignmentDAO assignmentDAO;
    private AssignmentDatabase dbAssignments;
    private GradeDAO gradeDAO;
    private GradeDatabase dbGrade;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_course);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        categoriesButton = findViewById(R.id.categoriesButton);
        menuButton = findViewById(R.id.menuButton);
        assignmentsButton = findViewById(R.id.assignmentsButton);
        courseTitle = (TextView) findViewById(R.id.courseTitle);
        courseInstructor = (TextView) findViewById(R.id.courseInstructor);
        courseStartDate = (TextView) findViewById(R.id.courseStartDate);
        courseEndDate = (TextView) findViewById(R.id.courseEndDate);
        courseDescription = (TextView) findViewById(R.id.courseDescription);


        // Course Database
        dbCourse = Room.databaseBuilder(getApplicationContext(), CourseDatabase.class, CourseDatabase.databaseCourses)
                .allowMainThreadQueries()
                .build();
        courseDAO = dbCourse.getCourseDAO();

        dbAssignments = Room.databaseBuilder(getApplicationContext(), AssignmentDatabase.class, AssignmentDatabase.databaseName)
                .allowMainThreadQueries()
                .build();
        assignmentDAO = dbAssignments.getAssigmentDAO();

        dbGrade = Room.databaseBuilder(getApplicationContext(), GradeDatabase.class, GradeDatabase.databaseName)
                .allowMainThreadQueries()
                .build();
        gradeDAO = dbGrade.getGradeDAO();

        // find course info and set it
        final String courseID = getIntent().getStringExtra("courseName");
        CourseLog selectedCourse = courseDAO.getCourseFromTitle(courseID);
        courseTitle.setText(selectedCourse.getTitle());
        courseInstructor.setText(selectedCourse.getInstructor());
        courseStartDate.setText(selectedCourse.getStartDate());
        courseEndDate.setText(selectedCourse.getEndDate());
        courseDescription.setText(selectedCourse.getDesc());

        // Button presses
        // Assignment Button
        assignmentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewCourseActivity.this, ViewAssignmentsActivity.class);
                segue(i);
            }
        });


        // Functions for the purpose of testing and development
        List<GradeLog> gradeList = gradeDAO.getGradeLog();
        List<AssignmentLog> assignmentList = assignmentDAO.getAssignmentLog();

        if (gradeList.size() == 0) {
            GradeLog newGrade1 = new GradeLog("Tests", 20, "01/01/2020", 0);
            GradeLog newGrade2 = new GradeLog("Homework", 50, "01/01/2020", 0);
            gradeDAO.insert(newGrade1);
            gradeDAO.insert(newGrade2);
        }

        if (assignmentList.size() == 0) {
            GradeLog getHWCategory = gradeDAO.getGradeWithTitle("Tests");
            int hwCategoryID = getHWCategory.getCategoryID();
            GradeLog getTestCategory = gradeDAO.getGradeWithTitle("Homework");
            int testCategoryID = getTestCategory.getCategoryID();
            String courseTitle = getIntent().getStringExtra("courseName");
            CourseLog selectedCourseTHISTIME = courseDAO.getCourseFromTitle(courseTitle);
            int courseIDTHISTIME = selectedCourseTHISTIME.getCourseID();

            AssignmentLog newAssignment1 = new AssignmentLog("Do HW real good", 100, 50, "01/02/2020", hwCategoryID, courseIDTHISTIME);
            AssignmentLog newAssignment2 = new AssignmentLog("Do Test real good", 40, 40, "06/06/2020", testCategoryID, courseIDTHISTIME);
            assignmentDAO.insert(newAssignment1);
            assignmentDAO.insert(newAssignment2);
        }

        // Categories Button
        categoriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewCourseActivity.this, ViewCategoriesActivity.class);
                segue(i);
            }
        });

        // Back Button
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewCourseActivity.this, MenuActivity.class);
                segue(i);
            }
        });

    }

    // Method to handle intents and seques
    public void segue(Intent destination) {
        final String [] information = getIntent().getStringArrayExtra("info");
        final String courseName = getIntent().getStringExtra("courseName");
        destination.putExtra("info", information);
        destination.putExtra("courseName", courseName);
        startActivity(destination);
    }
}