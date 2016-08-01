package com.example.raulstriglio.ottotest.API;

import android.content.Context;
import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by raul.striglio on 01/08/16.
 */
@Singleton
@Component(modules = { MyApiModule.class })
public interface MyApiComponent {
    void inject(Context context);
}
