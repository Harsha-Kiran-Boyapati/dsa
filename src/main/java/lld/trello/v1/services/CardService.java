package lld.trello.v1.services;

import lld.trello.v1.exceptions.NotFoundException;
import lld.trello.v1.models.Card;
import lld.trello.v1.models.CardList;
import lld.trello.v1.models.User;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Optional;

@NoArgsConstructor
public class CardService {
    private final ArrayList<Card> cards = new ArrayList<>();

    public Card create(){
        Card card = new Card(cards.size());
        cards.add(card);
        return card;
    }

    public Card create(CardList cardList, User assginee){
        Card card = create();
        card.setAssignee(assginee);
        cardList.addCard(card);
        card.setCardList(cardList);
        return card;
    }

    public void delete(int cardId) {
        if(cardId >= 0 && cardId < cards.size() && cards.get(cardId) != null) {
            cards.get(cardId).getCardList().removeCard(cards.get(cardId));
            cards.set(cardId, null);
        }
    }

    public Optional<Card> get(int cardId){
        if(cardId >= 0 && cardId < cards.size() && cards.get(cardId) != null)
            return Optional.of(cards.get(cardId));
        return Optional.empty();
    }

}
