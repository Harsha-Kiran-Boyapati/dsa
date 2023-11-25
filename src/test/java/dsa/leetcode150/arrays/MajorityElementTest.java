package dsa.leetcode150.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MajorityElementTest {

    @Test
    void majorityElement() {
        int[] nums1 = {1, 1, 1, 2,3,4,1};
        assertEquals(1, new MajorityElement().majorityElement(nums1));

        int[] nums2 = {2,2,1,1, 1, 2,2};
        assertEquals(2, new MajorityElement().majorityElement(nums2));
    }

    @Test
    void binaryString() {
        String bits = Integer.toBinaryString(1);
        assertEquals("1", String.format("2s", 2));
//        System.out.println(bits);
    }
}