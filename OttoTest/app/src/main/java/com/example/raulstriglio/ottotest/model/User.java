package com.example.raulstriglio.ottotest.model;

import java.io.Serializable;

/**
 * Created by raul.striglio on 28/07/16.
 */
public class User implements Serializable {

    public final static int USER_TYPE_1 = 0;
    public final static int USER_TYPE_2 = 1;
    public final static int USER_TYPE_3 = 2;

    private int age;
    private String lastname;
    private String name;
    private int type;

    public User(String name, String last_name, int age, int type) {
        this.name = name;
        this.lastname = last_name;
        this.age = age;
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
