package lld.splitwise.v1;

import lld.splitwise.v1.exceptions.InvalidExpenseException;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
public class ExactExpense {
    private final Map<User, Double> payers;
    private final Map<User, Double> receivers;
    private final Map<User, Double> balance;

    public ExactExpense(Map<User, Double> _payers, Map<User, Double> _receivers) throws InvalidExpenseException {
        payers = new HashMap<>(_payers);
        receivers = new HashMap<>(_receivers);
        balance = new HashMap<>(_payers);

        double totalPaid = _payers.values().stream().reduce(0.0, Double::sum);
        double totalReceived = _receivers.values().stream().reduce(0.0, Double::sum);

        if(totalPaid != totalReceived)
            throw new InvalidExpenseException("total paid does not equal total received");

        for(User user: _receivers.keySet()){
            balance.put(user, balance.getOrDefault(user, 0.0)- _receivers.get(user));
        }
    }
}
