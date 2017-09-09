package com.example.ankitkumar.todolist_app.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_TODO = "Todo";
    public static final String COLUMN_ID = "key_id";
    public static final String COLUMN_TITLE = "key_title";
    public static final String COLUMN_DESCRIPTION = "key_description";
    public static final String COLUMN_DATE = "key_date";
    public static final String COLUMN_STATUS = "key_status";
    public static final String DATABASE_NAME = "to_do.db";
    public static final int DATABASE_VERSION = 1;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "Create table " + TABLE_TODO + "(" + COLUMN_ID + " INTEGER PRIMARY kEY AUTOINCREMENT, " + COLUMN_TITLE + " TEXT, " + COLUMN_DESCRIPTION + " TEXT, " + COLUMN_DATE + " TEXT, " + COLUMN_STATUS + " INTEGER DEFAULT '0'" + ")";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);
        onCreate(sqLiteDatabase);
    }
}
