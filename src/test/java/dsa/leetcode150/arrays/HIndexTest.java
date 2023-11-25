package dsa.leetcode150.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HIndexTest {

    @Test
    void hIndex() {
        int[] nums = {3,0,6,1,5};
        assertEquals(3, new HIndex().hIndex(nums));
        assertEquals(0, new HIndex().hIndex(new int[]{}));
        assertEquals(1, new HIndex().hIndex(new int[]{1,3,1}));
        assertEquals(1, new HIndex().hIndex(new int[]{100}));

    }
}