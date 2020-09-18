//HomePage Activity: User will be able either register, login, view logs, or exit App
package com.example.cst438project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.cst438project1.DB.AccountDAO;
import com.example.cst438project1.DB.AppDatabase;

public class MainActivity extends AppCompatActivity {
    private AccountDAO accountLogDAO;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, AppDatabase.databaseName)
                .allowMainThreadQueries()
                .build();

        accountLogDAO = db.getAccountDAO();


        //User will be taken to the CreateAccount Activity
        Button createAccountButton = findViewById(R.id.createAccount);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Will take us to the create account activity now
                Log.d("MainActivity", "CreateAccount Activity was called");

                //Create our intent
                Intent i = new Intent(MainActivity.this, CreateAccountActivity.class);
                startActivity(i);
            }
        });


        //User will be taken to the Login Activity
        Button loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Will take us to the Login Activity
                Log.d("LoginActivity", "Login Activity was called");
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

//        //User will be taken to the View
//        Button viewLog = findViewById(R.id.viewLogs);
//        viewLog.setOnClickListener((new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Will take us to the View Log Activity
//                Log.d("ViewLogActivity", "ViewLog Activity was called");
//                Intent i = new Intent(MainActivity.this, ViewProfileActivity.class);
//                startActivity(i);
//            }
//        }));

        Button exitButton = findViewById(R.id.exitApp);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ExitApp", "Exit App call was called");
                finish();
            }
        });

    }





}