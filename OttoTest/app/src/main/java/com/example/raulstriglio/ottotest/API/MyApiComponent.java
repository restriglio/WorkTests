package com.example.raulstriglio.ottotest.API;

import com.example.raulstriglio.ottotest.OttoFragment;
import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by raul.striglio on 01/08/16.
 */
@Singleton
@Component(modules = {MyApiModule.class})
public interface MyApiComponent {
    void inject(OttoFragment ottoFragment);
}
