package com.example.raulstriglio.ottotest.API;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.raulstriglio.ottotest.Events.CustomUserEvent;
import com.example.raulstriglio.ottotest.JsonParser;
import com.example.raulstriglio.ottotest.MyBus;
import com.example.raulstriglio.ottotest.model.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.squareup.otto.Produce;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by raul.striglio on 28/07/16.
 */
public class MyApi {

    JsonParser jParser;
    User user;
    Context context;

    public MyApi(Context context){
        jParser = new JsonParser();
        this.context = context;
    }

    @Produce
    public CustomUserEvent sendEvent(){
        MyBus.getBus().register(this);
        return new CustomUserEvent(user);
    }

    public void sedRequest(String url){

        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        user = jParser.parseData(response);
                        if(user != null) {
                            sendEvent();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"Error: " + error,Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(stringRequest);
    }




}
