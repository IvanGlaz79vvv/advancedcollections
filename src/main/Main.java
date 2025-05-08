package main;

import main.commands.Commands;
import main.commands.PeopleManager;
import main.persons.Person;

public class Main {
    public static void main(String[] args) {
/**
 Пользователь может ввести одну из команд: in, del, count, avg, median, young, old, print, help, exit.
 */
        Commands commands = new Commands();
        PeopleManager manager = new PeopleManager();

        Person ivan = new Person(1234567890L, "Ivan", 45);
        Person ivan2 = new Person(1234567891L, "Ivan", 45);
        Person alex = new Person(1234567892L, "Alex", 20);
        Person anastasia = new Person(1234567893L, "Anastasia", 30);
        Person petr = new Person(1234567894L, "Petr", 15);
        Person olga = new Person(1234567895L, "Olga", 12);
        Person igor = new Person(1234567896L, "Igor", 70);

        manager.getArrPersons().add(ivan);
        manager.getArrPersons().add(ivan2);
        manager.getArrPersons().add(alex);
        manager.getArrPersons().add(anastasia);
        manager.getArrPersons().add(petr);
        manager.getArrPersons().add(olga);
        manager.getArrPersons().add(igor);


        commands.print(manager);
        commands.start(manager);
    }
}
