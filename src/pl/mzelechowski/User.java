package pl.mzelechowski;

import java.util.Date;

public class User {
    private String date;
    private String name;
    private String lastName;
    private int age;

    public User( String date, String name, String lastName, int age) {
        this.date = date;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
