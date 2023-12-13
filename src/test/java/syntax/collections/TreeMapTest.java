package syntax.collections;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeMap;

//TreeMap
//TreeMap implements NavigableMap
public class TreeMapTest {
    @Test
    void constructorTest() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        TreeMap<String, String> customKeyComparatorTreeMap = new TreeMap<>(Comparator.comparingInt(String::length));
        //bidirectionalMap
    }

    @Test
    void test() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(2, 20);
        treeMap.put(1, 10);

    }
}
