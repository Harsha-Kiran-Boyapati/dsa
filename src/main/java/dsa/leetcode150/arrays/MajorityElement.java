package dsa.leetcode150.arrays;

//Given an array nums of size n, return the majority element.
//
//The majority element is the element that appears more than ⌊n / 2⌋ times.
// You may assume that the majority element always exists in the array.
//Follow-up: Could you solve the problem in linear time and in O(1) space?

//
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int[] onesCount = new int[32];
        for(int x: nums){
            String bits = Integer.toBinaryString(x);
            for(int i=0; i< bits.length(); i++){
                if(bits.charAt(bits.length()-1-i) == '1') onesCount[31-i]++;
            }
        }
        int half = nums.length/2;
        char[] binaryChars = new char[32];
        for(int i=0; i<32; i++){
            binaryChars[i] = onesCount[i] <= half ? '0' : '1';
        }

        return Integer.parseInt(new String(binaryChars), 2);
    }
}
