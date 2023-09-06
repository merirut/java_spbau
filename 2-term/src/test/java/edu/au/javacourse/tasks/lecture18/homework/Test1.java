package edu.au.javacourse.tasks.lecture18.homework;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;

public class Test1 {
    @Test
    public void test() {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        short lengthItems1 = 3;
        long[] items1 = LongStream.generate(() -> ThreadLocalRandom.current()
                        .nextLong(1, 10 + 1))
                .limit(lengthItems1)
                .toArray();
        SumItems sumItems1 = new SumItems(items1);

        System.out.println(Arrays.toString(items1));

        forkJoinPool.invoke(sumItems1);

        System.out.println("Получившаяся сумма : " + sumItems1.getSum());
        System.out.println("Проверка встроенной функцией : " + Arrays.stream(items1).sum());


        int lengthItems2 = 50;
        long[] items2 = LongStream.generate(() -> ThreadLocalRandom.current()
                        .nextLong(1, 10 + 1))
                        .limit(lengthItems2)
                        .toArray();
        SumItems sumItems2 = new SumItems(items2);

        System.out.println(Arrays.toString(items2));

        forkJoinPool.invoke(sumItems2);

        System.out.println("Получившаяся сумма : " + sumItems2.getSum());
        System.out.println("Проверка встроенной функцией : " + Arrays.stream(items2).sum());

    }
}
