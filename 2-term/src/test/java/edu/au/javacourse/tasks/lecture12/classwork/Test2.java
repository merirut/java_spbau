package edu.au.javacourse.tasks.lecture12.classwork;

import java.util.ArrayList;
import java.util.Comparator;

public class Test2 {
    @org.junit.jupiter.api.Test
    void test() {
        ArrayList<String> tooLongStrings = new ArrayList<>();
        FilteringContainer<String> myContainer = new FilteringContainer<>(
                (String s) -> s.length() < 6,
                (String s) -> tooLongStrings.add(s));

        myContainer.Add("123");
        myContainer.Add("345678");
        myContainer.Add("123456");
        myContainer.Add("1");
        myContainer.Add("123456789");

        myContainer.getItems().sort(Comparator.comparing(String::length).thenComparing(String::compareTo));
        System.out.println(myContainer.getItems());

        tooLongStrings.sort(Comparator.comparing(String::length).thenComparing(String::compareTo));
        System.out.println(tooLongStrings);
    }
}
