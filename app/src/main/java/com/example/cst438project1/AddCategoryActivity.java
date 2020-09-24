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
import com.example.cst438project1.DB.AppDatabase;
import com.example.cst438project1.DB.CourseDAO;
import com.example.cst438project1.DB.GradeDAO;
import com.example.cst438project1.DB.GradeDatabase;
import com.example.cst438project1.DB.GradeLog;

public class AddCategoryActivity extends AppCompatActivity {
    private GradeDAO gradeDAO;

    private GradeDatabase db;

    Button saveButton;
    EditText categoryTitleTextView;
    EditText weightTextView;
    EditText assignedDateTextView;
    EditText categoryIDTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_categories);
        db = Room.databaseBuilder(getApplicationContext(), GradeDatabase.class, GradeDatabase.databaseName)
                .allowMainThreadQueries()
                .build();
        gradeDAO = db.getGradeDAO();

        categoryTitleTextView = findViewById(R.id.categoryTitleTextView);
        weightTextView = findViewById(R.id.weightTextView);
        assignedDateTextView = findViewById(R.id.assignedDateTextView);
        categoryIDTextView = findViewById(R.id.categoryIDTextView);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String categoryTitle = categoryTitleTextView.getText().toString();
                String weight = weightTextView.getText().toString();
                String categoryID = categoryIDTextView.getText().toString();
                String assignedDate = assignedDateTextView.getText().toString();

                //Checks whether or not the all fields are filled out!
                if(categoryTitle.equals("") || weight.equals("") || categoryID.equals("") || assignedDate.equals("")){
                    AlertDialog.Builder b = new AlertDialog.Builder(AddCategoryActivity.this);
                    b.setMessage("Incomplete Fields");
                    b.setPositiveButton("DISMISS", null);

                    b.show();
                    return;
                }

                Integer weightVal = Integer.parseInt(weight);
                Integer categoryIDVal = Integer.parseInt(categoryID);

                //Info comes from GradeLog
                GradeLog grade = new GradeLog(categoryTitle, weightVal , assignedDate, categoryIDVal);

                gradeDAO.insert(grade);

                Intent i = new Intent(AddCategoryActivity.this, ViewCategoriesActivity.class);
                Toast.makeText(getApplicationContext(), "Categories added successfully", Toast.LENGTH_SHORT).show();
                final String information = getIntent().getStringExtra("info");
                i.putExtra("info", information);
                startActivity(i);

                //notifies the user that their account has been created

            }
        });
    }


}