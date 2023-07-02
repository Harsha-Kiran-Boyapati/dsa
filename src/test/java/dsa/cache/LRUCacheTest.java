package dsa.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {
    @Test
    void lru(){
        LRUCache<Integer,Integer> cache = new LRUCache<>(5);
        cache.add(1,1);
        cache.add(2,2);
        cache.add(3,3);
        cache.add(4,4);
        cache.add(5,5);
        assertEquals(5, cache.getVal(5));
        cache.add(6,5);
        assertNull(cache.getVal(1));
        cache.getVal(2);
        cache.add(7,7);
        assertEquals(2, cache.getVal(2));
        assertNull(cache.getVal(3));
    }

}