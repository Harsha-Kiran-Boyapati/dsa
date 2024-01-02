package concurrency.rubrik.scheduler;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

//intention of this version is to reduce the time it takes to submit work
//and reduce cache polluting
public class Scheduler1b {
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private List<Future> futures = new CopyOnWriteArrayList<>();
    public void submitWork(Runnable runnable){
        Future future = executorService.submit(runnable);
    }

    // if i use the
    public void blockUntilComplete(){
        Iterator<Future> itr = futures.iterator();
        while(itr.hasNext()){
            try {
                itr.next().get();
                itr.remove();
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
            } catch (ExecutionException e) {
//                throw new RuntimeException(e);
            }
        }
    }
}
