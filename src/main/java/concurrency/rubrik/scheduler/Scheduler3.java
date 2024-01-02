package concurrency.rubrik.scheduler;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//wait while any existing work is not done yet
//what is considered as existing work, work that was submitted before this method is called or
//work that is submitted before this method returned;
//this implementation is for before this method returns
public class Scheduler3 {
    private final AtomicInteger count = new AtomicInteger(0);

    //I am using ReadWriteLock as I donot want a mutex
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Condition noPendingTasks = lock.readLock().newCondition();

    public void submitWork(Runnable runnable){
        count.incrementAndGet();
        Thread.startVirtualThread(() ->{
            try{
                runnable.run();
            }finally {
                if(count.decrementAndGet() == 0){
                    noPendingTasks.notifyAll();
                }
            }

        });
    };

    public void blockUntilComplete(){
        try {
            while(count.get() != 0){
                noPendingTasks.await();
            }
            return;
        } catch (InterruptedException e) {
        }
    }
}
