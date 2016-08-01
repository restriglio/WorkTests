package com.example.raulstriglio.ottotest;

import android.app.Application;

import com.example.raulstriglio.ottotest.API.DaggerMyApiComponent;
import com.example.raulstriglio.ottotest.API.MyApiComponent;

/**
 * Created by raul.striglio on 01/08/16.
 */
public class OttoTestApplication extends Application {

    MyApiComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerMyApiComponent.builder().build();
    }

    public MyApiComponent getComponent() {
        return component;
    }

}
