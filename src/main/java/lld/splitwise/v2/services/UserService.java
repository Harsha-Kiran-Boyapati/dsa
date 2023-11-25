package lld.splitwise.v2.services;

import lld.splitwise.v2.models.User;

import java.util.HashSet;

public class UserService {
    private static HashSet<User> users = new HashSet<>();
    private static int lastUserId = 0;
    public static User addUser(String name, String mail, String number) {
        User user = new User(++lastUserId, name, mail, number);
        users.add(user);
        return user;
    }
}
