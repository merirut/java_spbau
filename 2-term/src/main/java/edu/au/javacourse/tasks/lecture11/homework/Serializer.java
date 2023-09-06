package edu.au.javacourse.tasks.lecture11.homework;


import java.lang.reflect.Field;
import java.util.HashMap;


public class Serializer {
    public Serializer() {
    }

    public <T> void serialize(T object) throws IllegalAccessException {
        Class<?> className = object.getClass();
        Field[] fields = className.getDeclaredFields();
        HashMap<String, String> jsonString = new HashMap<>();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Serialize.class)) {
                field.setAccessible(true);
                jsonString.put(field.getName(), field.get(object).toString());
            }
        }

        System.out.println(jsonString);
    }
}
