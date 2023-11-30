package dsa.leetcode150.arrays;

import dsa.leetcode150.arrays.MergeSortedArrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedArraysTest {

    @Test
    void merge() {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = {1, 4,6};
        new MergeSortedArrays().merge(nums1, 3, nums2, 3);
        assertEquals(6, nums1[5]);
        assertEquals(4, nums1[4]);
        assertEquals(1, nums1[1]);
    }
}