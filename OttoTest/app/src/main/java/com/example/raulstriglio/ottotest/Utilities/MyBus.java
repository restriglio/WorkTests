package com.example.raulstriglio.ottotest.Utilities;

import com.squareup.otto.Bus;

/**
 * Created by raul.striglio on 28/07/16.
 */
public class MyBus {

    private static final Bus Instance = new Bus();

    private MyBus() {
    }

    public static Bus getBus() {
        return Instance;
    }

}
