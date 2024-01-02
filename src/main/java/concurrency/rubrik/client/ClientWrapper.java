package concurrency.rubrik.client;

//https://leetcode.com/discuss/interview-question/1857832/Rubrik-or-Phone-Screen

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Multiple threads can concurrently access methods of class ClientWrapper.
// One needs to implement all the methods of class ClientWrapper such that following use cases are covered -
//
//If init() is in progress by some thread, then block other concurrent threads to execute request() or close() method
//Do not allow concurrent calls to init() method.
//Allow concurrent calls to request() method if init() is already called successfully.
//If some thread is still using request(), then block any other thread to close the connection using close() method
//Once connection is closed, do not allow subsequent calls to close() method
//Do not allow concurrent calls to close() method
public class ClientWrapper {
    public static class MultipleRequestException extends Exception{ }
    public static class ConnectionClosedException extends Exception{ }
    public static class ConnectionCloseInProgressException extends Exception{ }
    private Lock initLock = new ReentrantLock();
    private ReentrantReadWriteLock closeLock = new ReentrantReadWriteLock();
    private boolean isConnectionClosed = false;

    private CountDownLatch initLatch = new CountDownLatch(1);
    private CountDownLatch closeLatch = new CountDownLatch(1);
    private ReentrantLock requestLock = new ReentrantLock();
    private Condition noRequests = requestLock.newCondition();
    private int pendingRequestCount;

    //possible states
    //non initialized, init call made, multiple init calls
    //one or more init calls,
    // atleast one init call in progress
    //one call to close

    public void init() throws MultipleRequestException {
        if(initLock.tryLock()){
            initLatch.countDown();
            initLock.unlock();
        }else{
            throw new MultipleRequestException();
        }
    }

    public void request() throws InterruptedException, ConnectionClosedException, ConnectionCloseInProgressException {
        if(isConnectionClosed) throw new ConnectionClosedException();
        if(!closeLock.readLock().tryLock()){
            throw new ConnectionCloseInProgressException();
        }
        initLatch.await();
        //do something
        closeLock.readLock().unlock();
    }

    public synchronized void close() throws MultipleRequestException, InterruptedException {initLatch.await();
        closeLock.writeLock().lock();
        if(isConnectionClosed){
            closeLock.writeLock().unlock();
            throw new MultipleRequestException();
        }else{
            //do something;
            isConnectionClosed = true;
        }
        closeLock.writeLock().unlock();
    }
}
