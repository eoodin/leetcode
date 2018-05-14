package eoodin.p007;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseIntegerTest {
    private ReverseInteger solution;

    @Before
    public void setup() {
        solution = new ReverseInteger();
    }

    @Test
    public void test1() {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        assertEquals(321, solution.reverse(123));
    }

    @Test
    public void test2() {
        assertEquals(-321, solution.reverse(-123));
    }

    @Test
    public void test3() {
        assertEquals(21, solution.reverse(120));
    }

    @Test
    public void test4() {
        assertEquals(0, solution.reverse(2147483647));
    }

    @Test
    public void test5() {
        assertEquals(0, solution.reverse(-2147483648));
    }

    @Test
    public void test6() {
        assertEquals(0, solution.reverse(1534236469));
    }

    @Test
    public void test7() {
        assertEquals(1, solution.reverse(10));
    }

}
