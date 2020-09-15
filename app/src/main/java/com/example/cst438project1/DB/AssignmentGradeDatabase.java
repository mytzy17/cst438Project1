package com.example.cst438project1.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {AssignmentGradeLog.class}, version = 1)
public abstract class AssignmentGradeDatabase extends RoomDatabase {
    public static final String databaseName = "database-assignment-grade-log";

    public static final String ASSIGNMENTGRADELOG_TABLE = "assignmentgradelog_table";

    public static AssignmentGradeDatabase instance;
    public abstract AssignmentGradeDAO getAssignmentGradeDAO();
}
