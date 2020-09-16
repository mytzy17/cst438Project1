package com.example.cst438project1.DB;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.RoomDatabase;

@Database(entities = {EnrollLog.class}, version = 1)

public abstract class EnrollDatabase extends RoomDatabase{
    public static final String databaseName = "database-enroll-log";

    public static final String ENROLLMENTLOG_TABLE = "enrollmentlog_table";

    public abstract EnrollDAO getEnrollDAO();

}

