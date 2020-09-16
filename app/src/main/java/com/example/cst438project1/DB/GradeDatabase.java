package com.example.cst438project1.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {GradeLog.class}, version = 1)

public abstract class GradeDatabase extends RoomDatabase {
    public static final String databaseName = "database-grade-log";

    public static final String GRADE_LOG = "gradelog_table";

    public abstract GradeDAO getGradeDAO();
    
}