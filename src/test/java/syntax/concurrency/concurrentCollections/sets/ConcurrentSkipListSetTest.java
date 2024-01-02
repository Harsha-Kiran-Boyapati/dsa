package syntax.concurrency.concurrentCollections.sets;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipListSetTest {
    @Test
    void constructors() {
        ConcurrentSkipListSet<Integer> list = new ConcurrentSkipListSet<>();
    }
}
