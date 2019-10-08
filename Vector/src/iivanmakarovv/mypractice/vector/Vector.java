package iivanmakarovv.mypractice.vector;

public class Vector {
    private double n;

    public Vector(double n) {
        double[] vector = new double[(int) n];
        for (int i = 0; i < n; ++i) {
            vector[i] = 0;
        }
    }

    public Vector(Vector v) {
        n = v.n;
    }

    public Vector(double[] array) {
        double[] vector = new double[array.length];
        for (int i = 0; i < array.length; ++i) {
            vector[i] = array[i];
        }
    }

    public Vector(double n, double[] array) {
        double[] vector = new double[(int)n];
        for (int i = 0; i < array.length; ++i) {
            vector[i] = array[i];
        }
        for (int i = array.length; i < n; ++i) {
            vector[i] = 0;
        }

    }
}
