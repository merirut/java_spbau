package edu.au.javacourse.tasks.lecture15.classwork;

import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {

    @Test
    public void dbStudent() {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:javacourse;INIT=RUNSCRIPT FROM 'classpath:javacourse_init.sql'");

        try (Connection connection = ds.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student WHERE age>21");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("last_name");
                String lastName = resultSet.getString("first_name");
                int age = resultSet.getInt("age");
                System.out.println(id + " " + firstName + " " + lastName + " " + age + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
