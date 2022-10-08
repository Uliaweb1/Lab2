import static org.junit.jupiter.api.Assertions.*;

class MutableMatrixTest {

    @org.junit.jupiter.api.Test
    void getCols() {
        MutableMatrix a = new MutableMatrix(3,4);
        assertEquals(4, a.getCols());
        MutableMatrix b = new MutableMatrix();
        assertEquals(0, b.getCols());
    }

    @org.junit.jupiter.api.Test
    void setSize() {
        MutableMatrix a = new MutableMatrix();
        a.setSize(3,4);
        assertEquals(4, a.getCols());
        assertEquals(3, a.getRows());
    }

    @org.junit.jupiter.api.Test
    void getRows() {
        MutableMatrix a = new MutableMatrix(3,4);
        assertEquals(3, a.getRows());
        MutableMatrix b = new MutableMatrix();
        assertEquals(0, b.getRows());
    }

    @org.junit.jupiter.api.Test
    void getElement() {
        MutableMatrix a = new MutableMatrix(3,4);
        assertEquals(0, a.getElement(2,3));
    }

    @org.junit.jupiter.api.Test
    void setElement() {
        MutableMatrix a = new MutableMatrix(3,4);
        a.setElement(2,3,10.0);
        assertEquals(10.0, a.getElement(2,3));
    }

    @org.junit.jupiter.api.Test
    void getRow() {
        MutableMatrix a = new MutableMatrix(3,4);
        assertArrayEquals(new double[]{0, 0, 0, 0}, a.getRow(0));
    }

    @org.junit.jupiter.api.Test
    void getCol() {
        MutableMatrix a = new MutableMatrix(3,4);
        assertArrayEquals(new double[]{0, 0, 0}, a.getCol(0));
    }

    @org.junit.jupiter.api.Test
    void setCol() {
        MutableMatrix a = new MutableMatrix(3,4);
        a.setCol(new double[]{1,2,3},1);
        assertArrayEquals(new double[]{1,2,3}, a.getCol(1));
    }

    @org.junit.jupiter.api.Test
    void setRow() {
        MutableMatrix a = new MutableMatrix(3,4);
        a.setRow(new double[]{1,2,3,4},1);
        assertArrayEquals(new double[]{1,2,3,4}, a.getRow(1));
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        MutableMatrix a = new MutableMatrix(3,4);
        MutableMatrix b = new MutableMatrix(a);
        assertEquals(a, b);
        b.setRow(new double[]{1,2,3,4},1);
        assertNotEquals(a, b);
        b = new MutableMatrix(3,4);
        assertEquals(a, b);
        b = new MutableMatrix(4,3);
        assertNotEquals(a, b);
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
        MutableMatrix a = new MutableMatrix(3,4);
        MutableMatrix b = new MutableMatrix(a);
        assertSame(a.hashCode(), b.hashCode());
        b = new MutableMatrix(3,4);
        assertSame(a.hashCode(), b.hashCode());
    }

    @org.junit.jupiter.api.Test
    void genCol() {
        MutableMatrix a = MutableMatrix.genCol(5);
        MutableMatrix b = MutableMatrix.genCol(5);
        assertNotEquals(a,b);
        assertEquals(5,a.getRows());
        assertEquals(1,a.getCols());
        assertEquals(5,b.getRows());
        assertEquals(1,b.getCols());
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        MutableMatrix a = new MutableMatrix(1,3);
        MutableMatrix b = new MutableMatrix(3,1);
        a.setRow(new double[]{1,2,3},0);
        b.setCol(new double[]{4,5,6},0);
        MutableMatrix e = new MutableMatrix(1,1);
        e.setCol(new double[]{32},0);
        MutableMatrix f = new MutableMatrix(3,3);
        f.setRow(new double[]{4,8,12},0);
        f.setRow(new double[]{5,10,15},1);
        f.setRow(new double[]{6,12,18},2);
        MutableMatrix c = new MutableMatrix(a);
        MutableMatrix d = new MutableMatrix(b);
        assertEquals(e,c.multiply(b));
        assertEquals(f,d.multiply(a));
    }
}