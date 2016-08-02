package com.example.raulstriglio.ottotest.Events;

import com.example.raulstriglio.ottotest.model.User;
import com.squareup.otto.Produce;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raul.striglio on 28/07/16.
 */
public class CustomUserEvent {

    private ArrayList<User> users;

    public CustomUserEvent(ArrayList<User> user) {
        this.users = user;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

}
