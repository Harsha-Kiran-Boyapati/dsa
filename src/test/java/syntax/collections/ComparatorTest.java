package syntax.collections;

import lombok.Getter;
import org.junit.jupiter.api.Test;

import javax.print.attribute.standard.PrinterResolution;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

record Node(int id, int distance){}
public class ComparatorTest {
    @Test
    public void test1(){

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());

        pq1.add(1); pq1.add(2);
        pq2.add(1); pq2.add(2);
        assertEquals(1, pq1.peek());
        assertEquals(2, pq2.peek());
    }

    @Test
    public void test2(){

        PriorityQueue<Node> maxHeap = new PriorityQueue<>( Comparator.comparingInt(Node::distance).reversed());

        maxHeap.add(new Node(1, 20));
        maxHeap.add(new Node(2,10));
        assertEquals(20, maxHeap.peek().distance());
    }

}
