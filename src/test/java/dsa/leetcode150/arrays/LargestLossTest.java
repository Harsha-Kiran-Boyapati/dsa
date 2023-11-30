package dsa.leetcode150.arrays;

import dsa.others.arrays.LargestLoss;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestLossTest {

    @Test
    void test1() {
        int[] prices = new int[]{5, 2, 3, 7, 6, 8};
        assertEquals(2, new LargestLoss().solve(prices));
    }

    @Test
    void test2() {
        int[] prices = new int[]{5, 2, 3, 7, 6, 1, 8};
        assertEquals(5, new LargestLoss().solve(prices));
    }
}