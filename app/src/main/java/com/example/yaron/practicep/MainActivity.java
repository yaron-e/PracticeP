package com.example.yaron.practicep;

/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yaron.practicep.Data.StockDBHelper;
import com.example.yaron.practicep.Data.UserConstants;
import com.example.yaron.practicep.Shared.Ajax;
import com.example.yaron.practicep.Shared.Shared;

import java.util.HashMap;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HashMap<String, String> hm = new HashMap<String, String>();
        // hm.put("userID", );
        //TODO:Add userID to the hm parameters

        //String json = Ajax.doPost(Shared.url, "getUserStock", );
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //TODO: Need to remove the code that is below
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        StockDBHelper stockHelper = new StockDBHelper(this);

        // Create and/or open a database to read from it
        SQLiteDatabase db = stockHelper.getReadableDatabase();

        // Perform this raw SQL query "SELECT * FROM pets"
        // to get a Cursor that contains all rows from the pets table.
        Cursor cursor = db.rawQuery("SELECT * FROM " + UserConstants.USER_TABLE, null);

        try {
            // Display the number of rows in the Cursor (which reflects the number of rows in the
            // user table in the database).

           // TextView v = (TextView) findViewById(R.id.quantity_text_view);
           // v.setText(cursor.getCount());

            Toast.makeText(getApplicationContext(), "Result = " + cursor.getCount(), Toast.LENGTH_LONG).show();

        } finally {

        }


    }
}