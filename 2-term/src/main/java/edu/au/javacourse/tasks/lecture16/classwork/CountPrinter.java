package edu.au.javacourse.tasks.lecture16.classwork;

import java.util.stream.IntStream;

public class CountPrinter extends Thread {
    String name;

    CountPrinter(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        IntStream.range(1, 10 + 1).forEach(x -> System.out.println(name + ": " + x));
    }
}
