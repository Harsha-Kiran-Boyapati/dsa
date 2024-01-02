package concurrency.rubrik.scheduledExecutor;
import java.lang.Thread;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class Executor1 {

    // Creates and executes a one-shot action that becomes enabled after the given delay.
    public void schedule(Runnable command, long delay, TimeUnit unit){
        long start = System.currentTimeMillis();
        startVirtualThread(()->{
           sleepUntil(start+unit.toMillis(delay));
            command.run();
        });
    }

//     Creates and executes a periodic action that becomes enabled first after the given initial delay,
//     and subsequently with the given period; that is executions will commence after initialDelay
//     then initialDelay+period, then initialDelay + 2 * period, and so on.
    public void scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit){
        long start = System.currentTimeMillis();
        Thread.startVirtualThread(()->{
            sleepUntil(start+unit.toMillis(initialDelay));
            Thread.startVirtualThread(command);
            int i=0;
            while(true){
                sleepUntil(start+initialDelay+(++i)*unit.toMillis(period));
                Thread.startVirtualThread(command);
            }
        });
    }

    private void sleepUntil(long endTimeMillis){
        while(System.currentTimeMillis()<endTimeMillis){
            try{
                Thread.sleep(endTimeMillis - System.currentTimeMillis());
            }catch(InterruptedException e){
            }
        }
    }

    private void sleep(long period, TimeUnit unit){
        long endTime = System.currentTimeMillis()+unit.toMillis(period);
        while(System.currentTimeMillis()<endTime){
            try{
                Thread.sleep(endTime - System.currentTimeMillis());
            }catch(InterruptedException e){
            }
        }
    }

    //Creates and executes a periodic action that becomes enabled first after the given initial delay,
    // and subsequently with the given delay between the termination of one execution
    // and the commencement of the next.
    public void scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit){
        long start = System.currentTimeMillis();
        Thread.startVirtualThread(()->{
            sleepUntil(start+unit.toMillis(initialDelay));
            while(true){
                command.run();
//
                sleep(delay, unit);
            }
        });
    }
}
