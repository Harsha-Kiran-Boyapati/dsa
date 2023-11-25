package lld.splitwise.v1;

import lombok.NonNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public  class ExpenseService {
//    public static HashMap<Integer, Expense> expenses = new HashMap<>();

    private static final HashSet<Expense> expenses = new HashSet<>();
    public static Set<Expense> getUserExpenses(@NonNull User user){
        return expenses.stream().filter(e -> e.involvesUser(user)).collect(Collectors.toSet());
    }

    public static Set<Expense> getAllExpenses(){return expenses;}


}
