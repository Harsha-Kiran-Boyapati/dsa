package concurrency.rubrik.scheduler;

import java.util.concurrent.atomic.AtomicInteger;


//once count becomes zero, should increment of tasks be blocked
public class Scheduler4 {
    private final AtomicInteger count = new AtomicInteger(0);

    public void submitWork(Runnable runnable){
        count.incrementAndGet();
        Thread.startVirtualThread(() ->{
            runnable.run();
            if(count.decrementAndGet() == 0){
                this.notifyAll();
            }
        });
    }

    public synchronized void blockUntilComplete() throws InterruptedException{
        while (count.get() != 0) {
            this.wait();
        }
        if(count.get() == 0) this.notifyAll();
    }
}
