package dsa.leetcode150;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveElementTest {

    @Test
    void removeElement() {
        int[] nums1 = {1,3,2,4,2,5};
        int[] nums2 = {1,3,2,4,2,5};

        int res1 = new RemoveElement().removeElement(nums1, 2);
        assertEquals(4, res1);

        assertNotEquals(2, nums1[0]);
        assertNotEquals(2, nums1[1]);
        assertNotEquals(2, nums1[2]);
        assertNotEquals(2, nums1[3]);

        int res2 = new RemoveElement().removeElement(nums2, 6);
        assertEquals(6, res2);
        assertEquals(5, nums2[5]);
        assertEquals(2, nums2[2]);

        int[] nums3 = {1,1, 1};
        int res3 = new RemoveElement().removeElement(nums3, 1);
        assertEquals(0, res3);




    }
}