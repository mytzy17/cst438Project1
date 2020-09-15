package com.example.cst438project1.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AssignmentGradeDAO {

    @Insert
    void insert(AssignmentGradeLog... assignmentGradeLogs);

    @Update
    void update(AssignmentGradeLog... assignmentGradeLogs);

    @Delete
    void delete(AssignmentGradeLog... assignmentGradeLogs);

    // General Query
    @Query("SELECT * FROM " + AssignmentGradeDatabase.ASSIGNMENTGRADELOG_TABLE)
    List<AssignmentGradeLog> getAssignmentGradeLog();

    // Get AssignmentGrades by AssignmentId
    @Query("SELECT * FROM " + AssignmentGradeDatabase.ASSIGNMENTGRADELOG_TABLE + " WHERE assignmentId = :assignmentId")
    List<AssignmentGradeLog> getAssignmentGradeByAssignmentId(int assignmentId);

    // Get AssignmentGrades by studentId
    @Query("SELECT * FROM " + AssignmentGradeDatabase.ASSIGNMENTGRADELOG_TABLE + " WHERE studentId = :studentId")
    List<AssignmentGradeLog> getAssignmentGradeByStudentId(int studentId);

    //Get AssignmentGrades by CourseId
    @Query("SELECT * FROM " + AssignmentGradeDatabase.ASSIGNMENTGRADELOG_TABLE + " WHERE courseId = :courseId")
    List<AssignmentGradeLog> getAssignmentGradeByCourseId(int courseId);

    //Get AssignmentGrade by gradeId
    @Query("SELECT * FROM " + AssignmentGradeDatabase.ASSIGNMENTGRADELOG_TABLE + " WHERE gradeId = :gradeId")
    List<AssignmentGradeLog> getAssignmentGradeByGradeId(int gradeId);
}
