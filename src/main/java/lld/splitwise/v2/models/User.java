package lld.splitwise.v2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String email;
    private String number;
}
