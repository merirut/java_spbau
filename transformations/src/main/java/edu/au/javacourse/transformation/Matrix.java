package edu.au.javacourse.transformation;


public class Matrix {
    private double[][] data;

    public Matrix(double[][] matrix) {
        this.data = matrix;
    }


    public double getValue(int row, int column) {
        return this.data[row][column];
    }


    public Matrix multiply(Matrix other) {
        int n = this.data.length;
        int m = this.data[0].length;
        int k = other.data[0].length;

        double[][] result = new double[n][k];

        for (int i = 0; i < n; i++) {
            for (int l = 0; l < k; l++) {

                for (int j = 0; j < m; j++) {
                    result[i][l] += this.getValue(i, j) * other.getValue(j, l);
                }

            }
        }
        return new Matrix(result);
    }
}
