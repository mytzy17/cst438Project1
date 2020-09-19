package com.example.cst438project1.DB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * class for creating the Grade object
 * @Primary Key: mGradeId
 * Gives the title, weight, assignedDate, categoryID
 */

@Entity(tableName = GradeDatabase.GRADE_LOG)
public class GradeLog {

    @PrimaryKey(autoGenerate = true)
    private int mGradeId;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "weight")
    private int weight;

    @ColumnInfo(name = "assignedDate")
    private String assignedDate;

    @ColumnInfo(name = "categoryID")
    private int categoryID;

    public GradeLog(String title, int weight, String assignedDate, int categoryID) {
        this.title = title;
        this.weight = weight;
        this.assignedDate = assignedDate;
        this.categoryID = categoryID;
    }

    public int getGradeId() { return mGradeId; }

    public void setGradeId(int mGradeId) {
        this.mGradeId = mGradeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(String assignedDate) {
        this.assignedDate = assignedDate;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
