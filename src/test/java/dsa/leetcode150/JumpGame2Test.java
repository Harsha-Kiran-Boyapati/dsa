package dsa.leetcode150;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpGame2Test {

    @Test
    void jump() {
        int[] nums = {2,3,1,1,4};
        assertEquals(2, new JumpGame2().jump(nums));

        assertEquals(0, new JumpGame2().jump(new int[]{1}));

    }
}