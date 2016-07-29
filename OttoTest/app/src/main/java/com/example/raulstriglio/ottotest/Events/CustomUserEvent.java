package com.example.raulstriglio.ottotest.Events;

import com.example.raulstriglio.ottotest.model.User;
import com.squareup.otto.Produce;

/**
 * Created by raul.striglio on 28/07/16.
 */
public class CustomUserEvent {

    private User user;

    public CustomUserEvent(User user){
        this.user = user;
    }

    public User getUser(){
        return user;
    }

}
