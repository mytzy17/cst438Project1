package com.example.cst438project1.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AssignmentDAO {

    @Insert
    void insert(AssignmentLog... assignmentLogs);

    @Update
    void update(AssignmentLog... assignmentLogs);

    @Delete
    void delete(AssignmentLog... assignmentLogs);

    // Query Commands
    // General query for entire assignmentLog
    @Query("SELECT * FROM " + AssignmentDatabase.ASSIGNMENTLOG_TABLE)
    List<AssignmentLog> getAssignmentLog();

    // Query based on assignment ID
    @Query("SELECT * FROM " + AssignmentDatabase.ASSIGNMENTLOG_TABLE + " WHERE mAssignmentId = :mAssignmentId LIMIT 1")
    AssignmentLog getAssignmetnById(int mAssignmentId);

    // Query Category ID
    @Query("SELECT * FROM " + AssignmentDatabase.ASSIGNMENTLOG_TABLE + " WHERE categoryId = :categoryId")
    List<AssignmentLog> getAssignmentsByCategoryId(int categoryId);

    //Query Course ID
    @Query("SELECT * FROM " + AssignmentDatabase.ASSIGNMENTLOG_TABLE + " WHERE courseId = :courseId")
    List<AssignmentLog> getAssignmentsByCourseId(int courseId);

    //Query Assignment ID
    @Query("SELECT * FROM " + AssignmentDatabase.ASSIGNMENTLOG_TABLE + " WHERE assignmentId = :assignmentId")
    AssignmentLog getAssignmentsByAssignmentId(int assignmentId);
}
