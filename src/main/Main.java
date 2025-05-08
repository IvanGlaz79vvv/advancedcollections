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

        commands.start(manager);
    }
}
