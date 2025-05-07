package main.commands;

import main.persons.Person;

import java.util.*;

public class PeopleManager {
    Scanner scanner = new Scanner(System.in);
    private TreeSet<Person> arrPersons = new TreeSet<>(
            Comparator.comparing(Person::getPassport)
    );

    public TreeSet<Person> getArrPersons() {
        return arrPersons;
    }

    public Long addPassportPeopleManager(Scanner scanner) {
        Long passport = 0L;
        boolean success = false;
        while (!success) {
            System.out.println("Введите номер паспорта: ");
            try {
                passport = Long.valueOf(scanner.nextLine().strip());
                success = true;
            } catch (Exception e) {
                System.out.println("неверный формат данных. Введите заново.");
            }

            for (Person e : arrPersons) {
                if (e.getPassport() == passport) {
                    System.out.println("Пользователь с таким паспортом уже существует. Добавить нового пользователя не удалось.");
                    success = false;
                }
            }
        }
        return passport;
    }

    public String addNamePeopleManager(Scanner scanner) {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine().strip();
        return name;
    }

    public int addAgePeopleManager(Scanner scanner) {
        Integer age = 0;
        boolean success = false;
        while (!success) {
            System.out.println("Введите возраст: ");
            try {
                age = Integer.valueOf(scanner.nextLine().strip());
                success = true;
            } catch (Exception e) {
                System.out.println("неверный формат данных. Введите заново.");
            }
        }
        return age;
    }

    public void addPerson() {
        long passport = addPassportPeopleManager(scanner);
        String name = addNamePeopleManager(scanner);
        int age = addAgePeopleManager(scanner);

        arrPersons.add(new Person(passport, name, age));
        scanner.close();
    }


}