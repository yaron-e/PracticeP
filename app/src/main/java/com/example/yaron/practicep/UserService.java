package com.example.yaron.practicep;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.yaron.practicep.Data.StockDBHelper;
import com.example.yaron.practicep.Data.UserConstants;
import com.example.yaron.practicep.Entities.User;

/**
 * Created by YARON on 6/10/2017.
 */

public class UserService {

    private Context context;
    public UserService(Context c) {
        this.context = c;
        StockDBHelper stockHelper = new StockDBHelper(context);
        SQLiteDatabase db = stockHelper.getReadableDatabase();
    }

    public int save(User u) {

        try {
            StockDBHelper stockHelper = new StockDBHelper(context);

            // Create and/or open a database to read from it
            SQLiteDatabase db = stockHelper.getWritableDatabase();

            // Create a ContentValues object where column names are the keys,
            // and Toto's pet attributes are the values.
            ContentValues values = new ContentValues();
            values.put(UserConstants.USER_ID, u.getUserID());
            values.put(UserConstants.USER_NAME, u.getName());
            values.put(UserConstants.USER_EMAIL, u.getEmail());
            values.put(UserConstants.USER_PASSWORD, u.getPassword());

            // Insert a new row for Toto in the database, returning the ID of that new row.
            // The first argument for db.insert() is the pets table name.
            // The second argument provides the name of a column in which the framework
            // can insert NULL in the event that the ContentValues is empty (if
            // this is set to "null", then the framework will not insert a row when
            // there are no values).
            // The third argument is the ContentValues object containing the info for Toto.
            long newRowId = db.insertOrThrow(UserConstants.USER_TABLE, null, values);
            return (int) newRowId;
        } catch (Exception e) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.err.println(e.getMessage());
            Log.e("ERROR", e.toString());// e.printStackTrace();
            return -3;
        }
    }

    public int saveOrUpdate(User u) {

        try {
            StockDBHelper stockHelper = new StockDBHelper(context);

            // Create and/or open a database to read from it
            SQLiteDatabase db = stockHelper.getWritableDatabase();

            //Check if this user exists
            String query = "select * from " + UserConstants.USER_TABLE + " where "
                    + UserConstants.USER_ID + " " +u.getUserID() + " ;";

            Cursor c = db.rawQuery(query, null);

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("Count = " + c.getCount());
            System.out.println("Name = " + c.getColumnName(1));

            /*
            // Create a ContentValues object where column names are the keys,
            // and Toto's pet attributes are the values.
            ContentValues values = new ContentValues();
            values.put(UserConstants.USER_ID, u.getUserID());
            values.put(UserConstants.USER_NAME, u.getName());
            values.put(UserConstants.USER_EMAIL, u.getEmail());
            values.put(UserConstants.USER_PASSWORD, u.getPassword());

            // Insert a new row for Toto in the database, returning the ID of that new row.
            // The first argument for db.insert() is the pets table name.
            // The second argument provides the name of a column in which the framework
            // can insert NULL in the event that the ContentValues is empty (if
            // this is set to "null", then the framework will not insert a row when
            // there are no values).
            // The third argument is the ContentValues object containing the info for Toto.
            long newRowId = db.insertOrThrow(UserConstants.USER_TABLE, null, values);
            return (int) newRowId;
            */
            return -1;
        } catch (Exception e) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.err.println(e.getMessage());
            Log.e("ERROR", e.toString());// e.printStackTrace();
            return -3;
        }
    }

    /**
     * Get all content
     * @return
     */
    public Cursor query() {
        StockDBHelper stockHelper = new StockDBHelper(context);
        SQLiteDatabase db = stockHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from "+UserConstants.USER_TABLE,null);
        return cursor;
    }
}
