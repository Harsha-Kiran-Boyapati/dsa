package syntax.concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {
    @Test
    void test() {
        BlockingQueue<Integer> unbounded = new LinkedBlockingQueue<>();

        BlockingQueue<Integer> bounded1 = new LinkedBlockingQueue<>(10);
        BlockingQueue<Integer> bounded2 = new ArrayBlockingQueue<>(10);

    }
}
