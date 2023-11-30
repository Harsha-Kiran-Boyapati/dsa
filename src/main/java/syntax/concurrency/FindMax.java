package syntax.concurrency;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FindMax {
    //use concurrency tools to find max of the array
    //assume array is very large
    //dont bother about the efficiency of splitting the array into chunks to be processed concurrently
    //consider there are 8 cores
    //this question was asked to Tulasi in Microsoft interview
    //should talk to interviewer about using concurrent collections

    public int concurrentMax(int[] nums){
        int ans = Integer.MIN_VALUE;
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        List<Callable<Integer>> callables =  new LinkedList<>();
        //how to split nums into 8 parts
        callables = split(nums.length, 8).stream().map( pair -> newCallable(nums, pair[0], pair[1])).toList();
        try{
            List<Future<Integer>> futures = executorService.invokeAll(callables);
            for(Future<Integer> future: futures) ans = Math.max(ans, future.get());
        }catch(Exception e){
            System.out.println("encountered exception");
            e.printStackTrace();
            return 0;
        }
        return ans;
    }

    private Callable<Integer> newCallable(int[] nums, int start, int end){
        return new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int ans = Integer.MIN_VALUE;
                for(int i=start; i<end; i++) ans = Math.max(ans, nums[i]);
                return ans;
            }
        };
    }

    //chunkSize should atleast be one
    private List<int[]> split(int n, int count){
        List<int[]> res = new LinkedList<>();
        int chunkSize = n/count;
        for(int i=0; i<count-1; i++){
            res.add(new int[]{ chunkSize*i, chunkSize*(i+1) });
        }
        res.add(new int[]{ chunkSize*(count-1), n});
        return res;
    }

}
