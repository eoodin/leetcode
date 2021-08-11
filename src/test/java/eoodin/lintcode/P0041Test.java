package eoodin.lintcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P0041Test {
    @Test
    public void test1() {
        assertEquals(6, new P0041().maxSubArray(new int[]{-2, 2, -3, 4, -1, 2, 1, -5, 3}));
    }

    @Test
    public void test2() {
        assertEquals(10, new P0041().maxSubArray(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void test3() {
        assertEquals(-1, new P0041().maxSubArray(new int[]{-1}));
    }

    @Test
    public void test4() {
        assertEquals(5, new P0041().maxSubArray(new int[]{5, -10, 4}));
    }
    @Test
    public void test5() {
        assertEquals(6, new P0041().maxSubArray(new int[]{-2,2,-3,4,-1,2,1,-5,3}));
    }
}
