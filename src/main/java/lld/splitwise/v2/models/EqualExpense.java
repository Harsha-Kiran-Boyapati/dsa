package lld.splitwise.v2.models;

import lld.splitwise.v1.exceptions.InvalidExpenseException;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
 @Getter
public class EqualExpense extends Expense {

    public EqualExpense(User payer, double amountPaid, Set<User> receivers) throws InvalidExpenseException {
        super(payer, amountPaid);
        if(receivers.isEmpty())
            throw new InvalidExpenseException("receivers cannot be empty");

       HashMap<User, Double> _lentAmount = new HashMap<>();

       this.lentAmount = _lentAmount;
    }

//    public get


}
