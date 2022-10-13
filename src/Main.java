import java.util.Scanner;

public class Main {
    private static int safeReadInt(Scanner stdin){
        int a;
        while (true){
            try{
                a = stdin.nextInt();
                if (a < 0) {
                    System.out.println("Введено відьємне число, введить невідьємне:");
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

    private static ImmutableMatrix menuGen(Scanner stdin){
        System.out.println("Введіть кількість єлементів у стовпчику: ");
        int n = safeReadInt(stdin);
        ImmutableMatrix a = ImmutableMatrix.genCol(n);
        System.out.println("Створено пусту матрицю");
        return a;
    }

    private static ImmutableMatrix createMenu(Scanner stdin){
        System.out.println("Введіть розмірність матриці: ");
        int a = safeReadInt(stdin);
        int b = safeReadInt(stdin);
        MutableMatrix m = new MutableMatrix(a,b);
        System.out.println("Створено матрицю фіксованого розміру");
        while(true){
            System.out.println("Оберіть спосіб заповнення матриці: ");
            System.out.println("1.Заповнити вручну");
            System.out.println("2.Заповними випадковими значеннями");
            System.out.println("3.Заповними нулями");
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
                case 3:
                    System.out.println("Створено матрицю заповнену нулями");
                    return new ImmutableMatrix(a, b);
                default:
                    System.out.println("Неправильний пункт меню!");
                    continue;
            }
            break;
        }
        System.out.println("Матріцю створено та заповнено!");
        return new ImmutableMatrix(m);
    }

    public static void main(String[] args) {
        ImmutableMatrix a = null;
        ImmutableMatrix b = null;
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
            System.out.println("3. Зробити копію матриці A та записати в B");
            System.out.println("4. Зробити копію матриці B та записати в A");
            System.out.println("5. Порівняти матриці A та B");
            System.out.println("6. Створити матрицю-стовпчик, заповнену випадковими значеннями та записати в A");
            System.out.println("7. Створити матрицю-стовпчик, заповнену випадковими значеннями та записати в B");
            System.out.println("8. Перемножити матриці: AxB");
            System.out.println("9. Перемножити матриці: BxA");
            System.out.println("10. Вийти з програми");
            System.out.println("Оберіть пункт меню: ");
            int menuNumber = safeReadInt(stdin);
            switch (menuNumber) {
                case 0:
                    a = new ImmutableMatrix();
                    b = new ImmutableMatrix();
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
                        b = new ImmutableMatrix(a);
                        System.out.print("Створено матрицю B - копию матрици A");
                    }
                    else {
                        System.out.println("Спочатку створіть матрицю A");
                    }
                    break;
                case 4:
                    if(b != null) {
                        a = new ImmutableMatrix(b);
                        System.out.print("Створено матрицю A - копию матрици B");
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
                        System.out.println("Помілка при множенні");
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
                        System.out.println("Помілка при множенні");
                    }
                }
                break;
                case 10:
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
