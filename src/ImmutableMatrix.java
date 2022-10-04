public final class ImmutableMatrix implements Matrix{
    private final int cols;
    private final int rows;
    private final double[][] data;

    ImmutableMatrix() {
        rows = 0;
        cols = 0;
        this.data = new double[0][0];
        System.out.println("Created empty matrix");
    }

    ImmutableMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
        System.out.println("Created matrix with fixed dimensions: " + rows + "x" + cols);

    }

    ImmutableMatrix(Matrix a) {
        this.rows = a.getRows();
        this.cols = a.getCols();
        this.data = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = a.getElement(i,j);
            }
        }
        System.out.println("Created immutable copy of a matrix");
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

//    public static ImmutableMatrix genCol(int n) {
//        double[] tempCol = new double[n];
//        for (int i = 0; i < n; i++) {
//            tempCol[i] = Math.random();
//
//        }
//        return null;
//    }
}
