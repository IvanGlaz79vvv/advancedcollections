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
                    in();
                    inCommand(manager);
                }
                case "del" -> {
                    del();
                    inCommand(manager);
                }
                case "count" -> {
                    count();
                    inCommand(manager);
                }
                case "avg" -> {
                    avg();
                    inCommand(manager);
                }
                case "median" -> {
                    median();
                    inCommand(manager);
                }
                case "young" -> {
                    young();
                    inCommand(manager);
                }
                case "old" -> {
                    old();
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


    public void in() {
    }

    public void del() {
    }

    public void count() {
    }

    public void avg() {
    }

    public void median() {
    }

    public void young() {
    }

    public void old() {
    }


    public void print(PeopleManager manager) {
        System.out.println("Список юзеров:");
        ArrayList<Person> tmpArr = manager.getArrPersons();

        if (tmpArr != null && !tmpArr.isEmpty()) {
            for (Person p : tmpArr) {
                System.out.println(p);
//                System.out.println(p.getName()); // Вывод объекта Person
//                System.out.println(p.getAge()); // Вывод объекта Person
//                System.out.println(p.getPassport()); // Вывод объекта Person
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

