package edu.au.javacourse.tasks.lecture13.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Task2 {
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


    public static void printReferences() {
        groupsList.stream()
                .flatMap(
                        group -> group.students().stream()
                                .map(
                                        student -> new Reference(
                                                "\"Санкт-Петербургский национальный исследовательский Академический университет имени Ж.И. Алфёрова РАН\"",
                                                group.year(),
                                                student.firstName(),
                                                student.lastName()
                                        )
                                )
                )
                .sorted(
                        Comparator.comparing(Reference::getYear)
                                .thenComparing(Reference::getLastName)
                                .thenComparing(Reference::getFirstName)
                )
                .forEachOrdered(Reference::printReference);
    }
}
