package com.example.cst438project1.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GradeDAO {
    // Grade table for insert, update, and delete commands
    @Insert
    void insert(GradeLog... gradeLogs);

    @Update
    void update(GradeLog... gradeLogs);

    @Delete
    void delete(GradeLog... gradeLogs);

    // Query Commands
    // General query for entire gradeLog
    @Query("SELECT * FROM " + GradeDatabase.GRADE_LOG)
    List<GradeLog> getGradeLog();

    // Get grade based off grade ID
    @Query("SELECT * FROM " + GradeDatabase.GRADE_LOG + " WHERE mGradeId = :gradeID")
    GradeLog getGradeWithId(int gradeID);

    // get grade based off category ID
    @Query("SELECT * FROM " + GradeDatabase.GRADE_LOG + " WHERE categoryID = :categoryID")
    GradeLog getGradeWithCourseId(int categoryID);

    // get grade based off title
    @Query("SELECT * FROM " + GradeDatabase.GRADE_LOG + " WHERE title = :title LIMIT 1")
    GradeLog getGradeWithTitle(String title);
}
