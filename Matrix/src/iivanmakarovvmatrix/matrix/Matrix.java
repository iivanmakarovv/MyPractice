package iivanmakarovvmatrix.matrix;

import iivanmakarovvvector.vector.Vector;

public class Matrix {
    private Vector[] vectors;

    public Matrix(int n, int m) {
        if (m <= 0) {
            throw new IllegalArgumentException("Размерность матрицы должна быть больше 0");
        }
        vectors = new Vector[m];
        for (int i = 0; i < m; ++i) {
            vectors[i] = new Vector(n);
        }
    }

    public Matrix(Matrix matrix) {
        vectors = new Vector[matrix.vectors.length];
        for (int i = 0; i < matrix.vectors.length; ++i) {
            vectors[i] = new Vector(matrix.vectors[i]);
        }
    }

    public Matrix(Vector[] vectors) {
        this.vectors = new Vector[vectors.length];
        for (int i = 0; i < vectors.length; ++i) {
            this.vectors[i] = new Vector(vectors[i]);
        }
    }

    public Matrix(double[][] arrays) {
        if (arrays.length <= 0) {
            throw new IllegalArgumentException("Размерность матрицы должна быть больше 0");
        }
        vectors = new Vector[arrays.length];
        for (int i = 0; i < arrays.length; ++i) {
            vectors[i] = new Vector(arrays[i]);
        }
    }

    @Override
    public String toString() {
        String line = "{";
        for (int i = 0; i < vectors.length; ++i) {
            line = line.concat("{");
            line += String.valueOf(vectors[i].getComponent(0));
            for (int k = 1; k < vectors[i].getSize(); ++k) {
                line = line.concat(", ");
                line = line.concat(String.valueOf(vectors[i].getComponent(k)));
            }
            line = line.concat("}");
            if (i != vectors.length - 1) {
                line = line.concat(",");
            }
        }
        return line.concat("}");
    }

    public Vector getStringVector(int i) {
        return vectors[i];
    }

    public void setStringVector(int i, Vector vector) {
        if (vectors[i].getSize() != vector.getSize()) {
            throw new IllegalArgumentException("Необходимо, чтобы размеры векторов были одиннаковые");
        }
        vectors[i] = vector;
    }

    public Vector getColumnVector(int i) {
        double[] array = new double[vectors.length];
        for (int k = 0; k < vectors.length; ++k) {
            array[k] = vectors[k].getComponent(i);
        }

        return new Vector(array);
    }

    public static Matrix matrixTranspose(Matrix matrix) {
        Matrix temp = new Matrix(matrix.vectors.length, matrix.vectors[0].getSize());
        for (int i = 0; i < matrix.vectors[0].getSize(); ++i) {
            temp.setStringVector(i, matrix.getColumnVector(i));
        }
        return temp;
    }

    public void multiplicationMatrixOnScalar(double scalar) {
        for (Vector v : vectors) {
            for (int k = 0; k < v.getSize(); ++k) {
                double temp = v.getComponent(k);
                v.setComponent(k, temp * scalar);
            }
        }
    }

    public static Matrix getMinor(Matrix matrix, int i) {
        Matrix minor = new Matrix(matrix.vectors[0].getSize() - 1, matrix.vectors.length - 1);

        for (int y = 1; y < matrix.vectors.length; ++y) {
            int j = 0;

            for (int x = 0; x < matrix.vectors[0].getSize(); ++x) {
                if (x == i) {
                    continue;
                }

                minor.vectors[y - 1].setComponent(j, matrix.vectors[y].getComponent(x));
                ++j;
            }
        }

        return minor;
    }

    public static double getDeterminant(Matrix matrix) {
        if (matrix.vectors[0].getSize() == 1) {
            return matrix.vectors[0].getComponent(0);
        }
        if (matrix.vectors[0].getSize() == 2) {
            return matrix.vectors[0].getComponent(0) * matrix.vectors[1].getComponent(1) -
                    matrix.vectors[0].getComponent(1) * matrix.vectors[1].getComponent(0);
        }

        double determinant = 0;

        for (int i = 0; i < matrix.vectors[0].getSize(); ++i) {
            Matrix minor = getMinor(matrix, i);

            determinant += Math.pow(-1.0, 2.0 + i) * matrix.vectors[0].getComponent(i) * getDeterminant(minor);
        }

        return determinant;
    }
}