package edu.au.javacourse.tasks.lecture15.homework;


import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Test1 {
    private static void addStudent(Connection conn, int id, String firstname, String lastname, int age) {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO student(id, first_name, last_name, age) VALUES (?, ?, ?, ?);")) {
            stmt.setString(1, String.valueOf(id));
            stmt.setString(2, firstname);
            stmt.setString(3, lastname);
            stmt.setString(4, String.valueOf(age));
            stmt.executeUpdate();
            System.out.println("Добавлен студент:\n" + id + " " + firstname + " " + lastname + " " + age);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test () { // не тест, потому что в тесте не работает scanner (гуглила)
        JdbcDataSource ds = new JdbcDataSource();
        String databaseURL = "jdbc:h2:mem:javacourse;INIT=RUNSCRIPT FROM 'classpath:javacourse_init.sql'";
        ds.setURL(databaseURL);

        try (Connection connection = ds.getConnection()) {
            connection.setAutoCommit(false);

            JDBCStudentHelper.listAllStudents(connection, "Начальный список:");
            addStudent(connection, 3, "Вера", "Семёнова", 25);
            connection.commit();

            JDBCStudentHelper.listAllStudents(connection, "После commit:");
            addStudent(connection, 4, "Владимир", "Поздняков", 20);
            connection.rollback();

            JDBCStudentHelper.listAllStudents(connection, "После rollback:");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
