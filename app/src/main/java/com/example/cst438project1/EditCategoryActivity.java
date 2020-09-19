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

public class EditCategoryActivity extends AppCompatActivity {
    private GradeDAO gradeDAO;

    private GradeDatabase db;

    Button editButton;
    EditText categoryTitleTextView;
    EditText weightTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_category);
        db = Room.databaseBuilder(getApplicationContext(), GradeDatabase.class, GradeDatabase.databaseName)
                .allowMainThreadQueries()
                .build();
        gradeDAO = db.getGradeDAO();

        categoryTitleTextView = findViewById(R.id.categoryTitleTextView);
        weightTextView = findViewById(R.id.weightTextView);
        editButton = findViewById(R.id.editButton);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String categoryTitle = categoryTitleTextView.getText().toString();
                String weight = weightTextView.getText().toString();

                //Checks whether or not the all fields are filled out!
                if(categoryTitle.equals("") || weight.equals("") ){
                    AlertDialog.Builder b = new AlertDialog.Builder(EditCategoryActivity.this);
                    b.setMessage("Incomplete Fields");
                    b.setPositiveButton("DISMISS", null);

                    b.show();
                    return;
                }

                GradeLog grade = gradeDAO.getGradeWithTitle(categoryTitle);

                Integer weightVal = Integer.parseInt(weight);
                //Info comes from GradeLog

                grade.setWeight(weightVal);
                gradeDAO.update(grade);

                Intent i = new Intent(EditCategoryActivity.this, ViewCategoriesActivity.class);
                final String information = getIntent().getStringExtra("info");
                i.putExtra("info", information);
                startActivity(i);
            }
        });
    }
}