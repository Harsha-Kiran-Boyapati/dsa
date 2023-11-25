package dsa.leetcode150.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-median-from-data-stream/
public class MedianFinder {
    private PriorityQueue<Integer> maxHeap;//stores bottom half
    private PriorityQueue<Integer> minHeap; //stores upper half
    int middle;
    int count;

    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
        count=0;
    }

    public void addNum(int num) {
        if(count == 0){
            middle = num; count++;
            return;
        }

        if(count%2==0){
            //if there are even number of numbers
            if(num <= maxHeap.peek()){
                maxHeap.offer(num);
                middle = maxHeap.poll();
            }else{
                minHeap.offer(num);
                middle = minHeap.poll();
            }
        } else {
            minHeap.offer(Math.max(middle, num));
            maxHeap.offer(Math.min(middle, num));
        }

        count++;
    }

    public double findMedian() {
        return count%2 == 1 ? middle : ((double)maxHeap.peek() + (double)minHeap.peek())/2;
    }
}
