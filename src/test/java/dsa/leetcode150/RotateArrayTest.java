package dsa.leetcode150;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateArrayTest {

    @Test
    void rotate() {
        int[] nums1 = {0,1,2,3,4};
        new RotateArray().rotate(nums1, 2);
        int[] exp1 = {3,4,0,1,2};
        //{4,3,2,1,0}
        //{3,4,0,1,2}

        assertArrayEquals(exp1, nums1);
    }

    @Test
    void rotate2() {
        int[] nums1 = {0,1,2,3,4};
        int[] exp1 = {2, 3,4,0,1};
        new RotateArray().rotate(nums1, 3);
        assertArrayEquals(exp1, nums1);
    }
}