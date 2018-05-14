package eoodin.p006;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZigZagStringTest {

    private ZigZagString solution;

    @Before
    public void setup() {
        solution = new ZigZagString();
    }

    @Test
    public void test1() {
        assertEquals("PAHNAPLSIIGYIR", solution.convert("PAYPALISHIRING", 3));
    }

    @Test
    public void test2() {
        assertEquals("PINALSIGYAHRPI", solution.convert("PAYPALISHIRING", 4));
    }

    @Test
    public void test4() {
        assertEquals("PAHNAPLSIIGYIR", solution.convert("PAHNAPLSIIGYIR", 1));
    }

    @Test
    public void test5() {
        assertEquals("PAHNAPLSIIGYIR", solution.convert("PAHNAPLSIIGYIR", 100));
    }
}
