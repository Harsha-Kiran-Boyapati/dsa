package dsa.algos.sorting;

import java.util.Arrays;


public class QuickSort {

    public static void sort(int[] nums){
        //algorithm for quicksort
        //pick a
        helper(nums, 0, nums.length-1);

    }
    // in place sorting
    //expects start to  b
    private static void helper(int[] nums, int start, int end){
        if(start>=end) return;
        if(end == start+1){
            if(nums[start] > nums[end]){
                int temp = nums[start]; nums[start] = nums[end]; nums[end] = temp;
            }
            return;
        }
        //if there are more than two elements
        int pivot = nums[start];
        int leftEnd = start;
        //bring all the elements less than are equal to pivot to left
        for(int j=start+1; j<=end; j++){
            if(nums[j] <= pivot){
                int temp = nums[j];
                nums[j] = nums[leftEnd+1];
                nums[leftEnd+1] = temp;
                leftEnd++;
            }
        }
        //tackle the case of multiple numbers with value of pivot
        int upperBound = leftEnd, lowerBound=leftEnd;
        for(int j=leftEnd; j>=start; j--){
            if(nums[j]==pivot){
                //swap lowerBound and j values and decrement lowerBound
                int  temp = nums[lowerBound];nums[lowerBound] = nums[j];nums[j] = temp;
            }
        }
        helper(nums, start, lowerBound-1); helper(nums, upperBound+1, end);
        return;
    }

    public static void main(String[] args) {
        int[] arr = {3,8,6,2, 2, 2,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
