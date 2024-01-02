package dsa.companies.uber;


import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class ExamRoom {

    private final int capacity;

    private TreeSet<Integer> occupied = new TreeSet<Integer>();

    //store number of empty seats in between and the interval
    private TreeMap<Integer, TreeSet<Integer>> available = new TreeMap<>( );

    public ExamRoom(int n) {
        this.capacity = n;
        available.put(n, new TreeSet<>(List.of(0)));
    }

    //O(log n)
    //distance is how close another person is
    // if 1 and 3 are occupied then minDistance at 2 is 1
    public int seat() {

        Map.Entry<Integer, TreeSet<Integer>> entry = available.lastEntry();

        //value in entry has next possible indices.
        //take the first index
        int s = entry.getValue().pollFirst();
        Integer prev = occupied.lower(s);
        Integer next = occupied.higher(s);

        if(s!=0){
            addToAvailableByInterval(prev!=null?prev+1:0, s-1);
        }
        if(s!=capacity-1){
            addToAvailableByInterval(s+1, next!=null?next-1:capacity-1);
        }

        occupied.add(s);

        //if there was only element in treeSet
        //remove that entry from avaiable
        if(entry.getValue().size()==0) available.remove(entry.getKey());

        return s;
    }

    //O(logn)
    public void leave(int p) {
        Integer prev = occupied.lower(p);
        Integer next = occupied.higher(p);

        //available will have one seat regarding interval to right of p
        //one interval regarding interval to left of p
        //remove those two seats from available
        //and add one seat to availabe

        if(p!=0){
            removeFromAvailableByInterval(prev!=null?prev+1:0, p-1);
        }

        if(p!=capacity-1){
            removeFromAvailableByInterval(p+1, next!=null?next-1:capacity-1);
        }
        addToAvailableByInterval(prev!=null?prev+1:0,
                next!=null?next-1:capacity-1);
        occupied.remove(p);
    }

    private void removeFromAvailable(int dis, int id){
        TreeSet<Integer> set = available.get(dis);
        if(set!=null)set.remove(id);
        if(set.isEmpty())available.remove(dis);
    }

    private void addToAvailable(int dis, int id){
        available.putIfAbsent(dis, new TreeSet<>());
        available.get(dis).add(id);
    }

    //start end are start and end of empty seat interval
    private void addToAvailableByInterval(int start, int end){
        if(start>end)return;
        int dis, id;
        if(start == 0){
            dis = end+1; id =0;
        }
        else if(end == capacity-1){
            dis = end-start+1; id = capacity-1;
        }else{
            dis = (end-start)/2 + 1; id = (start+end)/2;
        }
        available.putIfAbsent(dis, new TreeSet<>());
        available.get(dis).add(id);
    }

    private void removeFromAvailableByInterval(int start, int end){
        if(start>end)return;
        System.out.println(start + " "+ end);
        if(start == 0 && end== capacity-1)return;
        int dis, id;
        if(start == 0){
            dis = end+1; id =0;
        }
        else if(end == capacity-1){
            dis = end-start; id = capacity-1;
        }else{
            dis = (end-start)/2 + 1; id = (start+end)/2;
        }
        if(available.containsKey(dis)){
            available.get(dis).remove(id);
            if(available.get(dis).size()==0) available.remove(dis);
        }

    }
}

//Socket
/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
