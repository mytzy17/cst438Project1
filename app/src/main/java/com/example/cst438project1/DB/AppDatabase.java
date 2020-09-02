package com.example.cst438project1.DB;


import android.accounts.Account;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database (entities = {AccountLog.class}, version=1)
//Can put a type converter here IF we need one
public abstract class AppDatabase extends RoomDatabase {
    public static final String databaseName = "database-account-log";

    public static final String ACCOUNTLOG_TABLE = "accountlog_table";

    public abstract AccountDAO getAccountDAO();
}
