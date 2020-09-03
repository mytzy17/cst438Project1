package com.example.cst438project1.DB;


import android.accounts.Account;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database (entities = {CourseLog.class}, version=1)
//Can put a type converter here IF we need one

public abstract class CourseDatabase extends RoomDatabase {
    public static final String databaseCourses = "database-course-log";

    public static final String COURSELOG_TABLE = "courselog_table";

    public abstract CourseDAO getCourseDAO();
}
