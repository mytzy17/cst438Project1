package com.example.cst438project1.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {AssignmentLog.class}, version = 1)
public abstract class AssignmentDatabase extends RoomDatabase {
    public static final String databaseName = "database-assignment-log";

    public static final String ASSIGNMENTLOG_TABLE = "assignmentlog_table";

    public static AssignmentDatabase instance;
    public abstract AssignmentDAO getAssigmentDAO();
}
