package eoodin.rectanglearea;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        int output = new Solution().rectangleArea(new int[][]{{0, 0, 2, 2}, {1, 0, 2, 3}, {1, 0, 3, 1}});
        Assert.assertEquals(6, output);
    }
}
