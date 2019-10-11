package iivanmakarovv.mypractice.vector;

import java.util.Arrays;

public class Vector {
    private double n;
    private double[] array;

    public Vector(double n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n должн быть больше 0");
        }
        this.n = n;
        this.array = new double[(int) n];
        for (int i = 0; i < n; ++i) {
            this.array[i] = 0;
        }
    }

    public Vector(Vector vector) {
        this.n = vector.n;
        this.array = Arrays.copyOf(vector.array, (int) this.n);
    }

    public Vector(double[] array) {
        if (array.length <= 0) {
            throw new IllegalArgumentException("n должн быть больше 0");
        }
        this.n = array.length;
        this.array = Arrays.copyOf(array, array.length);
    }

    public Vector(double n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("n должн быть больше 0");
        }
        this.n = n;
        this.array = Arrays.copyOf(array, (int) n);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        if (this.n != vector.n) return false;
        for (int i = 0; i < this.n; ++i) {
            if (this.array[i] != vector.array[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        for (int i = 0; i < this.n; ++i) {
            hash = prime * hash + Double.hashCode(this.array[i]);
        }
        return hash;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public void sum(Vector vector) {
        if (this.array.length >= vector.array.length) {
            for (int i = 0; i < vector.array.length; ++i) {
                this.array[i] += vector.array[i];
            }
        } else {
            for (int i = 0; i < this.array.length; ++i) {
                vector.array[i] += this.array[i];
            }
            this.array = vector.array;
        }
    }

    public void difference(Vector vector) {
        if (this.array.length >= vector.array.length) {
            for (int i = 0; i < vector.array.length; ++i) {
                this.array[i] -= vector.array[i];
            }
        } else {
            for (int i = 0; i < this.array.length; ++i) {
                vector.array[i] -= this.array[i];
                vector.array[i] *= -1;
            }
            this.array = vector.array;
        }
    }

    public void scalarMultiplication(double scalar) {
        for (int i = 0; i < this.array.length; ++i) {
            this.array[i] *= scalar;
        }
    }

    public void reversVector() {
        for (int i = 0; i < this.array.length; ++i) {
            this.array[i] *= -1;
        }
    }

    public double getVectorLength() {
        double sum = 0;
        for (double i : this.array) {
            sum += i * i;
        }
        return Math.sqrt(sum);
    }

    public double getComponent(int i) {
        return this.array[i];
    }

    public void setComponent(int i, double component) {
        this.array[i] = component;
    }

    public double getSize() {
        return this.n;
    }
}
