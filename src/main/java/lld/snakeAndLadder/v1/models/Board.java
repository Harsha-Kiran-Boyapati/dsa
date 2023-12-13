package lld.snakeAndLadder.v1.models;

import lombok.Getter;

import java.util.*;

@Getter
public class Board {
    private int size;
    private List<Bridge> snakes;
    private List<Bridge> ladders;

    public Board(int _size, List<Bridge> _snakes, List<Bridge> _ladders){
        this.size = _size; this.snakes = _snakes; this.ladders = _ladders;
    }

    public Board(int size, int numSnakes, int numLadders){

    }

    public int nextPos(int currPos, int delta){
        if(currPos + delta > size) return currPos;
        return teleport(currPos+delta);
    }

    public int teleport(int from){
        int to = from;
        List<Bridge> bridges = new LinkedList<Bridge>(snakes); bridges.addAll(ladders);
        while(true){
            for(Bridge bridge: bridges){
                if(bridge.start() == to){
                    to = bridge.end(); break;
                }
            }
            break;
        }
        return to;
    }

    //two snakes must not start together
    //two ladders must not start
    //no snake starts at size
    //start and end should be between 1 and size
    public void addSnake(){
        Random random = new Random();
        //can add a counter to not let this run forever;
        while(true){
            int start = random.nextInt(size-1)+1;
            int end = random.nextInt(start-1)+1;
            Bridge bridge = new Bridge(start, end);
            if(isValid(bridge)){
                snakes.add(bridge); break;
            }
        }
    }

    private void addLadder(){
        Random random = new Random();
        //can add a counter to not let this run forever;
        while(true){
            int end = random.nextInt(size-1)+1;
            int start = random.nextInt(end-1)+1;
            Bridge bridge = new Bridge(start, end);
            if(isValid(bridge)){
                ladders.add(bridge); break;
            }
        }
    }

    private boolean isValid(Bridge bridge){
        if(bridge.start() == size) return false;
        if(bridge.start() == bridge.end()) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(Bridge snake: snakes) map.put(snake.start(), snake.end());
        for(Bridge ladder: ladders) map.put(ladder.start(), ladder.end());
        //bridge starts at start of another bridge
        if(map.containsKey(bridge.start())) return false;
        int to = bridge.end();
        while(map.containsKey(to)){
            if(to==bridge.start()) return false;
            to = map.get(to);
        }
        return true;
    }

}
