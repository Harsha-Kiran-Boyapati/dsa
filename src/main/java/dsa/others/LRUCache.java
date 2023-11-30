package dsa.others;

//https://leetcode.com/problems/lru-cache/?envType=study-plan-v2&envId=top-interview-150
//The functions get and put must each run in O(1) average time complexity

//I can find which is the least recently used using priority queue
// I cannot do that because
//how can i update the particular item that belongs to a key when that key is accessed again
//I need a data structure that tracks when a key is last updated
// in which the last updated time of the key can be updated
//how do i remove the same element from priority queue when

import org.w3c.dom.Node;

import java.util.*;

//what if the map can store the keys in ascending order of the updated time
public class LRUCache {
    class DLLNode{
        int key; int val; DLLNode prev; DLLNode next;
        DLLNode(int key, int val){this.key=key; this.val=val;}
    }

    private DLLNode head = new DLLNode(0,0);
    private DLLNode tail = new DLLNode(0,0);
    private void removeNode(DLLNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    //latest accessed will be near to the head
    private void addNode(DLLNode node){
        node.next = head.next;
        node.prev = head;
        node.next.prev = node; node.prev.next = node;
    }

    private DLLNode removeLastNode(){
        DLLNode node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        return node;
    }

    private int maxAccessTime = 0;
    private Map<Integer, DLLNode> map = new HashMap<>();

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail; tail.prev = head;
    }

    //assumes key is present in map
    public int get(int key) {
        DLLNode node = map.get(key);
        if(node == null) return -1;
        removeNode(node);
        addNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            DLLNode node = map.get(key);
            node.val = value;
            removeNode(node); addNode(node);
            return;
        }
        if(map.size() >= capacity){
            //remove last used key
            DLLNode lastUsed = removeLastNode();
            map.remove(lastUsed.key);
        }
        DLLNode node = new DLLNode(key, value);
        addNode(node);
        map.put(key, node);
    }
}
