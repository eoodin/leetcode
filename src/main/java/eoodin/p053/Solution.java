package eoodin.p053;

public class Solution {

    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int sv;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < 0 && sum > nums[i]) {
                continue;
            }

            sv = 0;
            for (int j = i; j < nums.length; j++) {
                sv += nums[j];
                if (sv >= sum) {
                    sum = sv;
                }
            }
        }

        return sum;
    }
}
