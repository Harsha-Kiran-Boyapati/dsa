package lld.splitwise.v2.services;

import lld.splitwise.v1.exceptions.InvalidExpenseException;
import lld.splitwise.v2.models.*;

import java.util.Map;
import java.util.Set;

public class ExpenseService {
    private static Set<Expense> expenses;
    public static Set<Expense> getAllExpenses(){return expenses;}

    public static void addEqualExpense(User payer, double amountPaid, Set<User> receivers) throws InvalidExpenseException {
        expenses.add(new EqualExpense(payer, amountPaid, receivers));
    }

    public static void addExactExpense(User payer, double amountPaid, Map<User, Double> receivers) throws InvalidExpenseException {
        expenses.add(new ExactExpense(payer, amountPaid, receivers));
    }

    public static void addPercentExpense(User payer, double amountPaid, Map<User, Double> receivers) throws InvalidExpenseException {
        expenses.add(new PercentExpense(payer, amountPaid, receivers));
    }
}
