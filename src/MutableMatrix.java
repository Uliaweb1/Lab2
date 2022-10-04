import java.util.Random;

public class MutableMatrix implements Matrix{
    private int cols;
    private int rows;
    private double[][] data;

    MutableMatrix() {
        this.data = new double[0][0];
        System.out.println("Created empty MutableMatrix");
    }

    MutableMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
        System.out.println("Created MutableMatrix with fixed dimensions: " + rows + "x" + cols);

    }

    MutableMatrix(Matrix a) {
        this.rows = a.getRows();
        this.cols = a.getCols();
        this.data = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = a.getElement(i,j);
            }
        }
        System.out.println("Created mutable copy of a matrix");
    }

    @Override
    public int getCols() {
        return cols;
    }

    public void setSize(int rows, int cols) {
        this.cols = cols;
        this.rows = rows;
        this.data = new double[rows][cols];
    }
    @Override
    public int getRows() {
        return rows;
    }
    @Override
    public double getElement(int row, int col) {
        return data[row][col];
    }

    public void setElement(int row, int col, double value) {
        data[row][col] = value;
    }
    @Override
    public double[] getRow(int n) {
        double[] res = new double[cols];
        for (int i = 0; i < cols; i++) {
            res[i] = data[n][i];
        }
        return res;
    }
    @Override
    public double[] getCol(int n) {
        double[] res = new double[rows];
        for (int i = 0; i < rows; i++) {
            res[i] = data[i][n];
        }
        return res;
    }
    public void setCol(double[] col, int colNumber){
        for (int i = 0; i < rows; i++) {
            data[i][colNumber] = col[i];
        }
    }
    public void setRow(double[] row, int rowNumber){
        for (int i = 0; i < cols; i++) {
            data[rowNumber][i] = row[i];
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final MutableMatrix other = (MutableMatrix) obj;

        if (this.rows != other.rows) {
            return false;
        }
        if (this.cols != other.cols) {
            return false;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (this.data[i][j] != other.data[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public int hashCode() {
        return cols * rows;
    }
    public static MutableMatrix genCol(int n) {
        Random rand = new Random();
        double[] tempCol = new double[n];
        for (int i = 0; i < n; i++) {
            int value = rand.nextInt(1000) - 500;
            tempCol[i] = ((double) (value / 10));

        }
        MutableMatrix m = new MutableMatrix(n,1);
        m.setCol(tempCol, 0);
        return m;
    }
    public MutableMatrix multiply(Matrix other){
        MutableMatrix temp = new MutableMatrix (this);
        if( temp.getCols() == other.getRows()){// перевіряємо розміри мартиць (для можливості перемноження)
            this.setSize(temp.getRows(), other.getCols());//задаємо нові розміри для результату (для матриці)
            for (int i = 0; i < temp.getRows(); i++) {//заповнюємо матрицю результатами скалярних добутків відповідних векторів
                for (int j = 0; j < other.getCols(); j++) {
                    double scalarProduct = 0.0;
                    for (int k = 0; k < temp.getCols(); k++) {//цикл для обчислення скалярного добутку
                        scalarProduct += temp.getRow(i)[k] * other.getCol(j)[k];
                    }
                    this.data[i][j] = scalarProduct;
                }
            }
            return this;
        }
        else {
            return null;
        }
    }

}