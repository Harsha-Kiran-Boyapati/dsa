package dsa.leetcode150.arrays.twoPointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrappingRainWaterTest {

    @Test
    void test1() {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int expected = 6;
        int actual = new TrappingRainWater().trap(height);
        assertEquals(expected,actual);
    }
}