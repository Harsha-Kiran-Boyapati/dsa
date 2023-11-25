package lld.trello.v1.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Optional;


public class Card {
    @Getter
    private final int id;
    @Getter @Setter
    private String name = "";
    @Getter @Setter
    private String description = "";
    @Setter
    private User assignee;

    @Getter @Setter @NonNull
    private CardList cardList;

    public Card(int _id) {
        this.id = _id;
    }
    public String getUrl(){ return "/Cards/"+id; }

    public Optional<User> getAssignee(){ return Optional.ofNullable(assignee); }


}
