package iivanmakarovvmatrix.matrixmain;

import iivanmakarovvmatrix.matrix.Matrix;
import iivanmakarovvvector.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[][] arrays = {{1, 2, 3}, {3, 2, 1}, {2, 3, 1}};
        double[] array = {2, 2, 2, 2, 2};

        Vector vector = new Vector(array);
        Matrix matrix = new Matrix(arrays);

        /*System.out.println(matrix);
        System.out.println(matrix.getStringVector(1));

        matrix.setStringVector(0, vector);
        System.out.println(matrix);

        System.out.println(matrix.getColumnVector(3));

        System.out.println(Matrix.matrixTranspose(matrix));

        matrix.multiplicationMatrixOnScalar(5);
        System.out.println(matrix);*/

        System.out.println(Matrix.getDeterminant(matrix));
    }
}