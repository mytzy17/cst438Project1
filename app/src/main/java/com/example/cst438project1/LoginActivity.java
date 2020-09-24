package com.example.cst438project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cst438project1.DB.AccountDAO;
import com.example.cst438project1.DB.AccountLog;
import com.example.cst438project1.DB.AppDatabase;

/**
 * LoginActivity enables users to login into their account
 * and be able to access MenuActivity.
 */

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText username;
    EditText password;
    private AccountDAO accountLogDAO;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, AppDatabase.databaseName)
                .allowMainThreadQueries()
                .build();

        accountLogDAO = db.getAccountDAO();

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = username.getText().toString();
                String passWord = password.getText().toString();

                /**
                 * Gets the info from the Account DB
                 */

                boolean getAccount = accountLogDAO.findCredentials(userName, passWord);
                AccountLog testUser = accountLogDAO.findAccount(userName, passWord);

                if(!getAccount){
                    //user cannot login in
                    Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();;
                }else{
                    System.out.println("IT WORKED!");
                    Intent i = new Intent(LoginActivity.this, MenuActivity.class);

                    AccountLog user = accountLogDAO.findAccount(userName, passWord);

                    String[] info = {user.getUsername(), user.getFirstname(), user.getLastname(), user.getPassword()};
                    i.putExtra("username", user.getAccountId());
                    i.putExtra("info", info);

                    startActivity(i);

                }
            }
        });


    }
}