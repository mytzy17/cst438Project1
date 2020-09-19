package com.example.cst438project1.DB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * class for creating the Course object
 * @Primary Key: CourseID
 * Gives the Instructor, CourseTitle, course description, start and end dates
 */

@Entity(tableName = CourseDatabase.COURSELOG_TABLE)
public class CourseLog {
    @PrimaryKey(autoGenerate = true)
    private int courseID;

    @ColumnInfo(name = "instructor") //
    private String instructor;

    @ColumnInfo(name = "title") //
    private String title;

    @ColumnInfo(name = "desc")
    private String desc;

    // Both dates might need to be changed to use a TypeConverter in the future
    @ColumnInfo(name = "startDate") //
    private String startDate;

    @ColumnInfo(name = "endDate") //
    private String endDate;

    public CourseLog(String instructor, String title, String desc, String startDate, String endDate) {
        this.instructor = instructor;
        this.title = title;
        this.desc = desc;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // All getters and setters

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
