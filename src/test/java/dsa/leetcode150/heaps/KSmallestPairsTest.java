package dsa.leetcode150.heaps;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KSmallestPairsTest {

    @Test
    public void test(){
        int[] nums1 = new int[] { 1, 7, 11};
        int[] nums2 = new int[] { 2, 4, 6};
        List<List<Integer>> ans = new KSmallestPairs().kSmallestPairs(nums1, nums2, 3);
    }

}