package concurrency.rubrik.scheduler;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Scheduler5 {
    private final AtomicInteger count = new AtomicInteger(0);
    public void submit(Runnable runnable){
        count.incrementAndGet();
        CompletableFuture.runAsync(runnable).thenRunAsync(count::decrementAndGet);
    }
    private void decreaseCount(){
        if(count.decrementAndGet() == 0)this.notifyAll();
    }
    public void waitUntilComplete() throws InterruptedException {
        while(count.get() !=0)
            this.wait();
    }
}

