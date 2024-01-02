package concurrency.rubrik.lru;

import org.apache.tomcat.util.collections.ConcurrentCache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


//what are the problems faced by concurrent lru cache compared to single threaded lru cache
//single threaded lru cache is impemented using a doubly linked list and a hashmap

class DLLNode<K,V>{
    K key; V val; DLLNode<K,V> next; DLLNode<K,V> prev;
    DLLNode(K key, V val){this.key = key; this.val = val;}
    DLLNode(K key, V val, DLLNode<K,V> prev, DLLNode<K,V> next){this.key = key; this.val = val; this.next=next; this.prev=prev;}

}
class DLL<K,V>{
    private final DLLNode<K,V> tail = new DLLNode<K,V>(null, null, null, null);
    private final DLLNode<K,V> head = new DLLNode<K,V>(null, null, null, null);
    public DLL(){
        this.head.next = tail; this.tail.prev=head;
    }
    public synchronized void moveAhead(DLLNode<K,V> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head.next;
        node.prev = head;
        node.prev.next = node;
        node.next.prev = node;
    }

    //use only when some elements are present
    public synchronized K pollLast(){
        DLLNode<K,V> node = tail.prev;
        node.next.prev=node.prev;
        node.prev.next = node.next;
        node.prev=null; node.next=null;
        return node.key;
    }

    public synchronized DLLNode<K,V> add(K key, V val){
        DLLNode<K,V> node = new DLLNode<>(key, val, head.next, head);
        node.next.prev = node;
        node.prev.next = node;
        return node;
    }

//    public

}

public class LRUCache2<K,V> {

    private final ConcurrentMap<K,DLLNode<K,V>> map = new ConcurrentHashMap<>();
    private final int capacity;
    private DLL<K,V> dll = new DLL<>();

    public LRUCache2(int _capacity){
        this.capacity = _capacity;
    }

     public V get(K key){
       DLLNode<K,V> node = map.get(key);
       if(node == null) return null;
       dll.moveAhead(node);
       return node.val;
    }

     public synchronized V put(K key, V val){
        if(map.size() < capacity-1){
            map.put(key, dll.add(key,val));
        }else{

        }

        return val;
    }
}
