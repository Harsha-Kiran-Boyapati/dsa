package dsa.leetcode150;

import dsa.leetcode150.LRUCache;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {
    @Test
    void lru(){
        LRUCache<Integer,Integer> cache = new LRUCache<>(5);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        cache.put(5,5);
        assertEquals(5, cache.get(5));
        cache.put(6,5);
        assertNull(cache.get(1));
        cache.get(2);
        cache.put(7,7);
        assertEquals(2, cache.get(2));
        assertNull(cache.get(3));
    }

}