import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MutableMatrix a,b,c;
        a = new MutableMatrix ();
        b = new MutableMatrix (3,4);
        c = new MutableMatrix (b);
        b.setElement(0,1, 1.0);
        c.setElement(1,2,2.0);
        c.setCol(new double[]{1.0, 2.0, 3.0},3);
        c.setRow(new double[]{1.0, 2.0, 3.0, 6.0},2);
        System.out.println("a:");
        a.print();
        System.out.println("b:");
        b.print();
        System.out.println("c:");
        c.print();
        System.out.println(Arrays.toString(c.getCol(2)));
        System.out.println(Arrays.toString(c.getRow(2)));
        System.out.println(c.equals(b));
        ImmutableMatrix d = new ImmutableMatrix (4,4);
        System.out.println("d: ");
        d.print();
        MutableMatrix e = MutableMatrix.genCol(5);
        System.out.println("e: ");
        e.print();
        MutableMatrix f1 = new MutableMatrix(3,1);
        MutableMatrix f2 = new MutableMatrix(1,3);
        f1.setCol(new double[]{1, 2, 3},0);
        f2.setRow(new double[]{1, 2, 3},0);
        MutableMatrix res1 = new MutableMatrix (f1);
        MutableMatrix res2 = new MutableMatrix (f2);
        res1.multiply(f2);
        res2.multiply(f1);
        System.out.println("res1: ");
        res1.print();
        System.out.println("res2: ");
        res2.print();
    }
}