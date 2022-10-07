import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MutableMatrix a1,b,c;
        ImmutableMatrix a2;
        a1 = new MutableMatrix();
        a2 = new ImmutableMatrix ();
        b = new MutableMatrix (3,4);
        c = new MutableMatrix (b);
        b.setElement(0,1, 1.0);
        c.setElement(1,2,2.0);
        c.setCol(new double[]{1.0, 2.0, 3.0},3);
        c.setRow(new double[]{1.0, 2.0, 3.0, 6.0},2);
        System.out.println("a1 and a2:");
        a1.print();
        a2.print();
        System.out.println("b:");
        b.print();
        System.out.println("c:");
        c.print();
        System.out.println(Arrays.toString(c.getCol(2)));
        System.out.println(Arrays.toString(c.getRow(2)));
        System.out.println(c.equals(b));
        System.out.println("d: ");
        ImmutableMatrix d = new ImmutableMatrix (4,4);
        d.print();
        System.out.println("e: ");
        MutableMatrix e = MutableMatrix.genCol(5);
        e.print();
        System.out.println("e2: ");
        ImmutableMatrix e2 = ImmutableMatrix.genCol(5);
        e2.print();
        ImmutableMatrix f1 = new ImmutableMatrix(new MutableMatrix(3,1).setCol(new double[]{1, 2, 3},0));
        ImmutableMatrix f2 = new ImmutableMatrix(new MutableMatrix(1,3).setRow(new double[]{1, 2, 3},0));
        MutableMatrix res1 = new MutableMatrix (f1);
        MutableMatrix res2 = new MutableMatrix (f2);
        res1.multiply(f2);
        res2.multiply(f1);
        System.out.println("res1: ");
        res1.print();
        System.out.println("res2: ");
        res2.print();
        MutableMatrix g = new MutableMatrix(3,3);
        g.setCol(new double[]{1,0,0},2);
        g.setCol(new double[]{0,1,0},1);
        g.setCol(new double[]{0,0,1},0);
        g.multiply(f1).multiply(f2).print();
    }
}