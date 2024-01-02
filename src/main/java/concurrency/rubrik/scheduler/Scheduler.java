package concurrency.rubrik.scheduler;

import java.util.concurrent.*;

//consider each task results in two futures, taskFuture and waitFuture
//waitFuture only completes all the tasks submitted before the task and the task completes
public class Scheduler {
    private static record Pair(Future<?> future, CompletableFuture<Void> waitFuture){};
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private final BlockingDeque<Pair> bq = new LinkedBlockingDeque<>();
    private CompletableFuture<Void> lastWaitFuture = CompletableFuture.completedFuture(null);

    public Scheduler(){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(this::waitFutureHandler);
    }

    private void waitFutureHandler(){
            while(true){
                Pair pair = bq.poll();
                try {
                    pair.future().get();
                } catch (Exception e) {
                } finally {
                    pair.waitFuture().complete(null);
                }
            }
        }
    public void submitWork(Runnable runnable){
        Future<?> future = executorService.submit(runnable);
        CompletableFuture<Void> waitFuture = new CompletableFuture();
        bq.offer(new Pair(future, waitFuture));
    }


    public void blockUntilComplete(){
        try {
            lastWaitFuture.get();
        } catch (Exception e) {
        }
    }
}
