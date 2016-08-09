package com.example.raulstriglio.ottotest.Utilities;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raul.striglio on 08/08/16.
 */
@Module
public class DividerItemDecorationModule {

    Context context;

    public DividerItemDecorationModule(Context context){
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    DividerItemDecoration dividerItemDecoration(Context context) {
        return new DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST);
    }
}
