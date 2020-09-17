package com.example.cst438project1.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EnrollDAO {
    @Insert
    void insert( EnrollLog... enrollLogs);

    @Update
    void update( EnrollLog... enrollLogs);

    @Delete
    void delete(EnrollLog EnrollLogs);

    //General query for entire enrollLog
    @Query("SELECT * FROM " + EnrollDatabase.ENROLLMENTLOG_TABLE)
    List<EnrollLog> getEnrollLog();

    //Get enroll based off enroll ID
    @Query("SELECT * FROM " + EnrollDatabase.ENROLLMENTLOG_TABLE + " WHERE enrollId = :enrollId")
    EnrollLog getEnrollWithId(int enrollId);

//    @Query("SELECT * FROM " + EnrollDatabase.ENROLLMENTLOG_TABLE + " WHERE userId = :userId")
//    EnrollLog getEnrollByUserId(int userId);

    @Query("SELECT * FROM " + EnrollDatabase.ENROLLMENTLOG_TABLE + " WHERE userId = :userId")
    List<EnrollLog> getEnrollByUserId(int userId);

}
