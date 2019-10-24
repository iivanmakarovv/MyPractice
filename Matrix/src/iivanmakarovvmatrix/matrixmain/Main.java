package iivanmakarovvmatrix.matrixmain;

import iivanmakarovvmatrix.matrix.Matrix;
import iivanmakarovvvector.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[][] arrays = {{1, 2, 3}, {3, 2, 1, 8}, {2, 3, 1, 3, 7}};
        double[][] arrays1 = {{1, 2}, {2, 1}};
        double[][] arrays2 = {{7, 3, 1, 3, 2}, {8, 1, 2, 3}, {3, 2, 1}, {4, 5, 6, 7, 8, 3}};
        double[][] arrays3 = {{7, 3, 1}, {8, 1, 2}, {3, 2, 1}, {4, 5, 6}};
        double[] array = {1, 2, 3};

        /*
        Не дописана функция умножения на вектор. Считает неправильно.
        Не дописаны статические функции и исключения.
         */

        Vector vector = new Vector(array);
        Vector[] vectors = {new Vector(arrays[0]), new Vector(arrays[1]), new Vector(arrays[2])};
        Matrix matrix = new Matrix(arrays);
        Matrix matrix1 = new Matrix(arrays1);
        Matrix matrix2 = new Matrix(arrays2);
        Matrix matrix3 = new Matrix(arrays3);

        matrix3.multiplyOnVector(vector);
        System.out.println(matrix3);


        /*matrix.plus(matrix2);
        System.out.println(matrix);


        matrix.minus(matrix2);
        System.out.println(matrix);

        System.out.println(matrix);

        System.out.println(matrix.getString(1));

        matrix.setString(0, vector);
        System.out.println(matrix);

        System.out.println(matrix.getColumn(3));

        System.out.println(matrix.transpose());
        System.out.println(matrix);

        matrix.multiplyOnScalar(5);
        System.out.println(matrix);

        System.out.println(matrix1.getDeterminant());*/
    }
}