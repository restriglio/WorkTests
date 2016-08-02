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

    private Context ottoTestContext;

    public MyApiModule(Context appContext){
        this.ottoTestContext = appContext;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return ottoTestContext;
    }

    @Provides
    @Singleton
    public MyApi provideMyApi(Context context) {
        return new MyApi(context);
    }

}
