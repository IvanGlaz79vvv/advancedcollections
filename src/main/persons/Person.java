package main.persons;

public class Person implements Comparable {

    private long passport;
    private String name;
    private int age;

    public Person(Long passport, String name, int age) {
        this.passport = passport;
        this.name = name;
        this.age = age;
    }

    public void setPassport(long passport) {
        this.passport = passport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getPassport() {
        return passport;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "\npassport: " + passport+
                "\nname: " + name +
                "\nage: " + age;
    }
}
