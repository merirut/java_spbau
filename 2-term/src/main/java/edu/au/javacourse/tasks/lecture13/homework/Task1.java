package edu.au.javacourse.tasks.lecture13.homework;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    static StudentGroup group1011 = new StudentGroup(1, "101.1", new ArrayList<Student>(
            List.of(new Student("Sergey", "Polunin"), new Student("Mikhail", "Antsiferov"), new Student("Dmitry", "Simorev"))));
    static StudentGroup group3011 = new StudentGroup(3, "301.1", new ArrayList<Student>(
            List.of(new Student("Dmitry", "Popov"), new Student("Anastasia", "Efremova"), new Student("Igor", "Srabov"))));
    static StudentGroup group3012 = new StudentGroup(3, "301.2", new ArrayList<>(
            List.of(new Student("Maria", "Abdullaeva"), new Student("Angelina", "Shalimanova"), new Student("Anna", "Dudkina"))));
    static StudentGroup group2021 = new StudentGroup(2, "202.1", new ArrayList<>(
            List.of(new Student("Freddie", "Mercury"), new Student("Brian", "May"), new Student("John", "Deacon"), new Student("Roger", "Taylor"))));
    static StudentGroup group2022 = new StudentGroup(2, "202.2", new ArrayList<>(
            List.of(new Student("John", "Lennon"), new Student("Paul", "McCartney"), new Student("George", "Harrison"), new Student("Ringo", "Starr"))));

    static ArrayList<StudentGroup> groupsList = new ArrayList<>(List.of(group1011, group3011, group3012, group2021, group2022));

    public static boolean findStudent(Student student) {
        return groupsList.stream().filter(group -> group.year() == 2).anyMatch(group -> group.students().contains(student));
    }
}
