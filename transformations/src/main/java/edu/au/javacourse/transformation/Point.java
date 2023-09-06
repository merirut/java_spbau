package edu.au.javacourse.transformation;


public class Point {
    private double x;
    private double y;


    public Point(double xValue, double yValue) {
        this.x = xValue;
        this.y = yValue;
    }


    public Point(Matrix vector) {
        this.x = vector.getValue(0, 0);
        this.y = vector.getValue(0, 1);
    }


    public double getX() {
        return this.x;
    }


    public double getY() {
        return this.y;
    }


    public Matrix asVector() {
        double[][] arr = {{this.x, this.y, 1}};
        return new Matrix(arr);
    }
}

