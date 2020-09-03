package com.example.cst438project1;

import android.accounts.Account;
import android.content.Context;

import com.example.cst438project1.DB.AccountDAO;
import com.example.cst438project1.DB.AccountLog;
import com.example.cst438project1.DB.AppDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import androidx.room.Room;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(AndroidJUnit4.class)
public class AccountDatabaseTest {

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.cst438project1", appContext.getPackageName());
    }

    // Variable declarations for tests
    private AccountDAO accountLogDAO;
    private AppDatabase db;

    @Before
    public void createDatabase() {
        //Create a room database
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().getContext(), AppDatabase.class)
                .allowMainThreadQueries()
                .build();

        accountLogDAO = db.getAccountDAO();
    }

    @Before
    //Sets up database (aka running the method created above)
    public void setUp() throws Exception {
        createDatabase();
    }

    @After
    public void tearDown() throws Exception {
        // I was told to have one of these in the after for the database health.
    }

    @Test
    public void insertIntoDatabase() {
        AccountLog exampleAccount = new AccountLog("Username", "Password", "Firstname", "Lastname");

        // Inserting test account into database
        accountLogDAO.insert(exampleAccount);
        // Getting the recently inserted information from the database
        List<AccountLog> DatabaseCheck = accountLogDAO.getAccountLog();

        // Checking if the local variable List is the same as the recently inserted-into-the-DB List
        assertEquals(exampleAccount.getFirstname(), DatabaseCheck.get(0).getFirstname()); //THIS TEST IS SUCCESSFUL
    }

    @Test
    public void updateDatabase() {
        AccountLog exampleAccount = new AccountLog("Username", "Password", "Firstname", "Lastname");

        // Insert test account into database
        accountLogDAO.insert(exampleAccount);

        // User setter to update username, then update() to update the database
        exampleAccount.setFirstname("Firstname1");
        accountLogDAO.update(exampleAccount);

        //Pull from database
        List<AccountLog> DatabaseCheck = accountLogDAO.getAccountLog();
        assertNotEquals(exampleAccount.getFirstname(), DatabaseCheck.get(0).getFirstname()); //Test Case successful
    }

    @Test
    public void deleteFromDatabase() {
        AccountLog exampleAccount = new AccountLog("Username", "Password", "Firstname", "Lastname");

        // Insert test account into database
        accountLogDAO.insert(exampleAccount);

        // Pull from database and retrieve recently added account
        List<AccountLog> DatabaseCheck = accountLogDAO.getAccountLog();
        AccountLog deleteLog = DatabaseCheck.get(0);

        // Delete account and pull from database again
        accountLogDAO.delete(deleteLog);
        List<AccountLog> DatabaseRecheck = accountLogDAO.getAccountLog();

        // There shouldn't be any database entries, thus the Database size is 0
        assertEquals(0, DatabaseRecheck.size()); // Test case successful
    }

}