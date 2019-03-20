package com.philip.com.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "list.db";
    public static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_GROCERYLIST_TABLE = "CREATE TABLE " +
                Contract.ContractEntry.TABLE_NAME + " (" +
                Contract.ContractEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Contract.ContractEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                Contract.ContractEntry.COLUMN_AMOUNT + " INTEGER NOT NULL, " +
                Contract.ContractEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        db.execSQL(SQL_CREATE_GROCERYLIST_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Contract.ContractEntry.TABLE_NAME);
        onCreate(db);

    }
}