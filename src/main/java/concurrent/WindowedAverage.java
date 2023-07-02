package concurrent;

import lombok.Getter;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

//Windowed Average. Your are given a set of key, value pair. Each key, value expires after k millisec.
// I can ask you to get me a specific key. Also, I can ask you to return me the average.
// The catch was to make sure to pruce the DLL before each call. For ex: if <"foo", 100> is saved at t = 1
// and time expiry is 3ms then after 3 ms get("foo") should return key not found.
public class WindowedAverage<K,V> {
    private Integer sum;
    private Integer count;
    @Getter
    private Integer average;
    private BlockingDeque<Object> queue = new LinkedBlockingDeque<>();

//    public add(K key, V val)
}
