package iivanmakarovvmatrix.matrixmain;

import iivanmakarovvmatrix.matrix.Matrix;
import iivanmakarovvvector.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[][] arraysForPlusMinus1 = {{1, 2, 3}, {3, 2, 1, 8}, {2, 3, 1, 3, 7}};
        double[][] arraysForPlusMinus2 = {{7, 3, 1, 3, 2}, {8, 1, 2, 3}, {3, 2, 1}, {4, 5, 6, 7, 8, 3}};
        Matrix matrixForPlusMinus1 = new Matrix(arraysForPlusMinus1);
        Matrix matrixForPlusMinus2 = new Matrix(arraysForPlusMinus2);

        matrixForPlusMinus1.plus(matrixForPlusMinus2);
        System.out.println(matrixForPlusMinus1);

        matrixForPlusMinus1.minus(matrixForPlusMinus2);
        System.out.println(matrixForPlusMinus1);

        System.out.println(Matrix.getSum(matrixForPlusMinus1, matrixForPlusMinus2));
        System.out.println(Matrix.getDifference(matrixForPlusMinus1, matrixForPlusMinus2));


        double[][] arraysForMultiply = {{7, 3, 1}, {8, 1, 2}, {3, 2, 1}, {4, 5, 6}};
        double[] arrayForVector = {1, 2, 3};
        Vector vectorForMultiply = new Vector(arrayForVector);
        Matrix matrixForMultiply = new Matrix(arraysForMultiply);
        matrixForMultiply.multiplyOnVector(vectorForMultiply);
        System.out.println(matrixForMultiply);


        double[][] arraysForMultiplication1 = {{1, 2, 3}, {3, 2, 1}};
        double[][] arraysForMultiplication2 = {{1, 3}, {2, 2}, {3, 1}};
        Matrix matrixForMultiplication1 = new Matrix(arraysForMultiplication1);
        Matrix matrixForMultiplication2 = new Matrix(arraysForMultiplication2);
        System.out.println(Matrix.getMultiplication(matrixForMultiplication1, matrixForMultiplication2));
    }
}