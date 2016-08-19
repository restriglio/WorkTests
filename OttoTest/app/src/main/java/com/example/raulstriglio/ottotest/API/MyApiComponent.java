package com.example.raulstriglio.ottotest.API;

import com.example.raulstriglio.ottotest.Fragments.OttoFragment;
import com.example.raulstriglio.ottotest.Utilities.JsonParseModule;
import com.example.raulstriglio.ottotest.Utilities.JsonParser;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by raul.striglio on 01/08/16.
 */
@Singleton
@Component(modules = {MyApiModule.class, JsonParseModule.class})
public interface MyApiComponent {
    void inject(OttoFragment ottoFragment);
    JsonParser jsonParser();
}

