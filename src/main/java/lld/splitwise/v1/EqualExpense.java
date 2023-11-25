package lld.splitwise.v1;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
@NoArgsConstructor
public class EqualExpense extends Expense {
    private Map<User, Double> payers;
    private Set<User> receivers;
    private Map<User, Double> balance;

    public EqualExpense(Map<User, Double> _payers, Set<User> _receivers) {
        payers = _payers; receivers = _receivers;
        balance = new HashMap<>();
        double total = payers.values().stream().reduce(0.0, Double::sum);
        double individualAmountReceived = total/receivers.size();

        balance.putAll(payers);
        for(User user: receivers){
            balance.put(user, balance.getOrDefault(user, 0.0)-individualAmountReceived);
        }
    }
}