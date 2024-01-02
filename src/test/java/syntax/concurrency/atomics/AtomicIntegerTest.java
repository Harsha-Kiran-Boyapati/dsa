package syntax.concurrency.atomics;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    @Test
    void name() {
        AtomicInteger atom = new AtomicInteger();
        atom.get();
//        atom.getAcquire()
    }
}
