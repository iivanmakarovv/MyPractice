package iivanmakarovvmatrix.matrix;

import iivanmakarovvvector.vector.Vector;

public class Matrix {
    private Vector[] rows;

    public Matrix(int columnsCount, int rowsCount) {
        if (rowsCount <= 0 || columnsCount <= 0) {
            throw new IllegalArgumentException("Количество строк и столбцов матрицы должно быть больше 0");
        }

        rows = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; ++i) {
            rows[i] = new Vector(columnsCount);
        }
    }

    public Matrix(Matrix matrix) {
        rows = new Vector[matrix.rows.length];
        for (int i = 0; i < matrix.rows.length; ++i) {
            rows[i] = new Vector(matrix.rows[i]);
        }
    }

    public Matrix(Vector[] rows) {
        if (rows.length <= 0) {
            throw new IllegalArgumentException("Размерность матрицы должна быть больше 0");
        }

        int max = 0;

        for (Vector e : rows) {
            max = Math.max(max, e.getSize());
        }
        this.rows = new Vector[rows.length];

        for (int i = 0; i < rows.length; ++i) {
            this.rows[i] = new Vector(max);
            this.rows[i].plus(rows[i]);
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
        if (max <= 0) {
            throw new IllegalArgumentException("Длина строки матрицы должна быть больше 0");
        }

        rows = new Vector[arrays.length];

        for (int i = 0; i < arrays.length; ++i) {
            rows[i] = new Vector(max, arrays[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        line.append("{");

        for (int i = 0; i < rows.length; ++i) {
            line.append(rows[i].toString());

            if (i != rows.length - 1) {
                line.append(",");
            }
        }
        line.append("}");

        return line.toString();
    }

    public int getRowsCount() {
        return rows.length;
    }

    public int getColumnsCount() {
        return rows[0].getSize();
    }

    public Vector getRow(int i) {
        if (i < 0 || i >= getRowsCount()) {
            throw new IndexOutOfBoundsException("В данной матрице строки с таким индексом нет");
        }

        return new Vector(rows[i]);
    }

    public void setRow(int i, Vector vector) {
        if (i < 0 || i >= getRowsCount()) {
            throw new IndexOutOfBoundsException("В данной матрице строки с таким индексом нет");
        }

        if (getColumnsCount() != vector.getSize()) {
            throw new IllegalArgumentException("Необходимо, чтобы размеры векторов были одиннаковые");
        }
        rows[i] = new Vector(vector);
    }

    public Vector getColumn(int i) {
        if (i < 0 || i >= getColumnsCount()) {
            throw new IndexOutOfBoundsException("В данной матрице столбца с таким индексом нет");
        }

        Vector vector = new Vector(rows.length);

        for (int k = 0; k < rows.length; ++k) {
            vector.setComponent(k, rows[k].getComponent(i));
        }

        return vector;
    }

    public void transpose() {
        Matrix temp = new Matrix(rows);
        rows = new Vector[temp.getColumnsCount()];
        for (int i = 0; i < temp.getColumnsCount(); i++) {
            rows[i] = new Vector(temp.getColumn(i));
        }
    }

    public void multiplyOnScalar(double scalar) {
        for (Vector v : rows) {
            v.multiplyOnScalar(scalar);
        }
    }

    public Matrix getMinor(int i) {
        Matrix minor = new Matrix(getColumnsCount() - 1, rows.length - 1);

        for (int y = 1; y < getColumnsCount(); ++y) {
            int j = 0;

            for (int x = 0; x < getColumnsCount(); ++x) {
                if (x == i) {
                    continue;
                }
                minor.rows[y - 1].setComponent(j, rows[y].getComponent(x));
                ++j;
            }
        }

        return minor;
    }

    public double getDeterminant() {
        if (getColumnsCount() != getRowsCount()) {
            throw new IllegalArgumentException("Необходимо, чтобы ширина и высота матрицы были одиннаковые");
        }

        if (getColumnsCount() == 1) {
            return rows[0].getComponent(0);
        }

        if (getColumnsCount() == 2) {
            return rows[0].getComponent(0) * rows[1].getComponent(1) -
                    rows[0].getComponent(1) * rows[1].getComponent(0);
        }

        double determinant = 0;

        for (int i = 0; i < getColumnsCount(); ++i) {
            determinant += Math.pow(-1.0, 2.0 + i) * rows[0].getComponent(i) * getMinor(i).getDeterminant();
        }

        return determinant;
    }

    public Vector multiplyOnVector(Vector vector) {
        if (getColumnsCount() != vector.getSize()) {
            throw new IllegalArgumentException("Размерность вектора должна быть равна ширине матрицы");
        }

        Vector resultVector = new Vector(getRowsCount());

        for (int i = 0; i < getRowsCount(); ++i) {
            resultVector.setComponent(i, Vector.getScalarMultiplication(rows[i], vector));
        }

        return resultVector;
    }

    public void plus(Matrix matrix) {
        if (getColumnsCount() != matrix.getColumnsCount() || getRowsCount() != matrix.getRowsCount()) {
            throw new IllegalArgumentException("Размерность матриц должна быть одинаковой");
        }

        for (int i = 0; i < rows.length; ++i) {
            rows[i].plus(matrix.rows[i]);
        }
    }

    public void minus(Matrix matrix) {
        if (getColumnsCount() != matrix.getColumnsCount() || getRowsCount() != matrix.getRowsCount()) {
            throw new IllegalArgumentException("Размерность матриц должна быть одинаковой");
        }

        for (int i = 0; i < rows.length; ++i) {
            rows[i].minus(matrix.rows[i]);
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getColumnsCount() || matrix1.getRowsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Размерность матриц должна быть одинаковой");
        }

        Matrix resultMatrix = new Matrix(matrix1);
        resultMatrix.plus(matrix2);

        return resultMatrix;
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getColumnsCount() || matrix1.getRowsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Размерность матриц должна быть одинаковой");
        }

        Matrix resultMatrix = new Matrix(matrix1);
        resultMatrix.minus(matrix2);

        return resultMatrix;
    }

    public static Matrix getMultiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Количество столбцов первой матрицы должно быть равно количеству строк второй матрицы");
        }

        Matrix resultMatrix = new Matrix(matrix2.getColumnsCount(), matrix1.getRowsCount());

        for (int i = 0; i < matrix1.getRowsCount(); ++i) {
            for (int k = 0; k < matrix2.getColumnsCount(); ++k) {
                resultMatrix.rows[i].setComponent(k, Vector.getScalarMultiplication(matrix1.rows[i], matrix2.getColumn(k)));
            }
        }

        return resultMatrix;
    }
}