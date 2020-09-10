package com.example.cst438project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cst438project1.DB.AccountDAO;
import com.example.cst438project1.DB.AccountLog;
import com.example.cst438project1.DB.AppDatabase;

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = username.getText().toString();
                String passWord = password.getText().toString();

                //Gets the info from the DB
                AccountDAO userDAO = AppDatabase.getAppDatabase(LoginActivity.this).getAccountDAO();
                //Believe it is findAccount and not findCredentials (not sure)
                AccountLog user = userDAO.findAccount(userName, passWord);

                if(user == null){
                    //user cannot login in
                    Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Intent i = new Intent(LoginActivity.this, MenuActivity.class);
                    i.putExtra("username", user.getAccountId());
                    startActivity(i);

                }
            }
        });


    }
}