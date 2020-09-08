//User will be able to register and have an account ready to go
package com.example.cst438project1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cst438project1.DB.AccountLog;
import com.example.cst438project1.DB.AppDatabase;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Button createAccountButton = findViewById(R.id.createAccount);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create the variables

                EditText firstname = findViewById(R.id.firstname);
                EditText lastname = findViewById(R.id.lastname);
                EditText username = findViewById(R.id.username);
                EditText password = findViewById(R.id.password);

                String firstName = firstname.getText().toString();
                String lastName = lastname.getText().toString();
                String userName = username.getText().toString();
                String passWord = password.getText().toString();

                //Checks whether or not the all fields are filled out!
                if(userName.equals("") || passWord.equals("") || firstName.equals("") || lastName.equals("")){
                    //Alert the user that all fields need to be filled out in order to continue
                    AlertDialog.Builder b = new AlertDialog.Builder(CreateAccountActivity.this);
                    b.setMessage("Incomplete Fields");
                    b.setPositiveButton("DISMISS", null);

                    b.show();
                    return;
                }

                //Need the DB info

            }
        });
    }


}