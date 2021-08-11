package eoodin.top;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayTest {

    @Test
    public void testRemoveDuplicates1() {
        assertRemoveDuplicates(new int[]{1, 1, 2}, new int[]{1, 2});
    }

    private void assertRemoveDuplicates(int[] nums, int[] expectedNums) {
        int k = Array.removeDuplicates(nums);

        assertEquals(expectedNums.length, k);
        for (int i = 0; i < k; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
    }

    @Test
    public void testMaxProfits() {
        assertEquals(7, Array.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(7, Array.maxProfit(new int[]{7, 1, 5, 5, 5, 3, 6, 4}));
        assertEquals(7, Array.maxProfit(new int[]{7, 1, 2, 4, 5, 3, 6, 4}));
        assertEquals(4, Array.maxProfit(new int[]{1, 2, 3, 4, 5}));
        assertEquals(0, Array.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }


    @Test
    public void testRotateArray() {
        assertRotateArray(new int[]{5, 6, 7, 1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        assertRotateArray(new int[]{3, 99, -1, -100}, new int[]{-1, -100, 3, 99}, 2);
    }

    private void assertRotateArray(int[] expecteds, int[] nums, int k) {
        Array.rotate(nums, k);
        assertArrayEquals(expecteds, nums);
    }

    @Test
    public void testContainsDuplicate() {
        assertTrue(Array.containsDuplicate(new int[]{1, 2, 3, 1}));
        assertFalse(Array.containsDuplicate(new int[]{1, 2, 3, 4}));
        assertTrue(Array.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    @Test
    public void testIntersect() {
//        [4,9,5], nums2 = [9,4,9,8,4]
//        assertArrayEquals(new int[]{2, 2}, Array.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        assertArrayEquals(new int[]{4, 9}, Array.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }

    @Test
    public void testPlusOne() {
        assertArrayEquals(new int[]{1, 2, 4}, Array.plusOne(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{1, 0, 0, 0}, Array.plusOne(new int[]{9, 9, 9}));
    }

    @Test
    public void testMoveZeroes() {
        int[] nums = {0, 1, 0, 3, 12};
        Array.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
        nums = new int[]{0};
        Array.moveZeroes(nums);
        assertArrayEquals(new int[]{0}, nums);
        nums = new int[]{2, 1};
        Array.moveZeroes(nums);
        assertArrayEquals(new int[]{2, 1}, nums);
    }

    @Test
    public void testTwoSum() {
        assertArrayEquals(new int[]{0, 1}, Array.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 2}, Array.twoSum(new int[]{3, 2, 4}, 6));
    }


    @Test
    public void testIsValidSudoku() {
        assertTrue(Array.isValidSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
        }));
        assertFalse(Array.isValidSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','8','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
        }));

        assertFalse(Array.isValidSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','1','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
        }));

        assertFalse(Array.isValidSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','7','.','.','8','.','.','7','9'},
        }));
    }

    @Test
    public void testRotate() {
        int[][] matrix = {
                {5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}
        };
        Array.rotate(matrix);
        assertArrayEquals(new int[][]{
                {15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}
        }, matrix);

        matrix = new int[][]{{1}};
        Array.rotate(matrix);
        assertArrayEquals(new int[][]{{1}}, matrix);
        matrix = new int[][]{{1, 2}, {3, 4}};
        Array.rotate(matrix);
        assertArrayEquals(new int[][]{{3, 1}, {4, 2}}, matrix);
    }

}
