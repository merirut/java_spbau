package edu.au.javacourse.tasks.lecture15.homework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStudentHelper {
    public static void listAllStudents(Connection conn, String title) {
        try (Statement statement = conn.createStatement()) {
            System.out.println(title);
            ResultSet resultSet = statement.executeQuery("SELECT id, first_name, last_name, age FROM student");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");

                System.out.println(id + " " + firstName + " " + lastName + " " + age);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
