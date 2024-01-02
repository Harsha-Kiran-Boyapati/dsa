package syntax.concurrency.atomics;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AvalialbleAtomicsTest {
    @Test
    void allAtomics() {
        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        AtomicReference<Integer> ref = new AtomicReference<>();

    }
}
