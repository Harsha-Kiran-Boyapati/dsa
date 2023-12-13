package lld.snakeAndLadder.v1;

import lld.snakeAndLadder.v1.models.Board;
import lld.snakeAndLadder.v1.models.Bridge;
import lld.snakeAndLadder.v1.models.Dice;
import lld.snakeAndLadder.v1.models.Game;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Driver {
    public static void main(String[] args) {
       List<String> players = List.of("Goku", "Gohan", "Krilin");
       List<Bridge> ladders = new ArrayList<>(List.of(new Bridge(2, 37), new Bridge(27, 46), new Bridge(65,84) ));
       List<Bridge> snakes = new ArrayList<>(List.of(new Bridge(42, 20), new Bridge(79, 5), new Bridge(65,84), new Bridge(33,6) ));
       Board board = new Board(100, snakes, ladders);
       board.addSnake();
       board.addSnake();
       board.addSnake();
       System.out.println(board.getSnakes().toString());
       Game game = new Game(board, players, new Dice());
       game.play();
    }
}
