package edu.au.javacourse.tasks.lecture11.classwork;

import javax.print.attribute.standard.Media;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CommandProcessor {
    private final Controller controller;
    private final Map<String, Method> commandHandlers;

    public CommandProcessor(Controller controller) {
        this.controller = controller;
        this.commandHandlers = buildCommandhandlersmap();
    }

    private Map<String, Method> buildCommandhandlersmap() {
        Map<String, Method> handlersMap = new HashMap<>();
        Method[] methods = controller.getClass().getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Command.class)) { // is this method annotated by this annotation?
                Command commandAnnotation = method.getAnnotation(Command.class);
                String commandName = commandAnnotation.value();
                handlersMap.put(commandName, method); // method is now associated with this command
            }
        }
        return handlersMap;
    }

    public void execute(String command) throws InvocationTargetException, IllegalAccessException {
        Method handler = commandHandlers.get(command);
        if (handler == null) {
            System.out.println("Error");
        }
        else{
            handler.invoke(controller);
        }
    }
}
