package com.example.cst438project1.DB;

import androidx.room.ColumnInfo;
import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * class for creating the Enroll object
 * @takes in the userId foreign key from Account table
 * @takes in the courseId foreign key from Course table
 * used to see which students are enrolled in each course and the date of their enrollment
 */

@Entity(tableName = EnrollDatabase.ENROLLMENTLOG_TABLE)

public class EnrollLog {
    //idk if we need a primary key
    @PrimaryKey(autoGenerate = true)
    private int enrollId;

    @ColumnInfo(name = "userId")
    private int userId;

    @ColumnInfo(name = "courseId")
    private int courseId;

    public EnrollLog(){ }

    public EnrollLog(int userId, int courseId){
        this.userId = userId;
        this.courseId = courseId;
    }

    public int getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(int enrollId) {
        this.enrollId = enrollId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
