package edu.au.javacourse.tasks.lecture11.classwork;

import java.lang.reflect.InvocationTargetException;

public class Test {
    @org.junit.jupiter.api.Test
    void test() throws InvocationTargetException, IllegalAccessException {
        Controller controller = new Controller();
        CommandProcessor processor = new CommandProcessor(controller);
        processor.execute("add");
        processor.execute("add");
        processor.execute("add");
        processor.execute("list");
    }
}
