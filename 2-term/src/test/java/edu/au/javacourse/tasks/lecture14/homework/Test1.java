import edu.au.javacourse.tasks.lecture14.homework.Task1;

import java.util.stream.Stream;

public class Test1 {
    @org.junit.jupiter.api.Test
    void test() {
        System.out.println(Task1.streamCount(Stream.of(1, 2, 3, 4, 5)));
        System.out.println(Task1.streamCount(Stream.of('h', 'e', 'l', 'l', 'o')));
        System.out.println(Task1.streamCount(Stream.of("Hello", "world")));
    }
}
