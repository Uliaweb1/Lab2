public class Main {
    public static void main(String[] args) {
        Matrix a,b,c;
        a = new Matrix();
        b = new Matrix(3,4);
        c = new Matrix(b);
        System.out.println("a:");
        a.output();
        System.out.println("b:");
        b.output();
        System.out.println("c:");
        c.output();
    }
}