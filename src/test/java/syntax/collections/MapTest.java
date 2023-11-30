package syntax.collections;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapTest {
    @Test
    void generateValuesForAllKeys() {
        Map<Integer, Integer> squareMap = new HashMap<>();
        for(int i=0; i<10; i++) squareMap.computeIfAbsent(i, key -> key*key);
        assertEquals(9, squareMap.get(3));
    }
}
