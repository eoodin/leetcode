package eoodin.p850;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void exampleTest() {
        Solution solution = new Solution();
        Assert.assertEquals(6, solution.rectangleArea(new int[][]{{0, 0, 2, 2}, {1, 0, 2, 3}, {1, 0, 3, 1}}));
        Assert.assertEquals(49, solution.rectangleArea(new int[][]{{0, 0, 1000000000, 1000000000}}));
    }
}
