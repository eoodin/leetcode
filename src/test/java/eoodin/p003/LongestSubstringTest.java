package eoodin.p003;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestSubstringTest {

    private LongestSubstring solution;

    @Before
    public void setup() {
        solution = new LongestSubstring();
    }

    @Test
    public void test1() {
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
        assertEquals(1, solution.lengthOfLongestSubstring("c"));
        assertEquals(2, solution.lengthOfLongestSubstring("au"));
    }
}
