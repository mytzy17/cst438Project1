package com.example.cst438project1.DB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 *
 * class for creating the AssignmentGrade object
 * @PrimaryKey: mAssignmentGradeId
 * Gives us grade, assignmentId, studentId, courseId, dateEarned, gradeId
 */

@Entity(tableName = AssignmentGradeDatabase.ASSIGNMENTGRADELOG_TABLE)
public class AssignmentGradeLog {
    @PrimaryKey(autoGenerate = true)
    private int mAssignmentGradeId;

    @ColumnInfo(name = "grade")
    private float grade;

    @ColumnInfo(name = "assignmentId")
    private int assignmentId;

    @ColumnInfo(name = "studentId")
    private int studentId;

    @ColumnInfo(name = "courseId")
    private int courseId;

    @ColumnInfo(name = "dateEarned")
    private String dateEarned;

    @ColumnInfo(name = "gradeId")
    private int gradeId;

    public AssignmentGradeLog(float grade, int assignmentId, int studentId, int courseId, String dateEarned, int gradeId) {
        this.grade = grade;
        this.assignmentId = assignmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.dateEarned = dateEarned;
        this.gradeId = gradeId;
    }

    public int getAssignmentGradeId() {
        return mAssignmentGradeId;
    }

    public void setAssignmentGradeId(int mAssignmentGradeId) {
        this.mAssignmentGradeId = mAssignmentGradeId;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getDateEarned() {
        return dateEarned;
    }

    public void setDateEarned(String dateEarned) {
        this.dateEarned = dateEarned;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }
}
