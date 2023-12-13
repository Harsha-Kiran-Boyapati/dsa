package lld.snakeAndLadder.v1.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Board board;
    private Map<String, Integer> playerPositions;
    private Dice dice;
    public Game(Board _board, List<String> players, Dice _dice){
        this.playerPositions = new HashMap<>();
        for(String player: players) playerPositions.put(player, 0);
        this.board = _board; this.dice = _dice;
    }

    public void play(){
        while(!hasGameEnded()){
            for(String player: playerPositions.keySet()){
                nextMove(player);
                if(hasGameEnded()) break;
            }
        }
    }

    private String getWinner(){
        for(Map.Entry<String, Integer> entry: playerPositions.entrySet()){
            if(entry.getValue() == board.getSize()) return entry.getKey();
        }
        return null;
    }

    private void nextMove(String player){
        if(hasPlayerWon(player))return;
        int currPos = playerPositions.get(player);
        int nextPos = board.nextPos(currPos, dice.roll());
        playerPositions.put(player, nextPos);
        System.out.println(player + " moved from " +  currPos + " to " + nextPos);
    }
    private boolean hasPlayerWon(String player){
        return playerPositions.get(player) == board.getSize();
    }
    private boolean hasGameEnded(){
        for(String player: playerPositions.keySet()) if(hasPlayerWon(player)) return true;
        return false;
    }

}
