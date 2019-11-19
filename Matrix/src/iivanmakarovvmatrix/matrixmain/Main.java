package iivanmakarovvmatrix.matrixmain;

import iivanmakarovvmatrix.matrix.Matrix;
import iivanmakarovvvector.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[][] arrays1 = {{7, 3, 1}, {8, 1, 2}, {3, 2, 1},{7, 8, 9}};
        double[][] arrays2 = {{3, 7, 9}, {2, 9, 8}, {7, 8, 9}};
        double[] array1 = {1, 2, 3};
        Vector vector = new Vector(array1);
        Matrix matrix1 = new Matrix(arrays1);
        Matrix matrix2 = new Matrix(arrays2);

        Vector[] vectors = new Vector[3];
        vectors[0] = new Vector(arrays1[0]);
        vectors[1] = new Vector(arrays1[1]);
        vectors[2] = new Vector(arrays1[2]);
        Matrix matrix3 = new Matrix(vectors);

        matrix1.transpose();
        System.out.println(matrix1);

//        matrix1.plus(matrix2);
//        System.out.println(matrix1);
//        matrix1.minus(matrix2);
//        System.out.println(matrix1);
//        System.out.println(matrix1.multiplyOnVector(vector));
//        System.out.println(Matrix.getSum(matrix1, matrix2));
//        System.out.println(Matrix.getDifference(matrix1, matrix2));
//        System.out.println(Matrix.getMultiplication(matrix1, matrix2));
    }
}