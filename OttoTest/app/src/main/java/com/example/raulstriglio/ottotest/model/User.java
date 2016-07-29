package com.example.raulstriglio.ottotest.model;

/**
 * Created by raul.striglio on 28/07/16.
 */
public class User {

    private String name;
    private String last_name;
    private int age;

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
