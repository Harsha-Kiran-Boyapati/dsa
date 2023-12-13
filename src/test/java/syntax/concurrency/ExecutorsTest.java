package syntax.concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

//this is about methods available in Executors class
public class ExecutorsTest {
    @Test
    void constructorTest() {
        ExecutorService singleThreadedExecutorService = Executors.newSingleThreadExecutor();
        ExecutorService threadPoolExecutorService = Executors.newFixedThreadPool(8);
        ExecutorService customThreadPoolExecutorService = new ThreadPoolExecutor(
                10,
                20,
                3000,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10)
        );

//        ExecutorService customQueueExecutorService = Executors.newScheduledThreadPool(8,)
    }
}
