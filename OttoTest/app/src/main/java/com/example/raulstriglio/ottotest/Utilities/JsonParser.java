package com.example.raulstriglio.ottotest.Utilities;


import com.example.raulstriglio.ottotest.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by raul.striglio on 28/07/16.
 */
public class JsonParser {

    Gson gson;

    public JsonParser() {
        gson = new GsonBuilder().serializeNulls().disableHtmlEscaping()
                .serializeSpecialFloatingPointValues()
                .create();
    }

    public User getElement(ArrayList<User> aList, int index) {
        return aList.get(index);
    }

    public ArrayList<User> parseData(String jsonString) {
        Type listType = new TypeToken<ArrayList<User>>() {
        }.getType();
        ArrayList<User> usersArray = gson.fromJson(jsonString.toString(), listType);
        return usersArray;
    }

}
