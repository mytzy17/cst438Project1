package com.example.cst438project1.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CourseDAO {
    @Insert
    void insert(CourseLog... courseLogs);

    @Update
    void update(CourseLog... courseLogs);

    @Delete
    void delete(CourseLog... courseLogs);

    // Query commands that we'll need
    // Get entire course log
    @Query("SELECT * FROM " + CourseDatabase.COURSELOG_TABLE)
    List<CourseLog> getCourseLog();


}
