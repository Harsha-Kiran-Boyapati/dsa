package syntax.concurrency.lock;

public class LockExample1 {
    private int val;

    public synchronized void setVal(int _val){
        this.val = _val;
    }

    public synchronized  int getVal(){return this.val;}

}