package com.example.cst438project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        EditText userName = findViewById(R.id.role);
        EditText newPassword = findViewById(R.id.newPassword);
        EditText newEmail = findViewById(R.id.newEmail);
        Button passwordChangeButton = findViewById(R.id.passwordChangeButton);
        Button emailUpdateButton = findViewById(R.id.emailUpdateButton);

        // changes to the database to be added
    }
}