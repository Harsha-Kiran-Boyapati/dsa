package syntax.concurrency.concurrentCollections.maps;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentHashMapTest {
    @Test
    void constructor() {
        ConcurrentHashMap<Integer,Integer> map1 = new ConcurrentHashMap<>();
        ConcurrentNavigableMap<Integer, Integer> map2 = new ConcurrentSkipListMap<>();
    }
}
