package dsa.leetcode150.graphs;

import java.sql.Array;
import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> clones = new HashMap<>();

        //traverse graph and clone nodes
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node curr = queue.remove();
            Node clone = new Node(curr.val, new ArrayList<>(curr.neighbors));
            clones.put(curr,clone);
            for(Node neighbor: curr.neighbors){
                if(!clones.containsKey(neighbor)) queue.add(neighbor);
            }
        }
        for(Node curr: clones.values()){
            for(int i=0; i<curr.neighbors.size(); i++){
                curr.neighbors.set(i, clones.get(curr.neighbors.get(i)));
            }
        }

        return clones.get(node);
    }
}
