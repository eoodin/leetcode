package eoodin.p523;

import java.util.Arrays;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sums = Arrays.stream(Arrays.copyOf(nums, nums.length)).toArray();
        if (k == 0) {
            for (int i = nums.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    int s = sums[j] + nums[j + nums.length - i];
                    if (s == 0) {
                        return true;
                    }
                    sums[j] = s;
                }
            }
        } else {
            for (int i = nums.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    int s = sums[j] + nums[j + nums.length - i];
                    if (s % k == 0) {
                        return true;
                    }
                    sums[j] = s;
                }
            }
        }

        return false;
    }
}
