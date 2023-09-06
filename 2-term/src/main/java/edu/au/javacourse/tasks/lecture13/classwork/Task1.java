package edu.au.javacourse.tasks.lecture13.classwork;



import java.util.stream.IntStream;
import java.util.concurrent.ThreadLocalRandom;

public class Task1 {
    public static void runStream() {
        IntStream.generate(() -> ThreadLocalRandom.current().nextInt(1, 10 + 1))
                .limit(10)
                .filter(x -> x % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }
}
