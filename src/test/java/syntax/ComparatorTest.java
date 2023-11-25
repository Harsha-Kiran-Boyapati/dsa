package syntax;

import lombok.Getter;
import org.junit.jupiter.api.Test;

import javax.print.attribute.standard.PrinterResolution;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Node {
    @Getter
    int distance;
    int val;
    Node(int distance, int val){
        this.distance = distance; this.val = val;
    }
}
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

//        PriorityQueue<Node> pq1 = new PriorityQueue<>( Comparator.reverseOrder(Comparator.comparingInt(Node::getDistance)))+
//                ;
//        PriorityQueue<Node> pq2 = new PriorityQueue<>(Comparator.reverseOrder());

//        pq1.add(new Node(1,0)); pq1.add(new Node(2,0));
//        pq2.add(1); pq2.add(2);
//        assertEquals(1, pq1.peek().distance);
//        assertEquals(2, pq2.peek());
    }

}
