package concurrency.rubrik.lru;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//synchroinzing get and put methods is the easiest way to implement thread-safe LRUCache
public class LRUCache<K,V> {
    private final dsa.leetcode150.LRUCache<K,V> cache;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
//    private final int capacity;

    public LRUCache(int _capacity){
        cache = new dsa.leetcode150.LRUCache<>(_capacity);
    }

   synchronized public V get(K key){
        Future<V> future = executor.submit(()->cache.get(key));
       try {
           return future.get();
       } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
       } catch (ExecutionException e) {
       }
       return null;
   }

    synchronized public V put(K key, V val){
        Future<V> future = executor.submit(()->cache.put(key, val));
        try {
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
        }
        return null;
    }
}
