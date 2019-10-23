package iivanmakarovvvector.vector;

import java.util.Arrays;

public class Vector {
    private double[] array;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0");
        }

        array = new double[n];
    }

    public Vector(Vector vector) {
        array = Arrays.copyOf(vector.array, vector.array.length);
    }

    public Vector(double[] array) {
        if (array.length <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0");
        }

        this.array = Arrays.copyOf(array, array.length);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0");
        }

        this.array = Arrays.copyOf(array, n);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vector vector = (Vector) o;

        if (array.length != vector.array.length) {
            return false;
        }
        for (int i = 0; i < array.length; ++i) {
            if (array[i] != vector.array[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(array);

        return hash;
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        line.append("{");
        line.append(array[0]);

        for (int i = 1; i < array.length; ++i) {
            line.append(", ");
            line.append(array[i]);
        }
        line.append("}");

        return line.toString();
    }

    public void plus(Vector vector) {
        int max = Math.max(array.length, vector.array.length);

        if (max == array.length) {
            for (int i = 0; i < vector.array.length; ++i) {
                array[i] += vector.array[i];
            }
        } else {
            double[] temp = new double[vector.array.length];

            for (int i = 0; i < vector.array.length; ++i) {
                if (i < array.length) {
                    temp[i] += vector.array[i] + array[i];
                } else {
                    temp[i] += vector.array[i];
                }
            }
            array = temp;
        }
    }

    public void minus(Vector vector) {
        int max = Math.max(array.length, vector.array.length);

        if (max == array.length) {
            for (int i = 0; i < vector.array.length; ++i) {
                array[i] -= vector.array[i];
            }
        } else {
            double[] temp = new double[vector.array.length];

            for (int i = 0; i < vector.array.length; ++i) {
                if (i < array.length) {
                    temp[i] = vector.array[i] - array[i];
                } else {
                    temp[i] = vector.array[i];
                }
            }
            for (int i = 0; i < temp.length; ++i) {
                if (temp[i] != 0) {
                    temp[i] *= -1;
                }
            }
            array = temp;
        }
    }

    public void multiplyOnScalar(double scalar) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i] != 0) {
                array[i] *= scalar;
            }
        }
    }

    public void turn() {
        multiplyOnScalar(-1);
    }

    public double getLength() {
        double sum = 0;
        for (double e : array) {
            sum += e * e;
        }

        return Math.sqrt(sum);
    }

    public double getComponent(int i) {
        return array[i];
    }

    public void setComponent(int i, double component) {
        array[i] = component;
    }

    public int getSize() {
        return array.length;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1.array.length);
        resultVector.plus(vector1);
        resultVector.plus(vector2);

        return resultVector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1.array.length);
        resultVector.plus(vector1);
        resultVector.minus(vector2);

        return resultVector;
    }

    public static double getScalarMultiplication(Vector vector1, Vector vector2) {
        int min = Math.min(vector1.getSize(), vector2.getSize());
        double scalarMultiplication = 0;

        for (int i = 0; i < min; ++i) {
            scalarMultiplication += vector1.getComponent(i) * vector2.getComponent(i);
        }

        return scalarMultiplication;
    }
}