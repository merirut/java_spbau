package edu.au.javacourse.tasks.lecture14.classwork;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Task2 {
    public static Map<Integer, List<Integer>> groupRandom() {
        return Stream.generate(() -> ThreadLocalRandom.current().nextInt(1, 99 + 1))
                .limit(25)
                .collect(Collectors.groupingBy(x -> x / 10));
    }
}
