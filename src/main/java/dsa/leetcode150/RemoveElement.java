package dsa.leetcode150;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
//        int valCount =0;
//        for(int i =0; i< nums.length; i++) valCount = nums[i] ==val ? valCount +1: valCount;
//        if(valCount == nums.length)
//            return 0;
//        //else

        int currNonValIdx = -1;
        for(int x : nums){
            if(x!=val){
                nums[++currNonValIdx] = x;
            }
        }
        return currNonValIdx+1;

    }
}
