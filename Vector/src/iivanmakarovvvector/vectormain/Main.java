package iivanmakarovvvector.vectormain;

import iivanmakarovvvector.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[] array1 = {1, 2, 3, 4, 5};
        double[] array2 = {5, 4, 3, 2, 1};
        double[] array3 = {1, 2, 3, 4, 5, 6, 7};

        Vector vector1 = new Vector(5);
        Vector vector2 = new Vector(array1);
        Vector vector3 = new Vector(7, array1);
        Vector vector4 = new Vector(vector2);
        Vector vector5 = new Vector(array2);
        Vector vector6 = new Vector(array3);

       System.out.println(vector1);

        System.out.println(vector2);
        System.out.println(vector5);
        vector2.plus(vector5);
        System.out.println(vector2);
        vector2.minus(vector5);
        System.out.println(vector2);

        System.out.println(Vector.getVectorsSum(vector5, vector6));
        System.out.println(Vector.getVectorsDifference(vector5, vector6));
        System.out.println(Vector.getVectorsScalarMultiplication(vector5, vector6));

        System.out.println(vector6);
    }
}