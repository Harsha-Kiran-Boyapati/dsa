package lld.splitwise.v2.models;

import lld.splitwise.v1.exceptions.InvalidExpenseException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
public abstract class Expense {

    private  User payer;
    private  double amountPaid;
    protected  Map<User, Double> lentAmount;

    public Expense(User _payer, Double _amountPaid) throws InvalidExpenseException {
        if(_amountPaid == 0.0)
            throw new InvalidExpenseException("amountPaid cannot be zero");
        payer = _payer; amountPaid = _amountPaid;
    }
    public boolean involvesUser(User user){
        return getPayer() == user || getLentAmount().containsKey(user);
    }
}
