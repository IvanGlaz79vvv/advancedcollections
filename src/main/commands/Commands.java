package main.commands;

import main.persons.Person;

import java.util.*;

public class Commands {

    public void start(PeopleManager manager) {
        System.out.println("\nВведите команду: ");

        String command = manager.scanner.nextLine().strip();
        try {
            switch (command) {
                case "in" -> {
                    in(manager);
                    start(manager);
                }
                case "del" -> {
                    del(manager);
                    start(manager);
                }
                case "count" -> {
                    count(manager);
                    start(manager);
                }
                case "avg" -> {
                    avg(manager);
                    start(manager);
                }
                case "median" -> {
                    median(manager);
                    start(manager);
                }
                case "young" -> {
                    young(manager);
                    start(manager);
                }
                case "old" -> {
                    old(manager);
                    start(manager);
                }
                case "print" -> {
                    print(manager);
                    start(manager);
                }
                case "help" -> {
                    help();
                    start(manager);
                }
                case "exit" -> exit();
                default -> {
                    System.out.println("Неизвестная команда. Попробуйте снова");
//                    scanner.close();
                    start(manager);
                }
            }
        } catch (Exception e) {
            System.out.println("Неизвестная команда. Попробуйте снова");
        }
    }

    public void in(PeopleManager manager) {
//        manager.addPerson();
        Long passport = 0L;
        boolean success = false;
        Person addPerson = null;
        while (!success) {
            System.out.println("Введите номер паспорта для добавления пользователя: ");

            try {
                passport = Long.valueOf(manager.scanner.nextLine().strip());
                success = true;
            } catch (Exception e) {
                System.out.println("неверный формат данных. Введите заново.");
            }

            for (Person e : manager.getArrPersons()) {
                if (e.getPassport() == passport) {
                    addPerson = e;
                }
            }

            if (addPerson != null) {
                manager.getArrPersons().add(addPerson);
                System.out.println("Пользователь с паспортом " + passport + " добавлен");
            } /*else {
//                System.out.println("Пользователь с таким паспортом не найден.");
                success = false;*/
        }
    }

    public void del(PeopleManager manager) {
        Long passport = 0L;
        boolean success = false;
        Person removedPerson = null;
        while (!success) {
            System.out.println("Введите номер паспорта для удаления: ");

            try {
                passport = Long.valueOf(manager.scanner.nextLine().strip());
                success = true;
            } catch (Exception e) {
                System.out.println("неверный формат данных. Введите заново.");
            }

            for (Person e : manager.getArrPersons()) {
                if (e.getPassport() == passport) {
                    removedPerson = e;
                }
            }

            if (removedPerson != null) {
                manager.getArrPersons().remove(removedPerson);
                System.out.println("Пользователь с паспортом " + passport + " удалён");
            } else {
                System.out.println("Пользователь с таким паспортом не найден.");
                success = false;
            }
        }
    }

    public void count(PeopleManager manager) {
        System.out.println("количество пользователей: " + manager.getArrPersons().size());
    }

    public void avg(PeopleManager manager) {
        int lengthOfArrPersons = manager.getArrPersons().size();
        int sumOfAges = 0;
        for (Person p : manager.getArrPersons()) {
            sumOfAges += p.getAge();
        }
        float avgAgeArrPersons = sumOfAges / lengthOfArrPersons;
        System.out.println("\nСредний возраст: " + avgAgeArrPersons);
    }

    public void median(PeopleManager manager) {
        ArrayList<Person> ageSortArrPersons = new ArrayList<>(manager.getArrPersons());
        ageSortArrPersons.sort(Comparator.comparing(Person::getAge));

        int lengthOfAgeSortArrPersons = ageSortArrPersons.size();
        float mediana = 0;
        if (lengthOfAgeSortArrPersons % 2 == 0) {
            int tmpMediana = lengthOfAgeSortArrPersons / 2;
            int previous = (int) tmpMediana - 1;
            int next = (int) tmpMediana;
            mediana = (float) (ageSortArrPersons.get(previous).getAge() + ageSortArrPersons.get(next).getAge()) / 2;
        } else {
            mediana = ageSortArrPersons.get(lengthOfAgeSortArrPersons / 2).getAge();
        }
        System.out.println("\nМедиана возраста: " + mediana);
    }

    public void young(PeopleManager manager) {
        ArrayList<Person> ageSortArrPersons = new ArrayList<>(manager.getArrPersons());
        ageSortArrPersons.sort(Comparator.comparing(Person::getAge));
        System.out.println("\nСамый молодой пользователь: " + ageSortArrPersons.getFirst());
    }

    public void old(PeopleManager manager) {
        ArrayList<Person> ageSortArrPersons = new ArrayList<>(manager.getArrPersons());
        ageSortArrPersons.sort(Comparator.comparing(Person::getAge));
        System.out.println("\nСамый старый пользователь: " + ageSortArrPersons.getLast());
    }

    public void print(PeopleManager manager) {
        System.out.println("\n\nСписок юзеров:");
        ArrayList<Person> ageSortArrPersons = new ArrayList<>(manager.getArrPersons());
        ageSortArrPersons.sort(Comparator.comparing(Person::getAge));

        if (manager.getArrPersons() != null && !manager.getArrPersons().isEmpty()) {
            for (Person element : ageSortArrPersons) {
                System.out.println(element);
            }
        } else {
            System.out.println("Список пуст или равен null.");
        }
    }

    public void help() {
        System.out.println("""
                \n**************************************\s
                              ИНСТРУКЦИЯ
                Доступные команды:
                1. in      — ввод нового пользователя
                2. del     — удаление пользователя по номеру паспорта
                3. count   — показать количество пользователей
                4. avg     — вывести средний возраст пользователей
                5. median  — вывести медианный возраст пользователей
                6. young   — самый молодой пользователь
                7. old     — самый старый пользователь
                8. print   — список пользователей по возрастанию возраста
                9. help    — эта справка
                10. exit    — выход из программы
                **************************************"""
        );
    }

    public void exit() {
        System.out.println("\nПрограмма завершена");
        System.exit(0);
    }
}

