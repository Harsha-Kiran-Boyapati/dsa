package lld.splitwise.v2.models;

import lld.splitwise.v1.exceptions.InvalidExpenseException;

import java.util.HashMap;
import java.util.Map;

public class PercentExpense extends Expense {
    public PercentExpense(User payer, double amountPaid, Map<User, Double> receivers) throws InvalidExpenseException {
        super(payer, amountPaid);
        double percentageSum = receivers.values().stream().reduce(0.0, Double::sum);
        if(percentageSum != 100.0)
            throw new InvalidExpenseException("precentages should sum to huncred");

        this.lentAmount = new HashMap<>();

    }
}
