package ru.mirea.task20;

public class Matrix<T extends Number> {
    private final T[][] data;

    public Matrix(T[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            throw new IllegalArgumentException("Матрица не должна быть пустой");
        }
        for (T[] row : data) {
            if (row.length != data[0].length) {
                throw new IllegalArgumentException("Все строки матрицы должны быть одной длины");
            }
        }
        this.data = data;
    }

    public int rows() {
        return data.length;
    }

    public int cols() {
        return data[0].length;
    }

    public T get(int i, int j) {
        return data[i][j];
    }

    // сложение матриц
    public <V extends Number> Matrix<Double> add(Matrix<V> other) {
        checkSameSize(other);
        Double[][] r = new Double[rows()][cols()];
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                r[i][j] = data[i][j].doubleValue() + other.get(i, j).doubleValue();
            }
        }
        return new Matrix<>(r);
    }

    // вычитание матриц
    public <V extends Number> Matrix<Double> subtract(Matrix<V> other) {
        checkSameSize(other);
        Double[][] r = new Double[rows()][cols()];
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                r[i][j] = data[i][j].doubleValue() - other.get(i, j).doubleValue();
            }
        }
        return new Matrix<>(r);
    }

    // умножение матриц
    public <V extends Number> Matrix<Double> multiply(Matrix<V> other) {
        if (cols() != other.rows()) {
            throw new IllegalArgumentException(
                    "Нельзя умножить: столбцов первой матрицы " + cols()
                            + ", строк второй " + other.rows());
        }
        Double[][] r = new Double[rows()][other.cols()];
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < other.cols(); j++) {
                double s = 0;
                for (int k = 0; k < cols(); k++) {
                    s += data[i][k].doubleValue() * other.get(k, j).doubleValue();
                }
                r[i][j] = s;
            }
        }
        return new Matrix<>(r);
    }

    // умножение на число
    public Matrix<Double> multiply(double scalar) {
        Double[][] r = new Double[rows()][cols()];
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                r[i][j] = data[i][j].doubleValue() * scalar;
            }
        }
        return new Matrix<>(r);
    }

    // транспонирование
    public Matrix<Double> transpose() {
        Double[][] r = new Double[cols()][rows()];
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                r[j][i] = data[i][j].doubleValue();
            }
        }
        return new Matrix<>(r);
    }

    // определитель (метод Гаусса)
    public double determinant() {
        if (rows() != cols()) {
            throw new IllegalArgumentException("Определитель существует только у квадратной матрицы");
        }
        int n = rows();
        double[][] a = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = data[i][j].doubleValue();
            }
        }
        double det = 1;
        for (int c = 0; c < n; c++) {
            int pivot = c;
            for (int r = c + 1; r < n; r++) {
                if (Math.abs(a[r][c]) > Math.abs(a[pivot][c])) {
                    pivot = r;
                }
            }
            if (Math.abs(a[pivot][c]) < 1e-12) {
                return 0;
            }
            if (pivot != c) {
                double[] tmp = a[pivot];
                a[pivot] = a[c];
                a[c] = tmp;
                det = -det;
            }
            det *= a[c][c];
            for (int r = c + 1; r < n; r++) {
                double f = a[r][c] / a[c][c];
                for (int k = c; k < n; k++) {
                    a[r][k] -= f * a[c][k];
                }
            }
        }
        return det;
    }

    private void checkSameSize(Matrix<?> other) {
        if (rows() != other.rows() || cols() != other.cols()) {
            throw new IllegalArgumentException("Размеры матриц не совпадают: "
                    + rows() + "x" + cols() + " и " + other.rows() + "x" + other.cols());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T[] row : data) {
            for (T x : row) {
                sb.append(String.format("%8s", x instanceof Double ? String.format("%.2f", x) : x));
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Matrix<Integer> a = new Matrix<>(new Integer[][]{{1, 2}, {3, 4}});
        Matrix<Integer> b = new Matrix<>(new Integer[][]{{5, 6}, {7, 8}});
        System.out.println("A =\n" + a);
        System.out.println("B =\n" + b);
        System.out.println("A + B =\n" + a.add(b));
        System.out.println("A - B =\n" + a.subtract(b));
        System.out.println("A * B =\n" + a.multiply(b));
        System.out.println("A * 2.5 =\n" + a.multiply(2.5));
        System.out.println("A^T =\n" + a.transpose());
        System.out.println("det(A) = " + a.determinant());
        Matrix<Double> c = new Matrix<>(new Double[][]{{1.0, 2.0, 3.0}, {0.0, 1.0, 4.0}, {5.0, 6.0, 0.0}});
        System.out.println("det(C) = " + String.format("%.4f", c.determinant()));
        try {
            a.multiply(new Matrix<>(new Integer[][]{{1, 2, 3}}));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}