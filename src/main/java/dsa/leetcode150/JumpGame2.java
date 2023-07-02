package dsa.leetcode150;

//45. Jump Game II
//You are given a 0-indexed array of integers nums of length n.
// You are initially positioned at nums[0].
//
//Each element nums[i] represents the maximum length of a forward jump from index i.
// In other words, if you are at nums[i], you can jump to any nums[i + j] where:
//
//0 <= j <= nums[i] and
//i + j < n
//Return the minimum number of jumps to reach nums[n - 1].
// The test cases are generated such that you can reach nums[n - 1].
public class JumpGame2 {
    public int jump(int[] nums) {
        if(nums.length<=1) return 0;

        int jumpCount = 1;
        int lastPos=0, maxIdx=nums[0];
        while(maxIdx < nums.length-1){
            int newMaxIdx = maxIdx;
            for(int i=lastPos+1; i<=maxIdx; i++){
                newMaxIdx = Math.max(newMaxIdx, i+nums[i]);
            }
            lastPos = maxIdx;
            maxIdx = newMaxIdx;
            jumpCount++;
        }
        return jumpCount;
    }
}
