package syntax.collections;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlatMapTest {
    @Test
    void test() {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
        map.put(0, Map.of(1,2, 3,4));
        map.put(1, Map.of(11,12, 13,14));
        //need output a list of list [[0,1,2], [0,3,4], [1,11,12], [1, 13,14]]
        List<List<Integer>> list = map.entrySet().stream().flatMap(lowerUserEntry ->
                lowerUserEntry.getValue().entrySet().stream().map(higherUserEntry -> List.of(lowerUserEntry.getKey(), higherUserEntry.getKey(), higherUserEntry.getValue()))
        ).toList();

       list.forEach(System.out::println);
    }
}
