package main.commands;

import java.util.Scanner;

public class Commands {
    Scanner scanner = new Scanner(System.in);

    public void inCommand() {
        String command = scanner.nextLine();
        switch (command) {
            case "in":
                in();
            case "del":
                del();
            case "count":
                count();
            case "avg":
                avg();
            case "median":
                median();
            case "young":
                young();
            case "old":
                old();
            case "print":
                print();
            case "help":
                help();
            case "exit":
                exit();
            default:
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

    public void print() {
    }

    public void help() {
        System.out.println(
                """
                        \n**************************************           \s
                                      ИНСТРУКЦИЯ
                        Доступные команды:
                        in      — ввод нового пользователя
                        del     — удаление пользователя по номеру паспорта
                        count   — показать количество пользователей
                        avg     — вывести средний возраст пользователей
                        median  — вывести медианный возраст пользователей
                        young   — самый молодой пользователь
                        old     — самый старый пользователь
                        print   — список пользователей по возрастанию возраста
                        help    — эта справка
                        exit    — выход из программы
                        **************************************
                        """);
    }

    public void exit() {
        System.out.println("Программа завершена");
        System.exit(0);
    }
}
