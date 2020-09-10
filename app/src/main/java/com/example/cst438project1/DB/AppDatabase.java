package com.example.cst438project1.DB;


import android.accounts.Account;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database (entities = {AccountLog.class}, version = 1)
//Can put a type converter here IF we need one

public abstract class AppDatabase extends RoomDatabase {
    public static final String databaseName = "database-account-log";
    //public static final String databaseName2 = "database-course-log";

    //this is the AccountLog DB
    public static final String ACCOUNTLOG_TABLE = "accountlog_table";

    //Probs we will also need, added them if we need them
    public static final String COURSE_TABLE ="course_table";

    public static final String GRADE_TABLE ="grade_table";

    public static final String ASSIGNMENT_TABLE="assignment_table";

    public static final String GRADE_CATEGORY_TABLE="grade_category_table";

    public static final String ENROLLMENT_TABLE="enrollment_table";

    //public static final String COURSELOG_TABLE = "courselog_table";


    //Functions
    public static AppDatabase instance;
    public abstract AccountDAO getAccountDAO();
    //public abstract CourseDAO getCourseDAO();
    //public abstract GradeDAO getGradeDAO();


    public static AppDatabase getAppDatabase(final Context c){
        if(instance == null){
            instance = Room.databaseBuilder(c.getApplicationContext(), AppDatabase.class, "Grade Database").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
