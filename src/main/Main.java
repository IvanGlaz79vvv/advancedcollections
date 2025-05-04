package main;

import main.commands.Commands;

public class Main {
    public static void main(String[] args) {
        Person ivan = new Person("Ivan", 45, 4525854697L);
        System.out.println(ivan);

        Commands commands = new Commands();
        commands.help();
    }
}
