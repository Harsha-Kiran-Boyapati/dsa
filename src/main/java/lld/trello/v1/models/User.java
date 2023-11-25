package lld.trello.v1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {
    private int id;
     @Setter
    String name;
    @Setter
    private String email;
    public User(int _id) {
        id = _id;
    }
}
