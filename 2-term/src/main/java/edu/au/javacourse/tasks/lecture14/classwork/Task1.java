package edu.au.javacourse.tasks.lecture14.classwork;

import java.util.stream.IntStream;

public class Task1 {
    public static int intFactorial(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Number can be non-negative only!");
        }

        return IntStream.range(1, number + 1).reduce(1, (x, y) -> x * y);
    }
}
