package com.example.cst438project1.DB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 *
 * class for creating the Assignment object
 * @PrimaryKey: mAssignmentId
 * Gives us details, maxScore, earnedScore, dueDate, categoryId, courseId
 */

@Entity(tableName = AssignmentDatabase.ASSIGNMENTLOG_TABLE)
public class AssignmentLog {

    @PrimaryKey(autoGenerate = true)
    private int mAssignmentId;

    @ColumnInfo(name = "details")
    private String details;

    @ColumnInfo(name = "maxScore")
    private double maxScore;

    @ColumnInfo(name = "earnedScore")
    private double earnedScore;

    @ColumnInfo(name = "dueDate")
    private String dueDate;

    @ColumnInfo(name = "categoryId")
    private String categoryId;

    @ColumnInfo(name = "courseId")
    private String courseId;


    public AssignmentLog(String details, double maxScore, double earnedScore, String dueDate, String categoryId, String courseId) {
        this.details = details;
        this.maxScore = maxScore;
        this.earnedScore = earnedScore;
        this.dueDate = dueDate;
        this.categoryId = categoryId;
        this.courseId = courseId;
    }

    public int getAssignmentId() {
        return mAssignmentId;
    }

    public void setAssignmentId(int mAssignmentId) {
        this.mAssignmentId = mAssignmentId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(double maxScore) {
        this.maxScore = maxScore;
    }

    public double getEarnedScore() {
        return earnedScore;
    }

    public void setEarnedScore(double earnedScore) {
        this.earnedScore = earnedScore;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
