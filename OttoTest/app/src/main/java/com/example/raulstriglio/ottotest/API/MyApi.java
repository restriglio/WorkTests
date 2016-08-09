package com.example.raulstriglio.ottotest.API;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.raulstriglio.ottotest.Events.CustomUserEvent;
import com.example.raulstriglio.ottotest.OttoTestApplication;
import com.example.raulstriglio.ottotest.Utilities.JsonParser;
import com.example.raulstriglio.ottotest.Utilities.MyBus;
import com.example.raulstriglio.ottotest.Utilities.FileReader;
import com.example.raulstriglio.ottotest.model.User;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 28/07/16.
 */
public class MyApi {

    @Inject
    protected JsonParser jParser;
    private ArrayList<User> usersList;
    private static MyApi mMyApi;
    private final Context context;

    public MyApi(Context context) {
        //((OttoTestApplication) context.getApplicationContext()).getMyApiComponent().injectParser(this);
        this.context = context;
        MyApiComponent component = ((OttoTestApplication) context.getApplicationContext()).getMyApiComponent();
        jParser = component.jsonParser();
    }

    public void sendEvent() {
        MyBus.getBus().post(new CustomUserEvent(usersList));
    }

    public void readFromFile() {
        usersList = jParser.parseData(FileReader.loadJSONFromAsset(context));
        sendEvent();
    }

    public void sedRequest(String url) {

        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        usersList = jParser.parseData(response);
                        if (usersList.size() > 0) {
                            sendEvent();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(stringRequest);
    }


}
