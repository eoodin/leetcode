package eoodin.lintcode;

public class P0041 {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = 0;
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            if (min > sum)
                min = Math.max(0, sum);

            if (max < sum)
                max = sum;
        }

        return max - min;
    }
}
