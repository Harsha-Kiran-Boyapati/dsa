package lld.trello.v1.services;

import lld.trello.v1.models.Board;
import lld.trello.v1.models.Card;
import lld.trello.v1.models.CardList;
import lombok.val;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

public class BoardService {
    private CardListService cardListService;
    private ArrayList<Board> boards = new ArrayList<>();

    public BoardService(CardListService _cardListService){
        cardListService = _cardListService;
    }

    public Optional<Board> get(int boardId){
        if(0<= boardId && boardId < boards.size() && boards.get(boardId) != null)
            return Optional.of(boards.get(boardId));
        return Optional.empty();
    }

    public Board create(){
        Board board = new Board(boards.size());
        return board;
    }

    public Board create(String name){
        Board board = create();
        board.setName(name);
        return board;
    }


    public void delete(int boardId){
        if(0<= boardId && boardId < boards.size() && boards.get(boardId) != null){
            Board board = boards.get(boardId);
            for(CardList cardList: board.getCardLists()){
                cardListService.delete(cardList.getId());
            }
        }
    }

    public ArrayList<Board> getAll(){
        return boards;
    }
}
