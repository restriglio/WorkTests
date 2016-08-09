package com.example.raulstriglio.ottotest.Utilities;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DividerItemDecorationModule.class})
public interface DividerItemDecorationComponent {
    DividerItemDecoration dividerItemDecoration();
}
