package edu.au.javacourse.tasks.lecture17.classwork;

import org.junit.jupiter.api.Test;


public class Test1 {
    @Test
    public void test() throws InterruptedException {
        Fork F1 = new Fork("F1");
        Fork F2 = new Fork("F2");
        Fork F3 = new Fork("F3");
        Fork F4 = new Fork("F4");
        Fork F5 = new Fork("F5");

        Philosopher P1 = new Philosopher("P1", F1, F2, true);
        Philosopher P2 = new Philosopher("P2", F2, F3, false);
        Philosopher P3 = new Philosopher("P3", F3, F4, false);
        Philosopher P4 = new Philosopher("P4", F4, F5, false);
        Philosopher P5 = new Philosopher("P5", F5, F1, false);

        P1.start();
        P2.start();
        P3.start();
        P4.start();
        P5.start();

        P1.join();
        P2.join();
        P3.join();
        P4.join();
        P5.join();
    }
}
