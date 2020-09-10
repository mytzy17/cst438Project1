//User will be able to register and have an account ready to go
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

import com.example.cst438project1.DB.AccountDAO;
import com.example.cst438project1.DB.AccountLog;
import com.example.cst438project1.DB.AppDatabase;
import com.example.cst438project1.DB.CourseDAO;
import com.example.cst438project1.DB.CourseDatabase;

public class CreateAccountActivity extends AppCompatActivity {

    Button createAccountButton;
    EditText firstname;
    EditText lastname;
    EditText username;
    EditText password;
    private AccountDAO accountLogDAO;
    private CourseDAO courseDAO;

    private AppDatabase db;
    private CourseDatabase db2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, AppDatabase.databaseName)
                .allowMainThreadQueries()
                .build();


        db2 = Room.databaseBuilder(getApplicationContext(), CourseDatabase.class, CourseDatabase.databaseCourses)
                .allowMainThreadQueries()
                .build();

        accountLogDAO = db.getAccountDAO();
        courseDAO = db2.getCourseDAO();


        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        createAccountButton = findViewById(R.id.createAccountButton);

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create the variables

                String firstName = firstname.getText().toString();
                String lastName = lastname.getText().toString();
                String userName = username.getText().toString();
                String passWord = password.getText().toString();

                //Checks whether or not the all fields are filled out!
                if(userName.equals("") || passWord.equals("") || firstName.equals("") || lastName.equals("")){
                    AlertDialog.Builder b = new AlertDialog.Builder(CreateAccountActivity.this);
                    b.setMessage("Incomplete Fields");
                    b.setPositiveButton("DISMISS", null);

                    b.show();
                    return;
                }

                //Info comes from AccountLog, user info
                //AccountLog user = AppDatabase.getAppDatabase(CreateAccountActivity.this).getAccountDAO().getUserByName(userName);
                AccountLog user = new AccountLog(userName,passWord , firstName, lastName);

                // Inserting test account into database
                //accountLogDAO.insert(user);

                boolean accountExistsAlready = accountLogDAO.findCredentials(userName, passWord);

                if(!accountExistsAlready){
                    //Adds a new user into the database
                    AccountLog newUser = new AccountLog(userName, passWord, firstName, lastName);
                    accountLogDAO.insert(newUser);

                    //Log Record needed I think, code below

                    //notifies the user that their account has been created
                    Toast.makeText(getApplicationContext(), "Account created successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(CreateAccountActivity.this, LoginActivity.class);
                    startActivity(i);
                }else{
                    //user already exists
                    AlertDialog.Builder builder = new AlertDialog.Builder(CreateAccountActivity.this);
                    builder.setMessage("Try again, username not available");
                    builder.setPositiveButton("OK", null);

                    builder.show();
                }

            }
        });
    }

}