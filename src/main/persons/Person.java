package main;

public class Person {

    String name;
    int age;
    long passport;

    public Person(){}

    public Person(String name, int age, long passport) {
        this.name = name;
        this.age = age;
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "\nname: " + name +
                ", \nage: " + age +
                ", \npassport: " + passport;
    }
}
