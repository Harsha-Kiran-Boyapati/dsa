package lld.splitwise.v2;

import lld.splitwise.v1.exceptions.InvalidExpenseException;
import lld.splitwise.v2.models.EqualExpense;
import lld.splitwise.v2.models.User;
import lld.splitwise.v2.services.ExpenseService;
import lld.splitwise.v2.services.UserService;

import java.util.Map;
import java.util.Set;

public class Splitwise {
    public static User addUser(String name, String mail, String number) {
        return UserService.addUser(name, mail, number);
    }

    public static EqualExpense addEqualExpense(User payer, double amountPaid, Set<User> receivers) throws InvalidExpenseException {
        ExpenseService.addEqualExpense(payer, amountPaid, receivers);
    }

    public static void addExactExpense(User payer, double amountPaid, Map<User, Double> receivers) throws InvalidExpenseException  {
        ExpenseService.addExactExpense(payer, amountPaid, receivers);
    }
}
