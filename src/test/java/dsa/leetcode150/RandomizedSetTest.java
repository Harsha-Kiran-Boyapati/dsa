package dsa.leetcode150;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedSetTest {

    @Test
    void insert() {
        RandomizedSet set = new RandomizedSet();
        set.insert(1); set.insert(1); set.insert(10);
        assertFalse(set.remove(2));
        assertTrue(set.remove(1));
        assertEquals(10, set.getRandom());
    }

    @Test
    void getRandom() {
    }
}