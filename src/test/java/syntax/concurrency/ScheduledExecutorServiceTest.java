package syntax.concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//this interface extends ScheduledExecutorService
public class ScheduledExecutorServiceTest {
    @Test
    void constructorTest() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        ScheduledExecutorService singleThreadedService = Executors.newSingleThreadScheduledExecutor();
    }

    @Test
    void scheduleTaskTest() throws InterruptedException {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.schedule(()->{System.out.println("hello");}, 3, TimeUnit.SECONDS);
        System.out.println("main thread started sleeping");
        Thread.sleep(4000);
        System.out.println("main thread finished sleeping");
    }
}
