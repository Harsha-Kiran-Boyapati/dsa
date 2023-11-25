package lld.splitwise.v1;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Expense {
    @Getter @Setter @NonNull
    private Set<User> users;
//    private HashMap<User, Float> expense;
    private HashMap<User, Float> balance;

    //returns how much each user has net lent as part of this expense
    public abstract Map<User, Double> getBalance();
    public boolean involvesUser(User user){
        return getBalance().containsKey(user);
    }

}
