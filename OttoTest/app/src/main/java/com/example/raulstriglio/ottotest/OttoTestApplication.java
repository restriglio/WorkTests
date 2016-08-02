package com.example.raulstriglio.ottotest;

import android.app.Application;
import com.example.raulstriglio.ottotest.API.DaggerMyApiComponent;
import com.example.raulstriglio.ottotest.API.MyApiComponent;
import com.example.raulstriglio.ottotest.API.MyApiModule;

/**
 * Created by raul.striglio on 01/08/16.
 */
public class OttoTestApplication extends Application {

    MyApiComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerMyApiComponent.builder().myApiModule(new MyApiModule(this)).build();
    }

    public MyApiComponent getMyApiComponent() {
        return component;
    }

}
