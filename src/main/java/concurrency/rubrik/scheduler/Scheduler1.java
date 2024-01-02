package concurrency.rubrik.scheduler;

import java.util.List;
import java.util.concurrent.*;

public class Scheduler1 {
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private List<Future> futures = new CopyOnWriteArrayList<>();
    public void submitWork(Runnable runnable){
       Future future = executorService.submit(runnable);
       futures.add(future);
    }
    public void blockUntilComplete(){
        for(Future future: futures){
            try {
                future.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
