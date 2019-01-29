package eoodin.p763;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void exampleTest() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(9, 7, 8), s.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
