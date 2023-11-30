package syntax.collections;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriorityQueueTest {
    @Test
    public void test(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityBlockingQueue<Integer> pqb = new PriorityBlockingQueue<Integer>();
        pq.offer(2);
        pq.offer(1);
        pq.offer(3);
        assertEquals(1, pq.poll());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
//        maxHeap.
        maxHeap.offer(1);
        maxHeap.offer(2);
        maxHeap.offer(3);
        assertEquals(3, maxHeap.poll());
        assertEquals(2, maxHeap.peek());
        assertEquals(2, maxHeap.peek());
        assertEquals(2, maxHeap.peek());


    }
}
