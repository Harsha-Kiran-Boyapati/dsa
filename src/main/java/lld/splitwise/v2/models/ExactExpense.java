package lld.splitwise.v2.models;

import lld.splitwise.v1.exceptions.InvalidExpenseException;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class ExactExpense extends Expense{
    private Map<User, Double> receivers;
    public ExactExpense(User payer, double amountPaid, @NonNull Map<User, Double> receivers) throws InvalidExpenseException {
        super(payer, amountPaid);
        this.receivers = receivers;

        HashMap<User, Double> _lentAmount =  new HashMap<>();



        this.lentAmount = _lentAmount;
    }
}
