package concurrency.pubsub.v1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class PubSub {
    private int SUBSCRIBER_QUEUE_SIZE = 10;
    private int MESSAGE_QUEUE_SIZE = 100;
    private List<BlockingDeque<String>> subscribedBqs= new CopyOnWriteArrayList<>();
    private ExecutorService fanoutService;
    private BlockingDeque<String> messageQueue = new LinkedBlockingDeque<>(MESSAGE_QUEUE_SIZE);

    public PubSub() {
        startFanoutService();
    }

    public void publish(String message){
        messageQueue.offer(message);
    }

    private void startFanoutService(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() ->{
            while(true){
                try{
                    String message = messageQueue.take();
                    for(BlockingDeque bq: subscribedBqs){
                        //insert the message if space is available
                        bq.offer(message);
                    }
                }catch(Exception e){
                }
            }
        });
        this.fanoutService = executorService;
    }


    public BlockingDeque<String> subscribe(){
        BlockingDeque<String> bq = new LinkedBlockingDeque<>(SUBSCRIBER_QUEUE_SIZE);
        this.subscribedBqs.add(bq);
        return bq;
    }

    public void unsubscirbe(BlockingDeque<String> bq){
        this.subscribedBqs.remove(bq);
    }
}
