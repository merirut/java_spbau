package edu.au.javacourse.tasks.lecture12.classwork;

import java.util.List;
import java.util.function.Consumer;

public class Test1 {
    @org.junit.jupiter.api.Test
    void test() {
        FilteringContainer<Person> myContainer = new FilteringContainer<>(
                (Person p) -> p.age() >= 18,
                (Person t) -> System.out.println(t.name() + " is too young: " + t.age()));

        myContainer.Add(new Person("Steve", 15));
        myContainer.Add(new Person("Ann", 21));
        myContainer.Add(new Person("James", 18));

        System.out.println(myContainer.getItems());
    }
}
