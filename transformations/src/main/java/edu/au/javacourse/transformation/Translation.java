package edu.au.javacourse.transformation;

public class Translation extends AffineTransformation {
    public Translation(double dx, double dy) {
        super(new Matrix(new double[][] {{1, 0, 0}, {0, 1, 0}, {dx, dy, 1}}));
    }
}
