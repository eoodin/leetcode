package eoodin.maxdistance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
//        assertEquals(2, solution.maxDistToClosest(new int[]{1, 0, 0, 0, 1}));
        assertEquals(3, solution.maxDistToClosest(new int[]{1, 0, 0, 0}));
        assertEquals(1, solution.maxDistToClosest(new int[]{1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1}));
//        assertEquals(0, solution.maxDistToClosest(new int[]{0, 0, 1, 0, 1}));
//        assertEquals(8, solution.maxDistToClosest(new int[]{1, 0, 0, 1, 0, 1, 0, 0, 0}));
    }
}
