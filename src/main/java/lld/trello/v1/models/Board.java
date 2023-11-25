package lld.trello.v1.models;

import lombok.*;

import java.util.HashMap;
import java.util.HashSet;

@Getter
@Setter
//@Builder
@NoArgsConstructor
public class Board {


    public static enum Privacy{
        PUBLIC, PRIVATE
    }
    private int id;

    @Getter @Setter
    private String name;
    private Privacy privacy = Privacy.PUBLIC;
//    private String url;
    private HashSet<User> members = new HashSet<>();
    private HashSet<CardList> cardLists = new HashSet<>();

    public Board(int _id){
        id = _id;
    }

    public String getUrl(){ return "/boards/"+id; }

    public void addMember(User user){ members.add(user); }
    public void removeMember(User user){ members.remove(user); }

    private boolean containsCardList(CardList cardList){
        return cardLists.contains(cardList);
    }

    public void moveCard(CardList source, CardList destination, Card card){
        if(containsCardList(source) && containsCardList(destination) && source.containsCard(card)){
            source.removeCard(card);
            destination.addCard(card);
        }
    }

    public void removeCardList(@NonNull CardList cardList) {
        cardLists.remove(cardList);
    }
}
