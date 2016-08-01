package com.example.raulstriglio.ottotest.API;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raul.striglio on 01/08/16.
 */

@Module
public class MyApiModule {

    @Provides
    @Singleton
    public MyApi provideMyApi(Context context){
        return MyApi.getInstanceMyApi(context);
    }

}
