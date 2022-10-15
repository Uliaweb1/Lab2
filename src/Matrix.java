interface Matrix {
    default void print() {//функція щоб вивести матриці на екран
        System.out.println("Matrix " + getRows() + "x" + getCols());//вивід на екран розмірність матриці(гетровс та гетколс - це гетери для розміру матриці)
        for (int i = 0; i < getRows(); i++) {
            double[] row = getRow(i);
            for (double elem : row) {//цикл по елементам рядка
                System.out.print(elem + " ");//Виводимо елемент (і пробіл(в матриці між елементами))
            }
            System.out.println();//принт і перехід на новий рядок (в матриці)
        }
    }

    int getCols();//функція яка повертає кількість стовпчиків матриці

    int getRows();//функція яка повертає кількість рядків матриці

    double getElement(int row, int col);//функція яка повертає елемент рядку ров та стовпчику кол.


    double[] getRow(int n);//гетер для радка з номером н, повертає масив чисел.
    double[] getCol(int n);//повертає масив значень елементів стовпчика з номером н.
}