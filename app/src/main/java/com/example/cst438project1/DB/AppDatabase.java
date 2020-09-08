package com.example.cst438project1.DB;


import android.accounts.Account;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database (entities = {AccountLog.class}, version = 1)
//@Database (entities = {CourseLog.class}, version=1)
//Can put a type converter here IF we need one

public abstract class AppDatabase extends RoomDatabase {
    public static final String databaseName = "database-account-log";
    //public static final String databaseName2 = "database-course-log";

    //this is the AccountLog DB
    public static final String ACCOUNTLOG_TABLE = "accountlog_table";

    //Probs we will also need, added them if we need them
    public static final String COURSE_TABLE ="course table";

    public static final String GRADE_TABLE ="grade table"; 

    public static final String ASSIGNMENT_TABLE="assignment table";

    public static final String GRADE_CATEGORY_TABLE="grade category table";

    public static final String ENROLLMENT_TABLE="enrollment table";

    //public static final String COURSELOG_TABLE = "courselog_table";


    //Functions
    public abstract AccountDAO getAccountDAO();
    //public abstract CourseDAO getCourseDAO();
}
