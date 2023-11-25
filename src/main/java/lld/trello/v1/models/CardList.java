package lld.trello.v1.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;

@Getter
public class CardList {
    private int id;
    @Getter @Setter
    private String name;
    @Getter
    private HashSet<Card> cards = new HashSet<>();
    @NonNull @Getter @Setter
    private Board board;

    public CardList(int _id) {
        this.id = _id;
    }
    public String getUrl(){ return "/CardLists/"+id; }

    public boolean containsCard(@NonNull Card card){
        return cards.contains(card);
    }

    public void removeCard(@NonNull Card card){
        cards.remove(card);
    }

    public void addCard(@NonNull Card card){
        cards.add(card);
        card.setCardList(this);
    }
}
