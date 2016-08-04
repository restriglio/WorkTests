package com.example.raulstriglio.ottotest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raul.striglio on 03/08/16.
 */
public final class UserProvider {

    public static List<User> GetData(){
        List<User> personList = new ArrayList<>();

        personList.add(new User("Pedro","Scocco",20,User.USER_TYPE_3));
        personList.add(new User("Juan","Perez",30,User.USER_TYPE_1));
        personList.add(new User("Federico","Chavez",35,User.USER_TYPE_3));
        personList.add(new User("Sol","Rua",29,User.USER_TYPE_1));
        personList.add(new User("Brenda","Carignano",17,User.USER_TYPE_2));
        personList.add(new User("Lucho","suarez",29,User.USER_TYPE_3));
        personList.add(new User("juli","suarez",21,User.USER_TYPE_2));

        return personList;
    }

}
