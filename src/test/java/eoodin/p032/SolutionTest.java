package eoodin.p032;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test0() {
        assertEquals(0, solution.longestValidParentheses(""));
        assertEquals(2, solution.longestValidParentheses("(()"));
        assertEquals(4, solution.longestValidParentheses(")()())"));
    }
}
