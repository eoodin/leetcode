package eoodin.p001;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumTest {

    private TwoSum solution;

    @Before
    public void setup() {
        solution = new TwoSum();
    }

    @Test
    public void test1() {
        int[] sol = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertNotNull(sol);
        assertEquals(0, sol[0]);
        assertEquals(1, sol[1]);
    }

    @Test
    public void disorderTest() {
        int[] sol = solution.twoSum(new int[]{15, 2, 11, 7}, 9);
        assertNotNull(sol);
        assertEquals(1, sol[0]);
        assertEquals(3, sol[1]);
    }

    @Test
    public void test2() {
        int[] sol = solution.twoSum(new int[]{3, 2, 4}, 6);
        assertEquals(1, sol[0]);
        assertEquals(2, sol[1]);
    }

    @Test
    public void test3() {
        int[] sol = solution.twoSum(new int[]{3, 3}, 6);
        assertEquals(0, sol[0]);
        assertEquals(1, sol[1]);
    }

    @Test
    public void test4() {
        int[] sol = solution.twoSum(new int[]{-3, 4, 3, 90}, 0);
        assertEquals(0, sol[0]);
        assertEquals(2, sol[1]);

    }
}
