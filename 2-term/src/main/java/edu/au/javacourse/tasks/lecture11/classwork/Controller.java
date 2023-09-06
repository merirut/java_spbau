package edu.au.javacourse.tasks.lecture11.classwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {
    private final List<Integer> numbers;

    public Controller() {
        numbers = new ArrayList<>();
    }

    @Command("list")
    public void listAllNumbers() {
        System.out.println("Numbers: " + numbers);
    }

    @Command("add")
    public void addNewNumber() {
        numbers.add(new Random().nextInt(100));
    }
}
