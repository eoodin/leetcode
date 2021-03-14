package eoodin.p523;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    public void test1() {
        //Input: [23, 2, 4, 6, 7],  k=6
        //Output: True
        //Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
        //Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
        assertTrue(solution.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
    }

    @Test
    public void test2() {
        assertTrue(solution.checkSubarraySum(new int[]{0, 0}, 0));
    }

    @Test
    public void test3() {
        assertFalse(solution.checkSubarraySum(new int[]{1,0,1,0,1}, 4));
    }


    @Test
    public void performanceTest() {
        int[] nums = new int[5000];
        Arrays.fill(nums, 1);
        nums[4998] = 10001;
        nums[4999] = 10001;
        assertTrue(solution.checkSubarraySum(nums, 20002));

        // full search 5s271ms
        // reuse addition sum in inner loop: 46ms
        // DP 17ms
    }
}