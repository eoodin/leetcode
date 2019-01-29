package eoodin.p097;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isInterleave("ab", "cd", "acdb"));
        assertTrue(s.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        assertFalse(s.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
