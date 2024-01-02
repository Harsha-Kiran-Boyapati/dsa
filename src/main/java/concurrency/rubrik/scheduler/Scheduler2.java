package concurrency.rubrik.scheduler;

import java.util.concurrent.*;

public class Scheduler2 {
    private static record Pair(Future<?> future, CompletableFuture<Void> waitFuture){};
    private final ExecutorService executorService = Executors.newCachedThreadPool();
//    private final BlockingDeque<Pair> bq = new LinkedBlockingDeque<>();
    private CompletableFuture<Void> lastWaitFuture = CompletableFuture.completedFuture(null);

    public Scheduler2(){
//        lastWaitFuture.thenRunAsync(()->)
//        Executor executor = Executors.newSingleThreadExecutor();
//        executor.execute(this::waitFutureHandler);
    }


    public void submitWork(Runnable runnable){
        Future<?> future = executorService.submit(runnable);
        CompletableFuture<Void> waitFuture = new CompletableFuture();
        lastWaitFuture.thenRunAsync(() -> {
            try{future.get();}catch(Exception e){}
        }
    );
    }


    public void blockUntilComplete(){
        try {
            lastWaitFuture.get();
        } catch (Exception e) {
        }
    }
}
