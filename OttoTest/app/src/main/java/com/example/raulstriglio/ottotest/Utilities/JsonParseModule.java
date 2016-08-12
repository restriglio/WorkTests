package com.example.raulstriglio.ottotest.Utilities;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raul.striglio on 08/08/16.
 */

@Module
public class JsonParseModule {
    @Provides
    @Singleton
    JsonParser provideJsonParser() {
        return new JsonParser();
    }
}
