package com.example.ankitkumar.todolist_app.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class MyDatabaseManager {
    private MyDatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase sqLiteDatabase;

    public MyDatabaseManager(Context c) {
        context = c;
    }

    public MyDatabaseManager open() throws SQLException {
        dbHelper = new MyDatabaseHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String title, String description, String date, Integer status) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDatabaseHelper.COLUMN_TITLE, title);
        contentValues.put(MyDatabaseHelper.COLUMN_DESCRIPTION, description);
        contentValues.put(MyDatabaseHelper.COLUMN_DATE, date);
        contentValues.put(MyDatabaseHelper.COLUMN_STATUS, status);
        sqLiteDatabase.insert(MyDatabaseHelper.TABLE_TODO, null, contentValues);
    }

    public Cursor fetch(Integer status) {
        String[] columns = new String[]{MyDatabaseHelper.COLUMN_ID, MyDatabaseHelper.COLUMN_TITLE, MyDatabaseHelper.COLUMN_DESCRIPTION, MyDatabaseHelper.COLUMN_DATE, MyDatabaseHelper.COLUMN_STATUS};
        Cursor cursor = sqLiteDatabase.query(MyDatabaseHelper.TABLE_TODO, columns, MyDatabaseHelper.COLUMN_STATUS + "=" + status, null, null, null, MyDatabaseHelper.COLUMN_DATE + " ASC");
        if (cursor != null) {
        }
        return cursor;
    }

    public Cursor fetch() {
        String[] columns = new String[]{MyDatabaseHelper.COLUMN_ID, MyDatabaseHelper.COLUMN_TITLE, MyDatabaseHelper.COLUMN_DESCRIPTION, MyDatabaseHelper.COLUMN_DATE, MyDatabaseHelper.COLUMN_STATUS};
        Cursor cursor = sqLiteDatabase.query(MyDatabaseHelper.TABLE_TODO, columns, null, null, null, null, MyDatabaseHelper.COLUMN_DATE + " ASC");
        if (cursor != null) {
        }
        return cursor;
    }

    public int update(Integer _id, String title, String description, String date, Integer status) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDatabaseHelper.COLUMN_TITLE, title);
        contentValues.put(MyDatabaseHelper.COLUMN_DESCRIPTION, description);
        contentValues.put(MyDatabaseHelper.COLUMN_DATE, date);
        contentValues.put(MyDatabaseHelper.COLUMN_STATUS, status);

        int i = sqLiteDatabase.update(MyDatabaseHelper.TABLE_TODO, contentValues, MyDatabaseHelper.COLUMN_ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        sqLiteDatabase.delete(MyDatabaseHelper.TABLE_TODO, MyDatabaseHelper.COLUMN_ID + " = " + _id, null);
    }

}
