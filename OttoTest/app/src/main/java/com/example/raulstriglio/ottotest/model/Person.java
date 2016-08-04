package com.example.raulstriglio.ottotest.model;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;


/**
 * Created by raul.striglio on 02/08/16.
 */
public class Person implements Comparable<Person> {

    public final static int PERSON_TYPE = 1;

    private int dni;
    private int age;
    private String email;
    private String lastname;
    private String name;


    public Person(String name, String lastName, int Age, int dni) {
        this.name = name;
        this.lastname = lastName;
        this.age = Age;
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(Person person) {
        return ComparisonChain.start()
                .compare(this.getLastname(), person.getLastname(), Ordering.<String>natural().nullsLast())
                .result();
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
