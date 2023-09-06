package edu.au.javacourse.tasks.lecture16.homework;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class Test1 {
    @Test
    public void test() throws InterruptedException {
        Counter counter1 = new Counter();
        IntStream.range(0, 1000000).forEach(x -> counter1.increment());
        System.out.println(counter1.count);


        Counter counter2 = new Counter();
        IntStream.range(0, 1000000).parallel().forEach(x -> counter2.increment());

        System.out.println(counter2.count);
    }

}
