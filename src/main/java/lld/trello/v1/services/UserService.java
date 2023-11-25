package lld.trello.v1.services;

import lld.trello.v1.models.User;

import java.util.ArrayList;
import java.util.Optional;

public class UserService {
    private ArrayList<User> users = new ArrayList<>();

    public User create(String email){
        User user = new User(users.size());
        users.add(user);
        return user;
    }

    public Optional<User> get(int userId){
        return userId>=0 && userId<users.size() ? Optional.ofNullable(users.get(userId)) : Optional.empty();
    }

    public Optional<User> getByEmail(String email) {
        return users.stream().filter(x -> x!=null && x.getEmail().equals(email)).findFirst();
    }

    public void delete(int userId){
        if(userId>=0 && userId<users.size()) users.set(userId, null);
    }
}
