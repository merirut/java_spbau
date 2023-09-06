package edu.au.javacourse.tasks.lecture18.classwork;

import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class FibonacciRecursiveAction extends RecursiveAction {
    private static final long THRESHOLD = 5;

    private long index;
    private long number;

    public FibonacciRecursiveAction(long index) {
        this.index = index;
    }

    public long getFibonacciNumber() {
        return number;
    }


    @Override
    protected void compute() {
        final long n = index;
        if (n <= THRESHOLD) {
            System.out.println("Вычисляем рекурсивно число номер: " + n + "\n" +
                    "Поток: " + Thread.currentThread().getName() + "\n");
            number = fibonacci(n);
        }
        else {
            List<FibonacciRecursiveAction> subtasks = List.of(
                    new FibonacciRecursiveAction(n - 1),
                    new FibonacciRecursiveAction(n - 2)
            );
            number = ForkJoinTask.invokeAll(subtasks)
                    .stream()
                    .mapToLong(FibonacciRecursiveAction::getFibonacciNumber)
                    .sum();
        }
    }

    private long fibonacci(long n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
