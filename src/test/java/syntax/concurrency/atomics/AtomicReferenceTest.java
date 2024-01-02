package syntax.concurrency.atomics;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
    @Test
    void name() {
        AtomicReference<Integer> atom = new AtomicReference<>(3);
        atom.getAcquire();

    }
}
