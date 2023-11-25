package lld.trello.v1;

import lld.trello.v1.exceptions.NotFoundException;
import lld.trello.v1.models.Board;
import lld.trello.v1.models.Card;
import lld.trello.v1.models.CardList;
import lld.trello.v1.models.User;
import lld.trello.v1.services.BoardService;
import lld.trello.v1.services.CardListService;
import lld.trello.v1.services.CardService;
import lld.trello.v1.services.UserService;
import lombok.Getter;

import java.util.Optional;

@Getter
public class Trello {

    private CardService cardService;
    private BoardService boardService;
    private CardListService cardListService;
    private UserService userService;
    public Trello(){
        cardService = new CardService();
        cardListService = new CardListService(cardService);
        boardService = new BoardService(cardListService);
        userService = new UserService();
    }

    public Card createCard(int cardListId, String email) throws NotFoundException {
        CardList cardList = cardListService.get(cardListId).orElseThrow(NotFoundException::new);
        User assignee = userService.getByEmail(email).orElseThrow(NotFoundException::new);
        return cardService.create(cardList, assignee);
    }

    public void DeleteCard(int cardId){
        cardService.delete(cardId);
    }

    public Board createBoard(String name){
        return boardService.create(name);
    }

    public Optional<Board> getBoard(int boardId) {return boardService.get(boardId);}

    public CardList createCardList(int boardId, String name) throws NotFoundException {
        Board board  = boardService.get(boardId).orElseThrow(NotFoundException::new);
        return cardListService.create(board, name);
    }

    public void deleteCardList(int cardListId){
        cardListService.delete(cardListId);
    }

//    public void

//    public Board crateBoard()
}
