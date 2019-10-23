package iivanmakarovvmatrix.matrixmain;

import iivanmakarovvmatrix.matrix.Matrix;
import iivanmakarovvvector.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[][] arrays = {{1, 2, 3}, {3, 2, 1, 8}, {2, 3, 1, 3, 7}};


        double[][] arrays1 = {{1, 2}, {2, 1}};

        Vector vector = new Vector(arrays[0]);
        Vector[] vectors = {new Vector(arrays[0]), new Vector(arrays[1]), new Vector(arrays[2])};
        Matrix matrix = new Matrix(arrays);
        Matrix matrix1 = new Matrix(arrays1);

        /*System.out.println(matrix);

        System.out.println(matrix.getString(1));

        matrix.setString(0, vector);
        System.out.println(matrix);

        System.out.println(matrix.getColumn(3));

        System.out.println(Matrix.transpose(matrix));

        matrix.multiplyOnScalar(5);
        System.out.println(matrix);*/

        System.out.println(matrix1.getDeterminant());
    }
}