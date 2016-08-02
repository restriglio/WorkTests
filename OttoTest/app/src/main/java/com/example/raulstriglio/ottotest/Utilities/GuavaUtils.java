package com.example.raulstriglio.ottotest.Utilities;

import android.util.Log;

import com.example.raulstriglio.ottotest.model.Person;
import com.example.raulstriglio.ottotest.model.User;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by raul.striglio on 02/08/16.
 */
public class GuavaUtils {

    static Predicate<Person> filterByName = new Predicate<Person>() {
        @Override
        public boolean apply(Person input) {
            return input.getName().contains("a");
        }
    };

    static Function<User, Person> userToPerson
            = new Function<User, Person>() {

        public Person apply(User t) {
            Person person = new Person();
            person.setName(t.getName());
            person.setLastname(t.getLast_name());
            person.setAge(t.getAge());

            return person;
        }
    };

    public static List<Person> fluentExample(List users){
        ImmutableList immutableList = FluentIterable
                .from(users)
                .transform(userToPerson)
                .filter(filterByName).toList();
        ArrayList arrayList = new ArrayList<>(immutableList);
        Log.d("GUAVA FluentIterable","justA: " + arrayList.size());

        return immutableList;
    }

    public static List<Person> TransUserToPerson(List users){
        Collection<Person> result = Collections2.transform(users, userToPerson);

        Collection<Person> justA = Collections2.filter(result,filterByName);

        Log.d("FILTERED COLLECTION","justA: " + justA.size());
        Log.d("GUAVA COLLECTION","result: " + result.size());

        if (result instanceof List)
            return (List)result;
        else
            return new ArrayList(result);

    }

}
