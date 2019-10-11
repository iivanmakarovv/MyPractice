package iivanmakarovv.mypractice.vectormain;

import iivanmakarovv.mypractice.vector.Vector;

public class Main {
    private static Vector getVectorsSum(Vector first, Vector second) {
        first.sum(second);
        return new Vector(first);
    }

    private static Vector getVectorsDifference(Vector first, Vector second) {
        first.difference(second);
        return new Vector(first);
    }

    private static double getVectorsScalarMultiplication(Vector first, Vector second) {
        double scalarMulti = 0;
        for (int i = 0; i < Math.min(first.getSize(), second.getSize()); ++i) {
            scalarMulti += first.getComponent(i) * second.getComponent(i);
        }
        return scalarMulti;
    }


    public static void main(String[] args) {
        double[] array = {1, 2, 3, 4, 5};

        Vector vector1 = new Vector(6);
        Vector vector2 = new Vector(array);
        Vector vector3 = new Vector(6, array);
        Vector vector4 = new Vector(vector3);

        System.out.println(vector1.toString());

        Vector vector5 = getVectorsSum(vector3, vector2);
        System.out.println(vector5.toString());

        Vector vector6 = getVectorsDifference(vector5, vector2);
        System.out.println(vector6.toString());

        System.out.println(getVectorsScalarMultiplication(vector6, vector4));
    }
}
