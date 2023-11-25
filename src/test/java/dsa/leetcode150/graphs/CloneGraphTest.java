package dsa.leetcode150.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class CloneGraphTest {

    @Test
    void cloneGraph() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.addAll(List.of(node2, node3, node4));
        node2.neighbors.add(node1);
        node3.neighbors.add(node1);
        node4.neighbors.add(node1);

        Node clone = new CloneGraph().cloneGraph(node1);

        Assertions.assertArrayEquals(traverseGraph(node1).toArray(), traverseGraph(clone).toArray());

    }

    @Test
    void test2() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.addAll(List.of(node2, node3));
        node2.neighbors.addAll(List.of(node3, node4));
        node3.neighbors.addAll(List.of(node4, node2));
        node4.neighbors.addAll(List.of(node1, node1));

        Node clone = new CloneGraph().cloneGraph(node1);


        Assertions.assertArrayEquals(traverseGraph(node1).toArray(), traverseGraph(clone).toArray());

    }

    List<Integer> traverseGraph(Node node){
        HashSet<Node> traversedNodes = new HashSet<>();
        LinkedList<Node> queue = new LinkedList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        traversedNodes.add(node);
        queue.addLast(node);
        while(!queue.isEmpty()){
            Node curr = queue.removeFirst();
            ans.add(curr.val);
            for(Node neighbor: curr.neighbors){
                if(traversedNodes.contains(neighbor)) continue;
                traversedNodes.add(neighbor);
                queue.addLast(neighbor);
            }
        }
        return ans;
    }
}