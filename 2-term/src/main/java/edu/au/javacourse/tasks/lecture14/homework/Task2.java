package edu.au.javacourse.tasks.lecture14.homework;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task2 {
    public static Map<Integer, String> groupPeers(Person[] people) {
        return Arrays.stream(people)
                .collect(
                        Collectors.groupingBy(Person::age,
                                Collectors.mapping(Person::name,
                                        Collectors.joining(", ")
                                )
                        )
                );
    }
}
