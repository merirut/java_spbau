package edu.au.javacourse.tasks.lecture20.classwork;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;


public class GenerateRandoms {
    private static JTextField lowerBoundInput, upperBoundInput;
    private static JTextField randomOutput;
    private static int lowerBoundInt, upperBoundInt;


    private static void GenerateRandoms() {
        JLabel lowerBoundLabel = new JLabel("Нижняя граница");
        JLabel upperBoundLabel = new JLabel("Верхняя граница");
        lowerBoundInput = new JTextField(10);
        upperBoundInput = new JTextField(10);

        JButton mainButton = new JButton("Сгенерировать");
        mainButton.addActionListener(e -> getBounds());

        randomOutput = new JTextField(30);
        randomOutput.setEditable(false);

        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Generate Randoms");
        mainFrame.setBounds(720, 250, 720, 480);
        mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));

        mainFrame.getContentPane().add(lowerBoundLabel);
        mainFrame.getContentPane().add(lowerBoundInput);
        mainFrame.getContentPane().add(upperBoundLabel);
        mainFrame.getContentPane().add(upperBoundInput);
        mainFrame.getContentPane().add(mainButton);
        mainFrame.getContentPane().add(randomOutput);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }


    private static void getBounds() {
        try {
            lowerBoundInt = Integer.parseInt(lowerBoundInput.getText());
            upperBoundInt = Integer.parseInt(upperBoundInput.getText());
            printRandoms();
        }
        catch (NumberFormatException e) {
            randomOutput.setText("Введите два целых числа!");
        }
        catch (IllegalArgumentException e) {
            randomOutput.setText("Нижняя граница должна быть меньше верхней!");
        }
    }


    private static void printRandoms() {
        randomOutput.setText(
                ThreadLocalRandom.current().nextInt(lowerBoundInt, upperBoundInt + 1)
                + ", " +
                ThreadLocalRandom.current().nextInt(lowerBoundInt, upperBoundInt + 1)
        );
    }


    public static void main(String[] args) {
        GenerateRandoms();
    }
}
