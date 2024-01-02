package concurrency.rubrik.groupRequests;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

record Request(String ip, String browserAgent, Instant instant){}

record Group(String key, Instant startExclusive, Instant endInclusive, List<Request> requests){};
public class RequestGrouper {
    private final List<Request> allRequests = Collections.synchronizedList( new LinkedList<>());
    private final Duration duration;
    private final Function<Request,String> keyfn;

    public RequestGrouper(Function<Request,String> _keyfn, Duration _duration){
        this.keyfn = _keyfn; this.duration = _duration;
    }
    public void add(Request request){
        allRequests.add(request);
    }
    public Group get(String key){
        Instant end = Instant.now();
        Instant endExclusive = Instant.now().plusMillis(1);
        Instant startExclusive = end.minus(duration);
        List<Request> list = allRequests.parallelStream()
                .filter(r -> keyfn.apply(r).equals(key) && r.instant().isBefore(endExclusive) && r.instant().equals(end) && r.instant().isAfter(startExclusive) )
                .toList();
        return new Group(key, startExclusive, end, list);
    }

    private void Compactor(){
        while(true){
            try{
                Thread.sleep(Duration.ofSeconds(1));
            }catch(Exception ignored){}
            compactUntil(Instant.now().minus(duration));
        }
    }

    private void compactUntil(Instant instantExclusive){
        allRequests.removeIf(r -> r.instant().isBefore(instantExclusive));
    }
}
