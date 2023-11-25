package dsa.leetcode150;

//https://leetcode.com/problems/insert-delete-getrandom-o1/description/

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

//class Node{
//    int val; Node prev; Node next;
//    Node(){}
//    Node(int val){this.val = val;}
//}
//class Dll{
//    private Node head, tail;
//    Dll(){
//        this.head = new Node();
//    }
//    void add(Node node){
//        tail.prev.next = node;
//        node.prev = tail.prev;
//    }
//}
public class RandomizedSet {
    private HashMap<Integer, Integer> map = new HashMap<>();
    private ArrayList<Integer> l = new ArrayList<>();
    private Random rand = new Random();

    public RandomizedSet(){}

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else{
            l.add(val);
            map.put(val, l.size()-1);
            return true;
        }
    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            int idx = map.get(val);
            int lastEle = l.get(l.size()-1);
            l.set(idx, lastEle);
            map.put(lastEle, idx);
            map.remove(val);
            l.remove(l.size()-1);
            return true;
        }else{
            return false;
        }
    }

    public int getRandom() {
        int randIdx = rand.nextInt(l.size());
        return l.get(randIdx);
    }
}
