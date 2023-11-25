package dsa.leetcode150.arrays.twoPointers;

//Medium
//https://leetcode.com/problems/container-with-most-water/description/

//You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//Find two lines that together with the x-axis form a container, such that the container contains the most water.
//Return the maximum amount of water a container can store.
//Notice that you may not slant the container.

//solution
//maxArea(heights) = maxArea(heights[0..n-1])
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left =0, right = height.length-1;
        int ans = 0;
        while(left<right){
            if(height[left]<height[right]){
                ans = Math.max(ans, height[left]*(right - left));
                left ++;
            }else if(height[left] > height[right]){
                ans = Math.max(ans, height[right]*(right - left));
                right--;
            }else{
                ans = Math.max(ans, height[right]*(right - left));
                right--; left++;
            }
        }
        return ans;
    }
}
