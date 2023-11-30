package syntax.concurrency.synchronize;

//when is synchronized used
//does synchronized linearises the calls to a specific method
//or is it shor form for guarding a method with that instance as lock
//what is a intrinsic lock
public class SynchronizeExample1 {
    private int val;

    public synchronized void setVal(int _val){
        this.val = _val;
    }

    public synchronized  int getVal(){return this.val;}

}
