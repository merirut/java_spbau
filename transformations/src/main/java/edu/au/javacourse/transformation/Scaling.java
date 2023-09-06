package edu.au.javacourse.transformation;

public class Scaling extends AffineTransformation {
    public Scaling(double kx, double ky) {
        super(new Matrix(new double[][] {{kx, 0, 0}, {0, ky, 0}, {0, 0, 1}}));
    }
}
