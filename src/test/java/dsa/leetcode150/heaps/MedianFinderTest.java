package dsa.leetcode150.heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianFinderTest {

    @Test
    public void test(){
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        assertEquals(1.5, obj.findMedian());
        obj.addNum(3);
        assertEquals(2.0, obj.findMedian());
    }

}