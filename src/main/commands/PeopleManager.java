package main.commands;

import main.persons.Person;

import java.util.*;

public class PeopleManager {
    private TreeSet<Person> arrPersons = new TreeSet<>(
            Comparator.comparing(Person::getPassport)
    );

    public TreeSet<Person> getArrPersons() {
        return arrPersons;
    }
}