package eoodin.top;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Array {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int p = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[p - 1] != nums[i]) {
                nums[p++] = nums[i];
            }
        }

        return p;
    }


    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int profit = 0;
        int boughtPrice = -1;
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            if (boughtPrice > -1) { // bought
                if (diff <= 0) { // sell
                    profit += prices[i] - boughtPrice;
                    boughtPrice = -1;
                }
            } else { // not bought
                if (diff > 0) { // buy
                    boughtPrice = prices[i];
                }
            }
        }
        if (boughtPrice > -1) { // hold to last
            profit += prices[prices.length - 1] - boughtPrice;
        }

        return profit;
    }

    // https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
    public static void rotate(int[] nums, int k) {
        int d = k % nums.length;
        if (d == 0) return;
        // reverse array
        for (int i = 0, len = nums.length; i < len / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[len - i - 1];
            nums[len - i - 1] = tmp;
        }

        // reverse left sub array
        for (int i = 0; i < d / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[d - i - 1];
            nums[d - i - 1] = tmp;
        }
        // reverse right sub array
        for (int i = 0, len = nums.length, m = (len - d) / 2; i < m; i++) {
            int tmp = nums[d + i];
            nums[d + i] = nums[len - i - 1];
            nums[len - i - 1] = tmp;
        }
    }

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> bs = new HashMap<>(nums.length);

        for (int num : nums) {
            if (bs.get(num)) {
                return true;
            }

            bs.put(num, true);
        }
        return false;
    }

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] results = new int[Math.min(nums1.length, nums2.length)];
        int i = 0, j = 0, count = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                results[count++] = nums1[i];
                i++;
                j++;
            }
        }

        return Arrays.copyOf(results, count);
    }

    public static int[] plusOne(int[] digits) {
        int n = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            n = ++digits[i];
            if (n < 10) break;
            digits[i] = n - 10;
        }

        if (n > 9) {
            int[] results = new int[digits.length + 1];
            results[0] = 1;
            System.arraycopy(digits, 0, results, 1, digits.length);
            return results;
        }

        return digits;
    }

    // https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/
    public static void moveZeroes(int[] nums) {
        int zCount = 0;
        for (int num : nums) {
            if (num == 0) zCount++;
        }
        if (zCount == 0)
            return;

        int pi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (pi != i) {
                    nums[pi] = nums[i];
                }
                pi++;
            }
        }
        for (int i = nums.length - zCount; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            int need = target - nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == need) {
//                    return new int[]{i, j};
//                }
//            }
//        }

        HashMap<Integer, Integer> numIndexes = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            numIndexes.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer idx = numIndexes.get(target - nums[i]);
            if (null != idx && idx != i) {
                return new int[]{i, idx};
            }
        }

        return new int[]{0, 0};
    }

    public static boolean isValidSudoku(char[][] board) {
        // check block
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean[] hasDigits = new boolean[9];
                for (int k = 3 * i; k < 3 * (i + 1); k++) {
                    for (int l = 3 * j; l < 3 * (j + 1); l++) {
                        char n = board[k][l];
                        if (n == '.') continue;

                        if (hasDigits[n - '0' - 1]) {
                            return false;
                        }
                        hasDigits[n - '0' - 1] = true;
                    }
                }
            }
        }

        // check row and column
        for (int i = 0; i < 9; i++) {
            boolean[] hasDigits = new boolean[9];
            for (int j = 0; j < 9; j++) {
                char n = board[i][j];
                if (n == '.') continue;

                if (hasDigits[n - '0' - 1]) {
                    return false;
                }
                hasDigits[n - '0' - 1] = true;
            }
        }

        for (int i = 0; i < 9; i++) {
            boolean[] hasDigits = new boolean[9];
            for (int j = 0; j < 9; j++) {
                char n = board[j][i];
                if (n == '.') continue;

                if (hasDigits[n - '0' -1]) {
                    return false;
                }
                hasDigits[n - '0' - 1] = true;
            }
        }

        return true;
    }

    public static void rotate(int[][] matrix) {
        int size = matrix.length;
        for (int layer = 0; layer < size / 2; layer++) {
            for (int i = 0; i < size - layer * 2 - 1; i++) {
                int startx = layer + i;
                // left to top
                int t = matrix[layer][startx];
                matrix[layer][startx] = matrix[size - layer - i - 1][layer];
                // bottom to left
                matrix[size - layer - i - 1][layer] = matrix[size - layer - 1][size - layer - i - 1];
                // right to bottom
                matrix[size - layer - 1][size - layer - i - 1] = matrix[layer + i][size - layer - 1];
                matrix[layer + i][size - layer - 1] = t;
            }
        }
    }
}
