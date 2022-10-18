import java.util.Scanner;

public class Main {
    private static int safeReadInt(Scanner stdin){
        int a;
        while (true){
            try{
                a = stdin.nextInt();
                if (a < 0) {
                    System.out.println("Введено від'ємне число, введіть невід'ємне:");
                }
                break;
            }
            catch (Exception e){
                System.out.println("Помилка вводу, введіть ціле число:");
                stdin.next();
            }
        }
        return a;
    }

    private static double safeReadDouble(Scanner stdin){
        double a;
        while (true){
            try{
                a = stdin.nextDouble();
                break;
            }
            catch (Exception e){
                System.out.println("Помилка вводу, введіть число:");
                stdin.next();
            }
        }
        return a;
    }

    private static MutableMatrix menuGen(Scanner stdin){
        System.out.println("Введіть кількість елементів у стовпчику: ");
        int n = safeReadInt(stdin);
        System.out.println("Створено пусту матрицю");
        return MutableMatrix.genCol(n);
    }

    private static MutableMatrix createMenu(Scanner stdin){
        System.out.println("Введіть розмірність матриці: ");
        int a = safeReadInt(stdin);
        int b = safeReadInt(stdin);
        MutableMatrix m = new MutableMatrix(a,b);
        System.out.println("Створено матрицю фіксованого розміру");
        while(true){
            System.out.println("Оберіть спосіб заповнення матриці: ");
            System.out.println("1.Заповнити вручну");
            System.out.println("2.Заповнити випадковими значеннями");
            System.out.println("3.Заповнити нулями");
            int menuEntry=safeReadInt(stdin);
            switch (menuEntry){
                case 1:
                    for (int row = 0; row < a; row++) {
                        for (int col = 0; col < b; col++) {
                            System.out.println("Введіть елемент [" + (row+1) + "][" + (col+1) +"]");
                            m.setElement(row, col, safeReadDouble(stdin));
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < b; i++) {
                        m.setCol(MutableMatrix.genCol(a).getCol(0), i);
                    }
                    break;
                case 3:
                    System.out.println("Створено матрицю заповнену нулями");
                    return new MutableMatrix(a, b);
                default:
                    System.out.println("Неправильний пункт меню!");
                    continue;
            }
            break;
        }
        System.out.println("Матрицю створено та заповнено!");
        return m;
    }

    public static void main(String[] args) {
        MutableMatrix a = null;
        MutableMatrix b = null;
        ImmutableMatrix copyA = null;
        ImmutableMatrix copyB = null;
        Scanner stdin = new Scanner(System.in);
        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println();
            if(a != null) {
                System.out.print("A:");
                a.print();
            }
            if(b != null) {
                System.out.print("B:");
                b.print();
            }
            System.out.println("0. Створити пусті матриці A та B");
            System.out.println("1. Створити матрицю A");
            System.out.println("2. Створити матрицю B");
            System.out.println("3. Зробити копію матриці A");
            System.out.println("4. Зробити копію матриці B");
            System.out.println("5. Порівняти матриці A та B");
            System.out.println("6. Створити матрицю-стовпчик, заповнену випадковими значеннями та записати в A");
            System.out.println("7. Створити матрицю-стовпчик, заповнену випадковими значеннями та записати в B");
            System.out.println("8. Перемножити матриці: AxB");
            System.out.println("9. Перемножити матриці: BxA");
            System.out.println("10. Дістати елемент з матриці А");
            System.out.println("11. Дістати елемент з матриці B");
            System.out.println("12. Замінити елемент в матриці А");
            System.out.println("13. Замінити елемент в матриці B");
            System.out.println("14. Показати останню збережену копію матриці А");
            System.out.println("15. Показати останню збережену копію матриці В");
            System.out.println("16. Вийти з програми");
            System.out.println("Оберіть пункт меню: ");
            int menuNumber = safeReadInt(stdin);
            switch (menuNumber) {
                case 0:
                    a = new MutableMatrix();
                    b = new MutableMatrix();
                    System.out.println("Створено пусті матриці A та B");
                    break;
                case 1:
                    a = createMenu(stdin);
                    break;
                case 2:
                    b = createMenu(stdin);
                    break;
                case 3:
                    if(a != null) {
                        copyA = new ImmutableMatrix(a);
                        System.out.print("Створено копію матриці А");
                    }
                    else {
                        System.out.println("Спочатку створіть матрицю A");
                    }
                    break;
                case 4:
                    if(b != null) {
                        copyB = new ImmutableMatrix(b);
                        System.out.print("Створено копію матриці В");
                    }
                    else {
                        System.out.println("Спочатку створіть матрицю B");
                    }
                    break;
                case 5:
                    if(a == null || b == null) {
                        System.out.println("Спочатку створіть матриці A та B");
                    }
                    else {
                        if(a.equals(b)) {
                            System.out.println("Матриці рівні");
                        }
                        else {
                            System.out.println("Матриці різні");
                        }
                        break;
                    }
                case 6:
                    a = menuGen(stdin);
                    break;
                case 7:
                    b = menuGen(stdin);
                    break;
                case 8:
                {
                    if(a == null || b == null) {
                        System.out.println("Спочатку створіть матриці A та B");
                        break;
                    }
                    MutableMatrix c = new MutableMatrix(a).multiply(b);
                    if(c != null) c.print();
                    else {
                        System.out.println("Помилка при множенні");
                    }
                }
                break;
                case 9:
                {
                    if(a == null || b == null) {
                        System.out.println("Спочатку створіть матриці A та B");
                        break;
                    }
                    MutableMatrix c = new MutableMatrix(b).multiply(a);
                    if(c != null) c.print();
                    else {
                        System.out.println("Помилка при множенні");
                    }
                }
                break;
                case 10:
                    if(a != null) {
                        System.out.print("Задайте номер рядка і стовпчика (нумерація з 1): ");
                        int r = safeReadInt(stdin) - 1;
                        int c = safeReadInt(stdin) - 1;
                        if ((r<a.getRows() && c<a.getCols())&&(r>=0 && c>=0))  {
                            System.out.println("Значення елементу: " + a.getElement(r,c));
                        }
                        else {
                            System.out.println("Задані індекси знаходяться за межами розмірів матриці!");
                        }
                    }
                    else {
                        System.out.println("Спочатку створіть матрицю A");
                    }
                    break;
                case 11:
                    if(b != null) {
                        System.out.print("Задайте номер рядка і стовпчика (нумерація з 1): ");
                        int r = safeReadInt(stdin) - 1;
                        int c = safeReadInt(stdin) - 1;
                        if ((r<b.getRows() && c<b.getCols())&&(r>=0 && c>=0))  {
                            System.out.println("Значення елементу: " + b.getElement(r,c));
                        }
                        else {
                            System.out.println("Задані індекси знаходяться за межами розмірів матриці!");
                        }
                    }
                    else {
                        System.out.println("Спочатку створіть матрицю B");
                    }
                    break;
                case 12:
                    if(a != null) {
                        System.out.print("Задайте номер рядка і стовпчика (нумерація з 1): ");
                        int r = safeReadInt(stdin) - 1;
                        int c = safeReadInt(stdin) - 1;
                        if ((r<a.getRows() && c<a.getCols())&&(r>=0 && c>=0))  {
                            System.out.println("Задайте нове значення елементу: ");
                            double v = safeReadDouble(stdin);
                            a.setElement(r,c,v);
                        }
                        else {
                            System.out.println("Задані індекси знаходяться за межами розмірів матриці!");
                        }
                    }
                    else {
                        System.out.println("Спочатку створіть матрицю A");
                    }
                    break;
                case 13:
                    if(b != null) {
                        System.out.print("Задайте номер рядка і стовпчика (нумерація з 1): ");
                        int r = safeReadInt(stdin) - 1;
                        int c = safeReadInt(stdin) - 1;
                        if ((r<b.getRows() && c<b.getCols())&&(r>=0 && c>=0))  {
                            System.out.println("Задайте нове значення елементу: ");
                            double v = safeReadDouble(stdin);
                            b.setElement(r,c,v);
                        }
                        else {
                            System.out.println("Задані індекси знаходяться за межами розмірів матриці!");
                        }
                    }
                    else {
                        System.out.println("Спочатку створіть матрицю B");
                    }
                    break;
                case 14:
                    if(copyA != null) {
                        System.out.println("Остання копія матриці А: ");
                        copyA.print();
                    }
                    else {
                        System.out.println("Жодної копії матриці А ще не було збережено!");
                    }
                    break;
                case 15:
                    if(copyB != null) {
                        System.out.println("Остання копія матриці B: ");
                        copyB.print();
                    }
                    else {
                        System.out.println("Жодної копії матриці B ще не було збережено!");
                    }
                    break;
                case 16:
                    shouldContinue = false;
                    break;
                default:
                    System.out.println("Обрано неправильний пункт меню!");
                    break;
            }
        }
        System.out.println("Програма завершена");
    }
}
