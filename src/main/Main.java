package main;

import main.commands.Commands;
import main.commands.PeopleManager;
import main.persons.Person;

import java.util.TreeMap;

/**
Вычислительная сложность команд:
 young и old должна быть O(log n) - TreeSet;
 in, del, count должна быть O(1) - HashMap/HashSet;
 avg, median, print может быть O(n) - ArrayList/LinkedList.
 Модель пользователя (имя, возраст, номер паспорта) должна представлять собой отдельный класс.
*/

public class Main {
    public static void main(String[] args) {
        PeopleManager manager = new PeopleManager();

        Person ivan = new Person(1234567890L, "Ivan", 45);
        Person ivan2 = new Person(1234567891L, "Ivan", 45);
        Person anastasia = new Person(1234567892L, "Anastasia", 30);
        Person petr = new Person(1234567893L, "Petr", 15);
        Person olga = new Person(1234567894L, "Olga", 12);

        manager.arrPersons.add(ivan);
        manager.arrPersons.add(ivan2);
        manager.arrPersons.add(anastasia);
        manager.arrPersons.add(petr);
        manager.arrPersons.add(olga);

        TreeMap


        Commands commands = new Commands();
        commands.print(manager);
        commands.in(manager);
        commands.print(manager);
    }
}
