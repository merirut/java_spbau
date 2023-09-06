package edu.au.javacourse.tasks.lecture14.classwork;

public class Test1 {
    @org.junit.jupiter.api.Test
    void test() {
        System.out.println(Task1.intFactorial(4));
        System.out.println(Task1.intFactorial(0));
        System.out.println(Task1.intFactorial(-4));
    }
}
