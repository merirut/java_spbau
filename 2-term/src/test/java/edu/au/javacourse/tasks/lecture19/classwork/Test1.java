package edu.au.javacourse.tasks.lecture19.classwork;

import org.junit.jupiter.api.Test;

public class Test1 {
    @Test
    public void test() {
        System.loadLibrary("native");
        HelloWorldJNI.sayHello();
    }
}
