interface Matrix {
    default void print() {
        System.out.println("Matrix: " + getRows() + "x" + getCols());
        for (int i = 0; i < getRows(); i++) {
            double[] row = getRow(i);
            for (double elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println("");
        }
    }

    int getCols();

    int getRows();

    double getElement(int row, int col);


    double[] getRow(int n);
    double[] getCol(int n);
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//
//        if (obj.getClass() != this.getClass()) {
//            return false;
//        }
//        final Matrix other = (Matrix) obj;
//
//        if (this.rows != other.rows) {
//            return false;
//        }
//        if (this.cols != other.cols) {
//            return false;
//        }
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (this.data[i][j] != other.data[i][j]) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//    @Override
//    public int hashCode() {
//        return cols * rows;
//    }

}
