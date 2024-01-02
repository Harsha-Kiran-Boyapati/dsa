package concurrency.book.explicitLocks;

import java.util.concurrent.locks.ReentrantLock;

public class RentrantLockUsage {
    public void m(String[] args) {
//        Lock lock =  (Lock)new ReentrantLock();
//        lock.lock();
        try{
            //update ojbect state
            //catch exceptions and restore invariants if necessary
        }finally{
//            lock.unlock();
        }
    }
}
