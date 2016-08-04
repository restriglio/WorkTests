package com.example.raulstriglio.ottotest.Utilities;

import com.example.raulstriglio.ottotest.model.Person;
import com.example.raulstriglio.ottotest.model.User;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.SetMultimap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by raul.striglio on 02/08/16.
 */
public class GuavaUtils {

    private final int LOWER_AGE = 30;

    Predicate<Person> filterByName = new Predicate<Person>() {
        @Override
        public boolean apply(Person input) {
            return input.getName().contains("a");
        }
    };

    Function<User, Person> userToPerson
            = new Function<User, Person>() {

        public Person apply(User t) {
            Person person = new Person(t.getName(),t.getLastname(),t.getAge(),1);
            return person;
        }
    };

    public List<Person> fluentExample(List users) {
        ImmutableList immutableList = FluentIterable
                .from(users)
                .transform(userToPerson)
                .filter(filterByName).toList();

        return immutableList;
    }

    public Person returnFistMatch(List<Person> listPerson) {
        Person person =
                FluentIterable.from(listPerson).firstMatch(new Predicate<Person>() {
                    @Override
                    public boolean apply(Person input) {
                        return input.getAge() > LOWER_AGE;
                    }
                }).get();

        return person;
    }


    public List<Person> GetSortedPersonList(List users) {
        FluentIterable<Person> iterable = FluentIterable.from(users)
                .transform(userToPerson);

        List<Person> personList = new ArrayList<>(iterable.toList());
        Person p = new Person("",null,1,1);
        personList.add(p);
        Collections.sort(personList);

        return personList;
    }

    public SetMultimap<String, List<User>> getUserMapByName(List<Person> listPerson, List<User> listUser) {
        SetMultimap <String, List<User>> result = HashMultimap.create();

        for (final Person p : listPerson) {
            List<User> filteredUser = FluentIterable.from(listUser).filter(new Predicate<User>() {
                @Override
                public boolean apply(User input) {
                    return (input.getName() == p.getName());
                }
            }).toList();
            result.put(p.getName(), filteredUser);
        }

        return result;
    }

}
