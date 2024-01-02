package syntax.concurrency.concurrentCollections.maps;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.NavigableMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapTest {
    @Test
    void constructor() {
        ConcurrentSkipListMap<Integer,Integer> map1 = new ConcurrentSkipListMap<>();
        ConcurrentNavigableMap<Integer, Integer> map2 = new ConcurrentSkipListMap<>();
        NavigableMap<Integer, Integer> map4 = new ConcurrentSkipListMap<>();
        Map<Integer, Integer> map3 = new ConcurrentSkipListMap<>();
    }
}
