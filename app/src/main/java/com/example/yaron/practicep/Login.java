package com.example.yaron.practicep;

/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */


import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.yaron.practicep.Entities.User;
import com.example.yaron.practicep.Shared.Ajax;
import com.example.yaron.practicep.Shared.Shared;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;


/**
 * This app displays an order form to order coffee.
 */
public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
    }


    public void registerButton(View v) {
        Toast.makeText(getApplicationContext(), "Registration not available on mobile", Toast.LENGTH_LONG).show();
    }

    public void login(View v) {
        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);

        String usernameString = (String) username.getText().toString();
        String passwordString = (String) password.getText().toString();

        TextView errorMsg = (TextView) findViewById(R.id.errorMsg);

        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("email", usernameString);
        hm.put("password", passwordString);

        String gson = Ajax.doPost(Shared.url, "login", hm);

        if (gson == null) { //if there was an error in the HTTP request
            Toast.makeText(getApplicationContext(), "Response is null, error in HTTP", Toast.LENGTH_LONG).show();
        } else if (gson.equals("0")) { //If response is '0' then there is no user with these credentials
            Toast.makeText(getApplicationContext(), "Invalid username and password, please try again.", Toast.LENGTH_LONG).show();
        } else if (gson.equals("500")) {
            Toast.makeText(getApplicationContext(), "Server error: " + gson, Toast.LENGTH_LONG).show();
        } else {//User was found and returned
            Gson g = new Gson();

            User u = g.fromJson(gson, User.class);

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

            Toast.makeText(getApplicationContext(), "Welcome " + u.getName(), Toast.LENGTH_LONG).show();
        }
    }

   /* private String makeHttpRequest(String urlS) throws IOException {
        final TextView mTextView = (TextView) findViewById(R.id.errorMsg);
        RequestQueue mRequestQueue;

// Instantiate the cache
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

// Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());

// Instantiate the RequestQueue with the cache and network.
        mRequestQueue = new RequestQueue(cache, network);

// Start the queue
        mRequestQueue.start();

        String url ="http://www.example.com";

// Formulate the request and handle the response.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Do something with the response
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                    }
                });

// Add the request to the RequestQueue.
        mRequestQueue.add(stringRequest);

    }*/

  /* public String  performGetCall(String requestURL) {
       HashMap<String, String> postDataParams = new HashMap<String, String>();
       postDataParams.put("email", "a.gmail.com");
       postDataParams.put("password", "a");

        URL url;
        String response = "";
        try {
            url = new URL(requestURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);

            int responseCode=conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                String line;
                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line=br.readLine()) != null) {
                    response+=line;
                }
            }
            else {
                response="";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    public String  performPostCall(String requestURL) {
        HashMap<String, String> postDataParams = new HashMap<String, String>();
        postDataParams.put("email", "a.gmail.com");
        postDataParams.put("password", "a");

        URL url;
        String response = "";
        try {
            url = new URL(requestURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");



            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(postDataParams));

            writer.flush();
            writer.close();
            os.close();
            int responseCode=conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                String line;
                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line=br.readLine()) != null) {
                    response+=line;
                }
            }
            else {
                response="";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }*/






    @Nullable
    public static String getResponseFromHttpUrl(String urlS) throws IOException{
        URL url = new URL(urlS);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }

    }

    /**
     * This method is called when the order button is clicked.
     */
   /* public void submitOrder(View view) {
        TextView v = (TextView) findViewById(R.id.quantity_text_view);
        int value = Integer.parseInt((String)v.getText());

        v.setText("" + (value + 1 ));


        //display(1);
    }*/

    /**
     * This method displays the given quantity value on the screen.
     */
   /* private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }*/
}