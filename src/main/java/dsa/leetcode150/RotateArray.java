package dsa.leetcode150;
//189. Rotate Array
//Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
//Could you do it in-place with O(1) extra space?

//awesome solution
public class RotateArray {
    public void rotate(int[] nums, int k) {
        rotate(nums, 0, nums.length-1);
        rotate(nums, 0, k-1);
        rotate(nums, k, nums.length-1);
    }
    //start and end both inclusive
    private void rotate(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start]; nums[start] = nums[end]; nums[end] = temp;
            start++; end--;
        }
    }
}
