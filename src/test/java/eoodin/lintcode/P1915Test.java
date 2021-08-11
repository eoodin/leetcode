package eoodin.lintcode;

import org.junit.Test;

import java.util.BitSet;

import static org.junit.Assert.assertEquals;

public class P1915Test {
    @Test
    public void problem1915() {
        P1915 solutions = new P1915();
//        assertEquals(6, solutions.weightCapacity(new int[]{1, 3, 5}, 7));
//        assertEquals(6, solutions.weightCapacity(new int[]{1, 3, 5}, 6));
//        assertEquals(3, solutions.weightCapacity(new int[]{3}, 6));
//        assertEquals(0, solutions.weightCapacity(new int[]{7}, 6));

        int[] weights = new int[]{67356,233900,982590,372879,415998,461941,98935,239287,433413,36109,887779,857424,928267,49000,321030,230551,332083,580018,932293,851765,688961,989160,222830,425340,21042,386203,878017,246204,194031,837181,87247,909684,26518,908975,361664,213872,744761,278193,434280,60833};
        assertEquals(236478, solutions.weightCapacity(weights, 237733));
//        int[] weights = new int[]{5,8,9,7,10,8,7,6,6,7,8,4,7,9,6,7,5,5,8,8,4,3,9,5,2,5,8,3,5,4,7,2,3,4,4,4,10,3,5,6,8,6,9,10,8,10,6,3,9,7,9,5,9,7,3,4,7,4,1,5,9,2,2,8,1,6,10,9,1,3,4,10,1,9,8,3,5,1,8,5,10,8,6,5,3,4,3,9,9,6,5,4,2,7,2,4,6,7,7,2};
//        System.out.println(weights.length);
//        assertEquals(580, solutions.weightCapacity(weights, 1000));
    }

    @Test
    public void testBitSet() {
        BitSet bs = new BitSet(12);
        bs.set(8);
        bs.set(3);
        System.out.println(bs);
    }
}
