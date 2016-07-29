package com.example.raulstriglio.ottotest;

import com.android.volley.toolbox.JsonArrayRequest;
import com.example.raulstriglio.ottotest.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by raul.striglio on 28/07/16.
 */
public class JsonParser {

    Gson gson;

    public JsonParser(){
        gson = new GsonBuilder().serializeNulls().disableHtmlEscaping()
                .serializeSpecialFloatingPointValues()
                .create();
    }

    public User parseData(String jsonString){
        ArrayList<User> usersArray = gson.fromJson(jsonString.toString(), ArrayList.class);
        return usersArray.get(0);
    }

}
