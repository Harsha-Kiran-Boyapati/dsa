package syntax.concurrency.concurrentCollections.lists;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {
    @Test
    void constructors() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
    }
}
