import java.util.Random;

public final class ImmutableMatrix implements Matrix{
    private final int cols;
    private final int rows;
    private final double[][] data;

    ImmutableMatrix() {
        rows = 0;
        cols = 0;
        this.data = new double[0][0];
    }

    ImmutableMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    ImmutableMatrix(Matrix m) {//копіювання
        this.rows = m.getRows();
        this.cols = m.getCols();
        this.data = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = m.getElement(i,j);
            }
        }
    }

    @Override
    public int getCols() {
        return cols;
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public double getElement(int row, int col) {
        return data[row][col];
    }

    @Override
    public double[] getRow(int n) {
        double[] res = new double[cols];
        System.arraycopy(data[n], 0, res, 0, cols);
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final ImmutableMatrix other = (ImmutableMatrix)  obj;

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

    public static ImmutableMatrix genCol(int n) {
        Random rand = new Random();
        double[] tempCol = new double[n];
        for (int i = 0; i < n; i++) {
            int value = rand.nextInt(1000) - 500;
            tempCol[i] = value / 10.0;
        }
        MutableMatrix m = new MutableMatrix(n,1);
        m.setCol(tempCol, 0);
        return new ImmutableMatrix(m);
    }
}
