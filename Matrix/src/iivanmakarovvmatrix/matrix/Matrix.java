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
        int max = 0;

        for (Vector e : vectors) {
            max = Math.max(max, e.getSize());
        }
        double[][] temp = new double[vectors.length][max];
        this.vectors = new Vector[temp.length];

        for (int i = 0; i < vectors.length; ++i) {
            if (vectors[i].getSize() <= max) {
                for (int k = 0; k < max; ++k) {
                    if (k < vectors[i].getSize()) {
                        temp[i][k] = vectors[i].getComponent(k);
                    } else {
                        temp[i][k] = 0;
                    }
                }
            }
            this.vectors[i] = new Vector(temp[i]);
        }
    }

    public Matrix(double[][] arrays) {
        if (arrays.length <= 0) {
            throw new IllegalArgumentException("Размерность матрицы должна быть больше 0");
        }

        int max = 0;

        for (double[] e : arrays) {
            max = Math.max(max, e.length);
        }
        double[][] temp = new double[arrays.length][max];
        vectors = new Vector[temp.length];

        for (int i = 0; i < arrays.length; ++i) {
            if (arrays[i].length <= max) {
                for (int k = 0; k < max; ++k) {
                    if (k < arrays[i].length) {
                        temp[i][k] = arrays[i][k];
                    } else {
                        temp[i][k] = 0;
                    }
                }
            }
            vectors[i] = new Vector(temp[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        line.append("{");
        for (int i = 0; i < vectors.length; ++i) {
            line.append("{");
            line.append(vectors[i].getComponent(0));
            for (int k = 1; k < vectors[i].getSize(); ++k) {
                line.append(", ");
                line.append(vectors[i].getComponent(k));
            }
            line.append("}");
            if (i != vectors.length - 1) {
                line.append(",");
            }
        }
        line.append("}");
        return line.toString();
    }

    public Vector getString(int i) {
        return vectors[i];
    }

    public void setString(int i, Vector vector) {
        if (vectors[i].getSize() != vector.getSize()) {
            throw new IllegalArgumentException("Необходимо, чтобы размеры векторов были одиннаковые");
        }
        vectors[i] = vector;
    }

    public Vector getColumn(int i) {
        double[] array = new double[vectors.length];
        for (int k = 0; k < vectors.length; ++k) {
            array[k] = vectors[k].getComponent(i);
        }

        return new Vector(array);
    }

    public static Matrix transpose(Matrix matrix) {
        Matrix temp = new Matrix(matrix.vectors.length, matrix.vectors[0].getSize());
        for (int i = 0; i < matrix.vectors[0].getSize(); ++i) {
            temp.setString(i, matrix.getColumn(i));
        }
        return temp;
    }

    public void multiplyOnScalar(double scalar) {
        for (Vector v : vectors) {
            for (int k = 0; k < v.getSize(); ++k) {
                double temp = v.getComponent(k);
                v.setComponent(k, temp * scalar);
            }
        }
    }

    public Matrix getMinor(int i) {
        Matrix minor = new Matrix(vectors[0].getSize() - 1, vectors.length - 1);

        for (int y = 1; y < vectors.length; ++y) {
            int j = 0;

            for (int x = 0; x < vectors[0].getSize(); ++x) {
                if (x == i) {
                    continue;
                }
                vectors[y - 1].setComponent(j, vectors[y].getComponent(x));
                ++j;
            }
        }

        return minor;
    }

    public double getDeterminant() {
        if (vectors[0].getSize() == 1) {
            return vectors[0].getComponent(0);
        }
        if (vectors[0].getSize() == 2) {
            return vectors[0].getComponent(0) * vectors[1].getComponent(1) -
                    vectors[0].getComponent(1) * vectors[1].getComponent(0);
        }
        double determinant = 0;

        for (int i = 0; i < vectors[0].getSize(); ++i) {
            determinant += Math.pow(-1.0, 2.0 + i) * vectors[0].getComponent(i) * this.getMinor(i).getDeterminant();
        }

        return determinant;
    }
}