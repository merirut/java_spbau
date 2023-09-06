package edu.au.javacourse.tasks.lecture13.homework;

public class Test1 {
    @org.junit.jupiter.api.Test
    void test() {
        Student testStudent = new Student("Freddie","Mercury");
        String answer = Task1.findStudent(testStudent) ?
                "На 2-м курсе студент " + testStudent.firstName() + " " + testStudent.lastName() + " учится" :
                "На 2-м курсе студент " + testStudent.firstName() + " " + testStudent.lastName() + " не учится";
        System.out.println(answer);
    }
}
