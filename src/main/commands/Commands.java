package main.commands;

import main.persons.Person;

import java.util.*;

public class Commands {

    public void inCommand(PeopleManager manager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите команду: ");
        String command = null;
        try {
            command = scanner.nextLine();


            switch (command) {
                case "in" -> {
                    in(manager);
                    inCommand(manager);
                }
                case "del" -> {
                    del();
                    inCommand(manager);
                }
                case "count" -> {
                    count(manager);
                    inCommand(manager);
                }
                case "avg" -> {
                    avg(manager);
                    inCommand(manager);
                }
                case "median" -> {
                    median();
                    inCommand(manager);
                }
                case "young" -> {
                    young(manager);
                    inCommand(manager);
                }
                case "old" -> {
                    old(manager);
                    inCommand(manager);
                }
                case "print" -> {
                    print(manager);
                    inCommand(manager);
                }
                case "help" -> {
                    help();
                    inCommand(manager);
                }
                case "exit" -> exit();
                default -> {
                    System.out.println("Неизвестная команда. Попробуйте снова");
                    scanner.close();
                    inCommand(manager);
                }
            }
        } catch (Exception e) {
            System.out.println("Неизвестная команда. Попробуйте снова");
        }
    }


    public void in(PeopleManager manager) {
        manager.addPersonTEST();
    }

    public void del() {
    }

    public void count(PeopleManager manager) {
        System.out.println("количество пользователей: " + manager.getArrPersons().size());
    }

    public void avg(PeopleManager manager) {//todo средний возраст всех пользователей "Средний возраст: "
        int lengthOfArrPersons = manager.getArrPersons().size();
        int sumOfAges = 0;
        for (Person p : manager.getArrPersons()) {
            sumOfAges += p.getAge();
        }
        float avgAgeArrPersons = sumOfAges / lengthOfArrPersons;
        System.out.println("\nСредний возраст: " + avgAgeArrPersons);
    }

    public void median() {//todo медиана возраста "Медиана возраста: "
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
        System.out.println("Список юзеров:");
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
        System.out.println("Программа завершена");
        System.exit(0);
    }
}

