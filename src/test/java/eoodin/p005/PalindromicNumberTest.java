package eoodin.p005;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PalindromicNumberTest {

    private PalindromicNumber solution;

    @Before
    public void setup() {
        solution = new PalindromicNumber();
    }

//    @Test
//    public void p1() {
//        assertTrue(solution.isPalindromic("a".toCharArray(), 0, 0));
//        assertTrue(solution.isPalindromic("aa".toCharArray(), 0, 1));
//        assertTrue(solution.isPalindromic("aba".toCharArray(), 0, 2));
//        assertTrue(solution.isPalindromic("abcba".toCharArray(), 0, 4));
//        assertTrue(solution.isPalindromic("ssabcba".toCharArray(), 2, 6));
//    }

    @Test
    public void test1() {
        assertThat(Arrays.asList("bab", "aba"), hasItem(solution.longest("babad")));
    }

    @Test
    public void test2() {
        assertEquals("bb", solution.longest("cbbd"));
    }

    @Test
    public void test3() {
        assertEquals("abcba", solution.longest("abcba"));
    }
}
