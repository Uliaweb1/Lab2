import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int safeReadInt(Scanner stdin){
        int a;
        while (true){
            try{
                a = stdin.nextInt();
                break;
            }
            catch (Exception e){
                System.out.println("Помилка вводу, введіть ціле число:");
                stdin.next();
                continue;
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
                continue;
            }
        }
        return a;
    }
    private static MutableMatrix menu1(Scanner stdin){
        MutableMatrix a = new MutableMatrix();
        System.out.println("Створено пусту матрицю");
        a.print();
        return a;
    }
    private static MutableMatrix menu2(Scanner stdin){
        MutableMatrix m;
        System.out.println("Введіть розмірність матриці: ");
        int a = safeReadInt(stdin);
        int b = safeReadInt(stdin);
        m = new MutableMatrix(a,b);
        System.out.println("Створено матрицю фіксованого розміру");
        while(true){
            System.out.println("Оберіть спосіб заповнення матриці: ");
            System.out.println("1.Заповнити вручну");
            System.out.println("2.Заповними випадковими значеннями");
            int menuEntry=safeReadInt(stdin);
            switch (menuEntry){
                case 1:
                    for (int row = 0; row < a; row++) {
                        for (int col = 0; col < b; col++) {
                            System.out.println("Введіть елемент [" + row + "][" + col +"]");
                            m.setElement(row, col, safeReadDouble(stdin));
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < b; i++) {
                        m.setCol(MutableMatrix.genCol(a).getCol(0), i);
                    }
                    break;
                default:
                    System.out.println("Неправильний пункт меню!");
                    continue;
            }
            break;
        }
        m.print();
        return m;
    }
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("1.Створити пусту матрицю");
            System.out.println("2.Створити матрицю фіксованого розміру");
            System.out.println("3.Зробити копію існуючої матриці");
            System.out.println("4.Повернути розмірність матриці");
            System.out.println("5.Порівняти дві матриці");
            System.out.println("6.Створити матрицю-стовпчик, заповнену випадковими значеннями");
            System.out.println("7.Перемножити матриці");
            System.out.println("8.Вийти з програми");
            System.out.println("Оберіть пункт меню: ");
            int menuNumber = safeReadInt(stdin);
            MutableMatrix a;
            switch (menuNumber) {
                case 1:
                    a = menu1(stdin);
                    break;
                case 2:
                    a = menu2(stdin);
                    System.out.println("Введ");
                    break;
                case 3:
                    System.out.println("Пункт 1");
                    break;
                case 4:
                    System.out.println("Пункт 2");
                    break;
                case 5:
                    System.out.println("Пункт 1");
                    break;
                case 6:
                    System.out.println("Пункт 2");
                    break;
                case 7:
                    System.out.println("Пункт 1");
                    break;
                case 8:
                    System.out.println("Пункт 2");
                    break;
                case 9:
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
