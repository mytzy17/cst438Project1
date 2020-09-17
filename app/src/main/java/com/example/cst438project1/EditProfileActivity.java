package com.example.cst438project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cst438project1.DB.AccountDAO;
import com.example.cst438project1.DB.AccountLog;
import com.example.cst438project1.DB.AppDatabase;
import com.example.cst438project1.DB.CourseDAO;

public class EditProfileActivity extends AppCompatActivity {

    private AccountDAO accountLogDAO;
    private AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, AppDatabase.databaseName)
                .allowMainThreadQueries()
                .build();
        accountLogDAO = db.getAccountDAO();


        final String[] information = getIntent().getStringArrayExtra("info");
        final String userName = information[0];
        final String passWord = information[3];
        final String fName = information[1];
        final String lName = information[2];

        final AccountLog user = accountLogDAO.getUserByName(userName);
        EditText newPassTextView = findViewById(R.id.newPassword);

        final String newPass = newPassTextView.getText().toString();

        Button newPassButton = findViewById(R.id.passwordChangeButton);

        newPassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create our intent
                Intent i = new Intent(EditProfileActivity.this, MenuActivity.class);
                // Sets the user's new password then update's it's reference in the accountLogDAO
                user.setPassword(newPass);
                accountLogDAO.update(user);
                i.putExtra("info", information);
                startActivity(i);
            }
        });

    }
}