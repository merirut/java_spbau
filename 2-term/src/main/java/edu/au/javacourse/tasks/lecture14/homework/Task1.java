package edu.au.javacourse.tasks.lecture14.homework;

import java.util.stream.Stream;

public class Task1 {
    public static <T> int streamCount(Stream<T> inputStream){
        return inputStream.map(x -> 1).reduce(0, (x, y) -> x + y);
    }
}
