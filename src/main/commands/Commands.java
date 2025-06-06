package main.commands;

import main.persons.Person;

import java.util.*;

public class Commands {
    Scanner scanner = new Scanner(System.in);

    public void startProgramm(PeopleManager manager) {
        System.out.println("\nВведите команду: ");

        String command = scanner.nextLine().strip();
        try {
            switch (command) {
                case "in" -> {
                    in(manager);
                    startProgramm(manager);
                }
                case "del" -> {
                    del(manager);
                    startProgramm(manager);
                }
                case "count" -> {
                    count(manager);
                    startProgramm(manager);
                }
                case "avg" -> {
                    avg(manager);
                    startProgramm(manager);
                }
                case "median" -> {
                    median(manager);
                    startProgramm(manager);
                }
                case "young" -> {
                    young(manager);
                    startProgramm(manager);
                }
                case "old" -> {
                    old(manager);
                    startProgramm(manager);
                }
                case "print" -> {
                    print(manager);
                    startProgramm(manager);
                }
                case "help" -> {
                    help();
                    startProgramm(manager);
                }
                case "exit" -> exit();
                default -> {
                    System.out.println("Неизвестная команда. Попробуйте снова");
//                    scanner.close();
                    startProgramm(manager);
                }
            }
        } catch (Exception e) {
            System.out.println("Неизвестная команда. Попробуйте снова");
        }
    }

    public long chekNumberForLong() {
        long longNumber = 0L;
        boolean success = false;
        while (!success) {
            try {
                longNumber = Long.valueOf(scanner.nextLine().strip());
                success = true;
            } catch (Exception e) {
                System.out.println("chekNumberForLong: неверный формат данных. Введите заново.");
            }
        }
        return longNumber;
    }

    public int chekNumberForInteger() {
        int intNumber = 0;
        boolean success = false;
        while (!success) {
            try {
                intNumber = Integer.valueOf(scanner.nextLine().strip());
                success = true;
            } catch (Exception e) {
                System.out.println("неверный формат данных. Введите заново.");
            }
        }
        return intNumber;
    }

    public String addName() {
        return scanner.nextLine().strip();}

    public void in(PeopleManager manager) {
        System.out.println("Введите номер паспорта: ");
        long passport = chekNumberForLong();
        System.out.println("Введите имя пользователя: ");
        String name = addName();
        System.out.println("Введите возраст: ");
        int age = chekNumberForInteger();

        manager.getArrPersons().add(new Person(passport, name, age));

        System.out.println("Пользователь с паспортом " + passport + " добавлен");
    }

    public void del(PeopleManager manager) {
        if (manager.getArrPersons().size() == 0) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Введите номер паспорта для удаления");
            long passport = chekNumberForLong();
            Person removedPerson = null;
            for (Person e : manager.getArrPersons()) {
                if (e.getPassport() == passport) {
                    removedPerson = e;
                }
            }
            if (removedPerson != null) {
                manager.getArrPersons().remove(removedPerson);
                System.out.println("Пользователь с паспортом " + passport + " удалён");
            }else{
                System.out.println("Пользователь с таким паспортом не найден.");
            }
        }
    }

    public void count(PeopleManager manager) {
        System.out.println("количество пользователей: " + manager.getArrPersons().size());
    }

    public void avg(PeopleManager manager) {
        int lengthOfArrPersons = manager.getArrPersons().size();
        long sumOfAges = 0;
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
            System.out.println("Список пуст.");
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

