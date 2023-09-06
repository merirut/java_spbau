package edu.au.javacourse.transformation;

public class Rotation extends AffineTransformation {
    public Rotation(double alpha) {
        super(new Matrix(new double[][] {{Math.cos(alpha), Math.sin(alpha), 0},
                {-Math.sin(alpha), Math.cos(alpha), 0},
                {0, 0, 1}}));
    }
}
