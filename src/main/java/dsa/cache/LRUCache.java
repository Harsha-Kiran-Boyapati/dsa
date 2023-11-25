package dsa.cache;

import java.util.HashMap;

//use a dll and a hash map
class Node<K, V> {
    K key;
    V val;
    Node next;
    Node prev;
    Node(K key, V val){
        this.val = val;
        this.key = key;
    }
    Node(){
    }
}

class Dll<K,V>{
    Node<K,V> head;
    Node<K,V> tail;
    Dll() {
        this.head = new Node<K,V>();
        this.tail = new Node<K,V>();
        head.next =tail;
        tail.prev=head;
    }
    void remove(Node<K,V> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
    void add(Node<K,V> node){
        node.next=head.next;
        node.prev=head;
        node.next.prev=node;
        node.prev.next=node;
    }
     Node<K,V> getLast(){
        return tail.prev;
    }
}

// this is not a thread safe class
//this won't work properly if multiple threads access it simultaneously
public class LRUCache<K,V> {
    HashMap<K,Node<K,V>> cache = new HashMap<>();
    Dll<K,V> access = new Dll<>();
    private int capacity=10;
    public LRUCache(int capacity){
        this.capacity = capacity;
    }
    void put(K key, V val){
        if(cache.size() == capacity){
            Node<K,V> lastNode = access.getLast();
            access.remove(lastNode);
            cache.remove(lastNode.key);
            Node<K,V> node = new Node<>(key,val);
            access.add(node);
            cache.put(key, node);
        }
        else{
            Node<K,V> node = new Node<>(key,val);
            access.add(node);
            cache.put(key, node);
        }
    }

    V get(K key){
        Node<K,V> node = cache.get(key);
        if(node == null)  return null;
        access.remove(node);
        access.add(node);
        return node.val;
    }

}
