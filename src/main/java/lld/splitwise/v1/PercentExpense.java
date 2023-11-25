package lld.splitwise.v1;

import lld.splitwise.v1.exceptions.InvalidExpenseException;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class PercentExpense {
    private final Map<User, Double> payers;
    private final Map<User, Double> receivers;
    private final Map<User, Double> balance;

    public PercentExpense(Map<User, Double> _payers, Map<User, Double> _receivers) throws InvalidExpenseException {
        payers = _payers; receivers = _receivers;
        balance = new HashMap<>(_payers);
        double percentTotal = _receivers.values().stream().reduce(0.0, Double::sum);
        if(percentTotal != 100.0)
            throw new InvalidExpenseException("percentages does not add to 100");

        for(User user: _receivers.keySet()){
            balance.put(user, balance.getOrDefault(user, 0.0)- _receivers.get(user));
        }
    }
}
