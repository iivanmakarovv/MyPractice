package iivanmakarovvvector.vector;

import java.util.Arrays;

public class Vector {
    private double[] elements;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0");
        }

        elements = new double[n];
    }

    public Vector(Vector vector) {
        elements = Arrays.copyOf(vector.elements, vector.elements.length);
    }

    public Vector(double[] elements) {
        if (elements.length <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0");
        }

        this.elements = Arrays.copyOf(elements, elements.length);
    }

    public Vector(int n, double[] elements) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0");
        }

        this.elements = Arrays.copyOf(elements, n);
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

        if (elements.length != vector.elements.length) {
            return false;
        }
        for (int i = 0; i < elements.length; ++i) {
            if (elements[i] != vector.elements[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(elements);

        return hash;
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        line.append("{");
        line.append(elements[0]);

        for (int i = 1; i < elements.length; ++i) {
            line.append(", ");
            line.append(elements[i]);
        }
        line.append("}");

        return line.toString();
    }

    public void plus(Vector vector) {
        if (elements.length >= vector.elements.length) {
            for (int i = 0; i < vector.elements.length; ++i) {
                elements[i] += vector.elements[i];
            }
        } else {
            double[] temp = new double[vector.elements.length];

            for (int i = 0; i < vector.elements.length; ++i) {
                if (i < elements.length) {
                    temp[i] += vector.elements[i] + elements[i];
                } else {
                    temp[i] += vector.elements[i];
                }
            }
            elements = temp;
        }
    }

    public void minus(Vector vector) {
        if (elements.length >= vector.elements.length) {
            for (int i = 0; i < vector.elements.length; ++i) {
                elements[i] -= vector.elements[i];
            }
        } else {
            double[] temp = new double[vector.elements.length];

            for (int i = 0; i < vector.elements.length; ++i) {
                if (i < elements.length) {
                    temp[i] = vector.elements[i] - elements[i];
                } else {
                    temp[i] = vector.elements[i];
                }

                if (temp[i] != 0) {
                    temp[i] *= -1;
                }
            }
            elements = temp;
        }
    }

    public void multiplyOnScalar(double scalar) {
        for (int i = 0; i < elements.length; ++i) {
            if (elements[i] != 0) {
                elements[i] *= scalar;
            }
        }
    }

    public void turn() {
        multiplyOnScalar(-1);
    }

    public double getLength() {
        double sum = 0;
        for (double e : elements) {
            sum += e * e;
        }

        return Math.sqrt(sum);
    }

    public double getComponent(int i) {
        return elements[i];
    }

    public void setComponent(int i, double component) {
        elements[i] = component;
    }

    public int getSize() {
        return elements.length;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1.elements.length);
        resultVector.plus(vector1);
        resultVector.plus(vector2);

        return resultVector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1.elements.length);
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