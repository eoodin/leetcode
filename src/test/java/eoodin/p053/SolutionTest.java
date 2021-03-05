package eoodin.p053;

import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void test0() {
        int[] nums = new int[]{-2};
        assertEquals(-2, new Solution().maxSubArray(nums));
    }

    @Test
    public void test1() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, new Solution().maxSubArray(nums));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{-1,-2};
        assertEquals(-1, new Solution().maxSubArray(nums));
    }

    @Test
    @Ignore("produces test cases")
    public void test3() throws IOException {
        Random random = new Random();
        int size = 100000;
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = random.nextInt() % 100;
        }
        int result = new Solution().maxSubArray(nums);
        System.out.println(result);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("./100k_nums.dat"))) {
            outputStream.writeObject(nums);
            outputStream.writeInt(result);
        }
    }

    @Test
    public void test4() throws IOException, ClassNotFoundException {
        int []nums;
        int result;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("./100k_nums.dat"))) {
            nums = (int[])inputStream.readObject();
            result = inputStream.readInt();
        }

        assertEquals(result, new Solution().maxSubArray(nums));
    }
}
