package com.example.yaron.practicep.Shared;

/**
 * Created by YARON on 6/17/2017.
 */


import java.util.ArrayList;
import java.util.List;

import com.example.yaron.practicep.Entities.Stock;
import com.example.yaron.practicep.Entities.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonParser {

    public static List<Stock> convertStringToListStock(String s) {
        List<Object> o = convertStringToListObject(s);

        List<Stock> stock = (ArrayList<Stock>) o;//new ArrayList<Stock>();
/*
        for (Object temp : o) {
            Stock t = (Stock) temp;
            stock.add(t);
        }
*/
        return stock;
    }

    public static List<User> convertStringToListUser(String s) {
        List<Object> o = convertStringToListObject(s);

        List<User> user = new ArrayList<User>();

        for (Object temp : o)
            user.add((User) temp);

        return user;
    }

    public static List<Object> convertStringToListObject(String s) {
        // create a new Gson instance
        Gson gson = new Gson();

        // Converts JSON string into a List of Product object
        java.lang.reflect.Type type = new TypeToken<List<Object>>(){}.getType();
        List<Object> prodList = gson.fromJson(s, type);

        return prodList;
    }

    public static String convertListStockToString(List<Stock> l) {
        // create a new Gson instance
        Gson gson = new Gson();

        // convert your list to json
        return gson.toJson(l);
    }


    public static String convertListUserToString(List<User> l) {
        // create a new Gson instance
        Gson gson = new Gson();

        // convert your list to json
        return gson.toJson(l);
    }
}

