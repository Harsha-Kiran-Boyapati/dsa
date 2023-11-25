package dsa.leetcode150.trees;

import java.util.LinkedList;

public class PopulateNextPointer {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        LinkedList<Node> prev = new LinkedList<Node>(), curr;
        Node node;
        prev.addLast(root);
        while(!prev.isEmpty()){
            curr = new LinkedList<Node>();
            while(!prev.isEmpty()){
                node = prev.removeFirst();
                if(node.left != null)curr.addLast(node.left);
                if(node.right != null)curr.addLast(node.right);
                if(!prev.isEmpty()) node.next = prev.get(0);
                else node.next = null;
            }
            prev = curr;
        }
        return root;

    }
}


