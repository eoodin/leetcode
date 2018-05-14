package eoodin.p004;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FindMedianTest {

    private FindMedian solution;

    @Before
    public void setup() {
        solution = new FindMedian();
    }

    @Test
    public void test1() {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        double result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void test2() {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};

        double result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.5, result, 0.0001);
    }


    @Test
    public void testMergeSort() {
        int[] ns1 = new int[]{6, 100, 202, 301};
        int[] ns2 = new int[]{1, 8, 38};
        int[] merged = solution.mergeSort(ns1, ns2);
        int[] expected = new int[]{1, 6, 8, 38, 100, 202, 301};
        assertArrayEquals(expected, merged);
    }
}
