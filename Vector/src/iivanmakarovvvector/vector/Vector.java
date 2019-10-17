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
        String line = "{";
        line += String.valueOf(array[0]);
        for (int i = 1; i < array.length; ++i) {
            line = line.concat(", ");
            line = line.concat(String.valueOf(array[i]));
        }

        return line.concat("}");
    }

    public void plus(Vector vector) {
        int max = Math.max(array.length, vector.array.length);
        int min = Math.min(array.length, vector.array.length);
        double[] temp = new double[max];

        for (int i = 0; i < min; ++i) {
            temp[i] = array[i] + vector.array[i];
        }

        if (max != min) {
            if (max == array.length) {
                System.arraycopy(array, min, temp, min, max - min);
            } else {
                System.arraycopy(vector.array, min, temp, min, max - min);
            }
        }
        array = temp;
    }

    public void minus(Vector vector) {
        int max = Math.max(array.length, vector.array.length);
        int min = Math.min(array.length, vector.array.length);
        double[] temp = new double[max];

        for (int i = 0; i < min; ++i) {
            temp[i] = array[i] - vector.array[i];
        }

        if (max != min) {
            if (max == array.length) {
                System.arraycopy(array, min, temp, min, max - min);
            } else {
                for (int i = min; i < max; ++i) {
                    temp[i] = -vector.array[i];
                }
            }
        }
        array = temp;
    }

    public void multiplicationOnScalar(double scalar) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i] != 0) {
                array[i] *= scalar;
            }
        }
    }

    public void slew() {
        multiplicationOnScalar(-1);
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

    public double getSize() {
        return array.length;
    }

    public double[] getArray() {
        return array;
    }

    public static Vector getVectorsSum(Vector first, Vector second) {
        int max = Math.max(first.array.length, second.array.length);
        int min = Math.min(first.array.length, second.array.length);
        double[] resultArray = new double[max];

        for (int i = 0; i < min; ++i) {
            resultArray[i] = first.array[i] + second.array[i];
        }

        if (max != min) {
            if (max == first.array.length) {
                System.arraycopy(first.array, min, resultArray, min, max - min);
            } else {
                System.arraycopy(second.array, min, resultArray, min, max - min);
            }
        }

        return new Vector(resultArray);
    }

    public static Vector getVectorsDifference(Vector first, Vector second) {
        int max = Math.max(first.array.length, second.array.length);
        int min = Math.min(first.array.length, second.array.length);
        double[] resultArray = new double[max];

        for (int i = 0; i < min; ++i) {
            resultArray[i] = first.array[i] - second.array[i];
        }

        if (max != min) {
            if (max == first.array.length) {
                System.arraycopy(first.array, min, resultArray, min, max - min);
            } else {
                for (int i = min; i < max; ++i) {
                    resultArray[i] = -second.array[i];
                }
            }
        }

        return new Vector(resultArray);
    }

    public static double getVectorsScalarMultiplication(Vector first, Vector second) {
        double scalarMulti = 0;
        for (int i = 0; i < Math.min(first.getSize(), second.getSize()); ++i) {
            scalarMulti += first.getComponent(i) * second.getComponent(i);
        }
        return scalarMulti;
    }
}