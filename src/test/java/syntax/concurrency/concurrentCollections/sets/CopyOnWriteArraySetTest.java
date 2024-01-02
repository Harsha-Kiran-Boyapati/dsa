package syntax.concurrency.concurrentCollections.sets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Copy;

import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetTest {
    @Test
    void constructors() {
        CopyOnWriteArraySet set = new CopyOnWriteArraySet();
    }
}
