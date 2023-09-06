package edu.au.javacourse.tasks.lecture18.classwork;

import org.junit.jupiter.api.Test;
import java.util.concurrent.ForkJoinPool;

public class FibonacciForkJoinTest {

    @Test
    void fibonacciTest() {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        FibonacciRecursiveAction fibonacciRecursiveAction = new FibonacciRecursiveAction(12);
        forkJoinPool.invoke(fibonacciRecursiveAction);
        System.out.println("Фибоначчи: " + fibonacciRecursiveAction.getFibonacciNumber());
    }
}
