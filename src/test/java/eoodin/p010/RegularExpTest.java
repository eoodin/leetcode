package eoodin.p010;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegularExpTest {
    private RegularExp solution;

    @Before
    public void setup() {
        solution = new RegularExp();
    }

    @Test
    public void test1() {
        assertFalse(solution.isMatch("aa", "a"));
    }

    @Test
    public void test2() {
        assertTrue(solution.isMatch("aa", "a*"));
    }

    @Test
    public void test3() {
        assertTrue(solution.isMatch("ab", ".*"));
    }

    @Test
    public void test4() {
        assertTrue(solution.isMatch("aab", "c*a*b"));
    }

    @Test(timeout = 50)
    public void test5() {
        assertFalse(solution.isMatch("mississippi", "mis*is*p*"));
    }
}
