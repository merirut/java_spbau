package edu.au.javacourse.tasks.lecture18.homework;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;


public class SumItems extends RecursiveAction {
    private static final int THRESHOLD = 4;
    private long[] items;
    private long sum = 0;


    public SumItems(long[] items) {
        this.items = items;
    }


    public long getSum() {
        return sum;
    }


    @Override
    protected void compute() {
        int n = items.length;
        if (n <= THRESHOLD) {
            sum = calculateSum(items);
            System.out.println("Суммируем числа: " + Arrays.toString(items) + " = " + sum);
        }
        else {
            List<SumItems> subtasks = List.of(
                    new SumItems(Arrays.copyOfRange(items, 0, items.length / 2)),
                    new SumItems(Arrays.copyOfRange(items, items.length / 2, items.length))
            );
            sum = ForkJoinTask.invokeAll(subtasks)
                    .stream()
                    .mapToLong(SumItems::getSum)
                    .sum();
            System.out.println("Суммирем результаты подзадач: " + subtasks.get(0).getSum() + " + " + subtasks.get(1).getSum()
                    + " = " + sum);
        }
    }


    private long calculateSum(long[] items) {
        if (items.length <= THRESHOLD) {
            long currentSum = 0;
            for (long item : items) { currentSum += item; }
            return currentSum;
        }
        return calculateSum(Arrays.copyOfRange(items, 0, items.length / 2)) +
                calculateSum(Arrays.copyOfRange(items, items.length / 2, items.length));
    }
}
