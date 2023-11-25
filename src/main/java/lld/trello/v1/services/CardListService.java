package lld.trello.v1.services;

import lld.trello.v1.models.Board;
import lld.trello.v1.models.Card;
import lld.trello.v1.models.CardList;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Optional;

public class CardListService {
    private ArrayList<CardList> cardLists = new ArrayList<>();
    private CardService cardService;
    public CardListService(CardService _cardService){
        this.cardService = _cardService;
    }

    public Optional<CardList> get(int cardListId){
        if(0<= cardListId && cardListId < cardLists.size() && cardLists.get(cardListId) != null)
            return Optional.of(cardLists.get(cardListId));
        return Optional.empty();
    }

    public ArrayList<CardList> getAll() { return cardLists;}

    public CardList create(){
        CardList cardList = new CardList(cardLists.size());
        return cardList;
    }

    public CardList create(String name){
        CardList cardList = create();
        cardList.setName(name);
        return cardList;
    }

    public CardList create(@NonNull Board board, @NonNull String name){
        CardList cardList = create(); cardList.setBoard(board); cardList.setName(name);
        return cardList;
    }

    public void delete(int cardListId){
        if(0<= cardListId && cardListId < cardLists.size() && cardLists.get(cardListId) != null){
            CardList cardList = cardLists.get(cardListId);
            for(Card card: cardList.getCards()){
                cardService.delete(cardList.getId());
            }
            cardList.getBoard().removeCardList(cardList);
            cardLists.set(cardListId, null);
        }
    }

}
