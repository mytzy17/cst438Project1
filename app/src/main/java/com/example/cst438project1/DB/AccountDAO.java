package com.example.cst438project1.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AccountDAO {

    // Account table for insert, update, and delete commands. All Test cases created.
    @Insert
    void insert(AccountLog... accountLogs);

    @Update
    void update(AccountLog... accountLogs);

    @Delete
    void delete(AccountLog... accountLogs);


    // Query Commands
    // General query for entire accountLog
    @Query("SELECT * FROM " + AppDatabase.ACCOUNTLOG_TABLE)
    List<AccountLog> getAccountLog();

    // Query based off ID
    @Query("SELECT * FROM " + AppDatabase.ACCOUNTLOG_TABLE + " WHERE mAccountID = :accountID")
    AccountLog getAccountWithId(int accountID);

    //Added just in case we needed it
    @Query("SELECT * FROM " + AppDatabase.ACCOUNTLOG_TABLE + " WHERE username = :user")
    AccountLog getUserByName(String user);

    // Query based off with similar username & password
    @Query("SELECT * FROM " + AppDatabase.ACCOUNTLOG_TABLE + " WHERE username LIKE :user AND " + " password LIKE :pass LIMIT 1")
    boolean findCredentials(String user, String pass);

    // Query to find all accounts username & password
    @Query("SELECT * FROM " + AppDatabase.ACCOUNTLOG_TABLE + " WHERE username = :user AND " + " password = :pass LIMIT 1")
    AccountLog findAccount(String user, String pass);

    @Insert
    void addUser(AccountLog user);
}
