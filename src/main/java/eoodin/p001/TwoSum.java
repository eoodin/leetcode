package eoodin.p001;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        return standard1(nums, target);
    }

    private int[] sol1(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return null;

        for (int first = 0; first < nums.length - 1; ++first) {
            for (int second = first + 1; second < nums.length; ++second) {
                if (nums[first] + nums[second] == target)
                    return new int[]{first, second};
            }
        }
        return null;
    }

    private int[] sol2(int[] nums, int target) {
        int[] small = new int[nums.length];
        int[] big = new int[nums.length];

        int half = target/2;
        int si = 0, bi = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= half)
                small[si++]=i;
            else
                big[bi++]=i;
        }

        for (int sii = 0; sii < si; ++sii) {
            for (int bii = 0; bii < bi; ++bii) {
                if (nums[small[sii]] + nums[big[bii]] == target)
                    return new int[]{small[sii], big[bii]};
            }
        }

        for (int ss = 0; ss < si - 1; ss++) {
            for (int se = ss + 1; se < si; se++) {
                if (nums[small[ss]] + nums[small[se]] == target) {
                    int n1 = small[ss];
                    int n2 = small[se];
                    return new int[]{Math.min(n1, n2), Math.max(n1, n2)};
                }
            }
        }

        return null;
    }

    private int[] sol3(int[] nums, int target) {
        Map<Integer, int[]> num2indecies = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int[] idx = num2indecies.get(nums[i]);
            if (idx == null) {
                idx = new int[]{i, -1};
                num2indecies.put(nums[i], idx);
            }
            else {
                idx[1] = i;
            }
        }

        for (int i = 0; i <= nums.length; i++) {
            int num = nums[i];
            int[] i1 = num2indecies.get(num);
            if (i1 != null) {
                int[] i2 = num2indecies.get(target - num);
                if (i2 != null) {
                    if (i1 == i2 && i1[1] == -1)
                        continue;
                    if (i1 == i2)
                        return new int[]{Math.min(i1[0], i1[1]), Math.max(i1[0], i1[1])};
                    return new int[] {Math.min(i1[0], i2[0]), Math.max(i1[0], i2[0])};
                }
            }
        }
        return null;
    }

    private int[] standard1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");

    }
}
