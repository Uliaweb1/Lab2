public class Matrix {
    private int cols,rows;
    private double[][] data;
    Matrix (){
        this.data = new double[0][0];
        System.out.println("Created empty matrix");
    }
    Matrix(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
        System.out.println("Created matrix with fixed dimensions: " + rows + "x" + cols);

    }
    Matrix (Matrix a) {
        this.rows = a.rows;
        this.cols = a.cols;
        this.data = a.data;
        System.out.println("Created copy of a matrix");
    }
    public void output(){
        System.out.println("Matrix: "+ rows +"x" + cols);
        for (double[] row:data ){
            for (double elem:row) {
                System.out.print(elem + " ");
            }
            System.out.println("");
        }
    }
}
