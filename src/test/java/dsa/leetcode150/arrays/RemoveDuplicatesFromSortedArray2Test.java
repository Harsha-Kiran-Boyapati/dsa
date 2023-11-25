package dsa.leetcode150.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromSortedArray2Test {

    @Test
    public void removeDuplicates(){
        int[] nums1 = {1,1,1,1,1};
        int res1 = new RemoveDuplicatesFromSortedArray2().removeDuplicates(nums1);
        assertEquals(2,res1);

        int[] nums2 = {1,2,3,4,5};
        int res2 = new RemoveDuplicatesFromSortedArray2().removeDuplicates(nums2);
        assertEquals(5,res2);

//        int[] nums3 = {1,1,1, 2,3,3, 4,5};
//        int[] expNums3 = {1,1,2,3,3,4,5};
//        int res3 = new RemoveDuplicatesFromSortedArray2().removeDuplicates(nums3);
//        assertEquals(res3,7);
//        int[] actual
//        for(int i = 0; i< expNums3.length(); i++){

        }

    @Test
    public void test2(){
        int[] nums1 = {1,2,2};
        int res1 = new RemoveDuplicatesFromSortedArray2().removeDuplicates(nums1);
        assertEquals(3,res1);
        assertEquals(1, nums1[0]);
        assertEquals(2, nums1[1]);
        assertEquals(2, nums1[2]);
    }
}
