package syntax.concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ExecutorServiceTest {
    @Test
    void constructorTest() {
        ExecutorService customThreadPoolExecutorService = new ThreadPoolExecutor(
                10,
                20,
                3000,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10)
        );
        ExecutorService executorService = Executors.newSingleThreadExecutor();;
    }

    @Test
    void submitTask() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();;
        Future future1 = executorService.submit(() -> System.out.println("submit test"));
        Future<String> future2 = executorService.submit(() -> "Hello");
        System.out.println("was task cancelled - "+future2.isCancelled());
        System.out.println("was task cancelled - "+future2.cancel(true));
        System.out.println("was task cancelled - "+future2.isCancelled());
        System.out.println("output of task - "+future2.get());
    }

    @Test
    void executeTaskTest() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();;
        executorService.submit(() -> System.out.println("execute test"));
    }
}
