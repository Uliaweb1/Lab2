interface Matrix {
    default void print() {
        System.out.println("Matrix: " + getRows() + "x" + getCols());
        for (int i = 0; i < getRows(); i++) {
            double[] row = getRow(i);
            for (double elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    int getCols();

    int getRows();

    double getElement(int row, int col);


    double[] getRow(int n);

    double[] getCol(int n);
}