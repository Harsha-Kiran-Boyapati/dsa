package concurrency.rubrik.boundedBuffer;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer<E> {
    static class Node<E>{
        E item;
        Node<E> next;
        Node(E x) {this.item = x;}
    }

    private final int capacity;
    private Node<E> head;
    private Node<E> last;
    private AtomicInteger count = new AtomicInteger(0);
    private final Lock takeLock = new ReentrantLock();
    private final Condition notEmpty = takeLock.newCondition();
    private final Lock putLock = new ReentrantLock();
    private final Condition notFull = putLock.newCondition();
    public BoundedBuffer(int _capacity){
        this.capacity = _capacity;
        last = head = new Node(null);
    }

    public void put(E val){

    }

    public E take() throws InterruptedException{
        final AtomicInteger count = this.count;
//        if(count.get() == capacity) return false;
        return null;
    }

    private void enqueue(E val){
        last.next = new Node(val);
        last = last.next;
    }

    private E dequeue(){
        Node<E> h = head;
        Node<E> first = head.next;
        h.next = first.next;
        first.next = null;
        return first.item;

    }
}
