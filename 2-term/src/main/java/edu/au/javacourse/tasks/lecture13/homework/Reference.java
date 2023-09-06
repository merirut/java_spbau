package edu.au.javacourse.tasks.lecture13.homework;

public class Reference{
        private String university;
        private int year;
        private String firstName;
        private String lastName;

    public Reference(String university, int year, String firstName, String lastName) {
        this.university = university;
        this.year = year;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getYear() {
        return year;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void printReference(){
        System.out.println("Справка дана в том, что " +  lastName + " " + firstName + " является студентом " + year + " курса очной формы обучения. Место обучения: " + university);
    }
}
