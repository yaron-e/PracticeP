package com.example.yaron.practicep.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by YARON on 6/10/2017.
 */

public class StockDBHelper extends SQLiteOpenHelper {

    /**
     * https://classroom.udacity.com/courses/ud845/lessons/f5bb088f-6cc0-4e7d-9985-1418654bb141/concepts/e6620651-469b-4754-9ac9-dc34f6f0b781
     * https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html#execSQL(java.lang.String
     */

    //If a change is done to the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;


    public StockDBHelper(Context context) {
        super(context, DBConstants.DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserConstants.CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        //db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
