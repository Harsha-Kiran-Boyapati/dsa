package concurrency.rubrik.scheduler;

import java.util.concurrent.*;

public class Scheduler6 {
    private final ConcurrentLinkedQueue<Future<Void>> q = new ConcurrentLinkedQueue<>();
    public void submitWork(Runnable runnable){
        CompletableFuture<Void> future = CompletableFuture.runAsync(runnable);
        q.offer(future);
        q.removeIf(Future::isDone);
    }
    public void waitUntilComplete() throws ExecutionException, InterruptedException {
        while(!q.isEmpty()){
            q.peek().get();
        }
    }
}
