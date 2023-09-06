package edu.au.javacourse.transformation;

public class AffineTransformation implements Transformation {
    private Matrix matrix;


    public AffineTransformation() {
        this.matrix = new Matrix(new double[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}});
    }


    public AffineTransformation(Matrix matrix) {
        this.matrix = matrix;
    }


    public Point apply(Point p) {
        return new Point(p.asVector().multiply(this.matrix));
    }


    public AffineTransformation thenDo(AffineTransformation next) {
        return new AffineTransformation(this.matrix.multiply(next.matrix));
    }
}
