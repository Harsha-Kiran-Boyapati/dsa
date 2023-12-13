package concurrency.pubsub.v1;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class PubSubTest {

    @Test
    void concurrencyTest() {
        PubSub pubsub = new PubSub();
        for(int i=0; i<5; i++) newConsumer(pubsub.subscribe());
        pubsub.publish("Hello");
        pubsub.publish("How Do you do");

    }
    private void newConsumer(BlockingDeque<String> bq){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            while(true){
                try {
                    String message = bq.take();
                    System.out.println(Thread.currentThread().getName() + " received: "+message);
                } catch (InterruptedException e) {

                }
            }
        });
    }
}