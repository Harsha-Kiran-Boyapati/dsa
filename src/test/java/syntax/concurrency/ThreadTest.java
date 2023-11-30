package syntax.concurrency;

import org.junit.jupiter.api.Test;

public class ThreadTest {
    @Test
    void threadCreationTest() {
        Runnable runnable = () -> System.out.println("hello World");
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
