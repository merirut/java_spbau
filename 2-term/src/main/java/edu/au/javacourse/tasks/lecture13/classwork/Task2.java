package edu.au.javacourse.tasks.lecture13.classwork;

import java.util.stream.Stream;


public class Task2 {
    public static void fibonacciEndlessStream() {
        Stream.iterate(new int[]{0, 1},
                        pair -> new int[]{pair[1], pair[0] + pair[1]})
                .limit(10)
                .map(pair -> pair[0])
                .forEach(System.out::println);
    }
}
