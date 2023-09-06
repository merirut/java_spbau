package edu.au.javacourse.tasks.lecture16.classwork;

import org.junit.jupiter.api.Test;

public class Test1 {
    @Test
    public void test() throws InterruptedException {
        CountPrinter printer1 = new CountPrinter("first");
        CountPrinter printer2 = new CountPrinter("second");

        printer1.start();
        printer2.start();

        printer1.join();
        printer2.join();

        System.out.println("Done!");
    }
}
