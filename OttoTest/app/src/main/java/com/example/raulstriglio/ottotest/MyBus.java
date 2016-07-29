package com.example.raulstriglio.ottotest;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by raul.striglio on 28/07/16.
 */
public class MyBus {

    final static Bus bus = new Bus(ThreadEnforcer.MAIN);
    public static Bus getBus(){
        return bus;
    }

}
