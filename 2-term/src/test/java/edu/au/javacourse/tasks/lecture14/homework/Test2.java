package edu.au.javacourse.tasks.lecture14.homework;

import java.util.stream.Stream;

public class Test2 {
    @org.junit.jupiter.api.Test
    void test() {
        Person[] beautifulPeople = new Person[]{new Person("Steve", 25), new Person("Jenna", 17), new Person("Jack", 24), new Person("Robert", 17), new Person("Melanie", 24)};
        System.out.println(Task2.groupPeers(beautifulPeople));

    }
}
