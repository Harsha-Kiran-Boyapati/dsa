package dsa.leetcode150.arrays;

import java.util.*;

//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargest {
    //using quicksort
    public int findKthLargest(int[] nums, int k){
        return valAt(nums, 0, nums.length-1, nums.length-k);
    }

    //start<=idx<=end
    private int valAt(int[] nums, int start, int end, int idx){
        if(start==end){
            return nums[start];
        }else if(start==end+1){
            if(idx == start)return Math.min(nums[start], nums[end]);
            else return Math.max(nums[start], nums[end]);
        }
        int[] pivotIndices;
        pivotIndices = pivot(nums, start, end);
        if(pivotIndices[0]<=idx && idx<=pivotIndices[1]) return nums[idx];
        else if(pivotIndices[1]<idx) return valAt(nums, pivotIndices[1]+1, end, idx);
        else return valAt(nums, start,pivotIndices[0]-1, idx);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i]; nums[i] = nums[j]; nums[j] = temp;
    }

    //returns index of the pivot after and
    // makes nums[x] x<=start<pviotIndex less than equal to pivot
    // makes nums[x] pviotIndex<x<=end greater than pivot
    private int[] pivot(int[] nums, int start, int end){
        int randIdx = start + new Random().nextInt(end-start);
        int pivotVal = nums[randIdx];
        swap(nums, start, randIdx);
        //last index of elements that are less than pivot
        int lessIdx = start;
        for(int i= start+1; i<=end; i++){
            if(nums[i]<pivotVal){ swap(nums,lessIdx+1,i); lessIdx++;}
        }
        swap(nums, lessIdx, start);
        int pivotStartIdx = lessIdx;
        //put all the elements equal to pivot beside pivot;
        for(int i = lessIdx+1; i<=end; i++){
            if(nums[i] == pivotVal){swap(nums, lessIdx+1, i); lessIdx++;}
        }
        int pivotEndIndex = lessIdx;
        return new int[]{pivotStartIdx, pivotEndIndex};
    }

    //priorityQueue
    public int findKthLargest2(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0;i<k;i++) pq.add(nums[i]);
        for(int i=k; i<nums.length; i++){
            pq.add(nums[i]);
            pq.poll();
        }
        return pq.peek();
    }

    //using TreeMap
    public int findKthLargest1(int[] nums, int k) {
        SortedMap<Integer, Integer> map = new TreeMap<>();
        int count = 0;
        for(int x: nums){
            map.put(x, map.getOrDefault(x,0)+1); count++;
            if(count==k+1){
                int least = map.firstKey();
                int leastValCount = map.get(least);

                if(leastValCount==1) map.remove(least);
                else map.put(least, leastValCount-1);
                count--;
            }
        }
        return map.firstKey();
    }
}
