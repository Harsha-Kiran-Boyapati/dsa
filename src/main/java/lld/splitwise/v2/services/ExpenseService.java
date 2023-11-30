package lld.splitwise.v2.services;

import lld.splitwise.v1.exceptions.InvalidExpenseException;
import lld.splitwise.v2.models.*;

import java.util.*;
import java.util.stream.Collectors;

public class ExpenseService {
    private static Set<Expense> expenses;

    public static List<Expense> getAllExpenses() {
        return expenses.stream().toList();
    }

    public static void addEqualExpense(User payer, double amountPaid, Set<User> receivers) throws InvalidExpenseException {
        expenses.add(new EqualExpense(payer, amountPaid, receivers));
    }

    public static void addExactExpense(User payer, double amountPaid, Map<User, Double> receivers) throws InvalidExpenseException {
        expenses.add(new ExactExpense(payer, amountPaid, receivers));
    }

    public static void addPercentExpense(User payer, double amountPaid, Map<User, Double> receivers) throws InvalidExpenseException {
        expenses.add(new PercentExpense(payer, amountPaid, receivers));
    }

    public List<Expense> getUserExpenses(User user) {
        return expenses.stream().filter((e) -> e.involvesUser(user)).collect(Collectors.toList());
    }

    public List<Owe> getUserBalances(User user) {
        return expensesToOwes(getUserExpenses(user));
    }

    public List<Owe> getAllBalances(){
        return expensesToOwes(getAllExpenses());
    }

    private List<Owe> expensesToOwes(List<Expense> _expenses) {
        HashMap<User, HashMap<User, Double>> balancesMap = new HashMap<>();
        for (Expense expense : _expenses) {
            for (User payee : expense.getLentAmount().keySet()) {
                User lowerUser, higherUser;
                double lowerOwesHigher;
                if (expense.getPayer().getId() < payee.getId()) {
                    lowerUser = expense.getPayer();
                    higherUser = payee;
                    lowerOwesHigher = -expense.getLentAmount().get(payee);
                }else{
                    lowerUser = payee;
                    higherUser = expense.getPayer();
                    lowerOwesHigher = expense.getLentAmount().get(payee);
                }

                balancesMap.computeIfAbsent(lowerUser, (key) -> new HashMap<>());
                balancesMap.get(lowerUser).put(higherUser, balancesMap.get(lowerUser).getOrDefault(higherUser, 0.0)+lowerOwesHigher);
            }
        }
        List<Owe> oweList = new LinkedList<>();
        for(Map.Entry<User, HashMap<User,Double>> lowerUserEntry: balancesMap.entrySet()){
            for(Map.Entry<User, Double> higherUserEntry: lowerUserEntry.getValue().entrySet()){
                oweList.add(new Owe(lowerUserEntry.getKey(), higherUserEntry.getKey(), higherUserEntry.getValue()));
            }
        }
        return oweList;
    }
}
