package main;

import main.commands.Commands;
import main.commands.PeopleManager;
import main.persons.Person;

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


        Commands commands = new Commands();
        commands.start(manager);
//        commands.in(manager);//fixme
//        commands.print(manager);
//        commands.del(manager);//fixme
//        commands.count(manager);
//        commands.avg(manager);
//        commands.median(manager);
//        commands.young(manager);
//        commands.old(manager);
//        commands.print(manager);
//        commands.help();
//        commands.exit();
    }
}
