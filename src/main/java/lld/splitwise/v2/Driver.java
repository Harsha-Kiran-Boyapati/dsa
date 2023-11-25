package lld.splitwise.v2;

import lld.splitwise.v1.exceptions.InvalidExpenseException;
import lld.splitwise.v2.models.User;

import java.util.Map;
import java.util.Set;

public class Driver {
    public static void main(String[] args) throws InvalidExpenseException {
        User harsha = Splitwise.addUser("harsha", "harsha@gmail.com", "9845760");
        User rohith = Splitwise.addUser("rohith", "rohith@gmail.com", "9845760");
        User praneeth = Splitwise.addUser("praneeth", "praneeth@gmail.com", "9845760");
        User aravind = Splitwise.addUser("aravind", "aravind@gmail.com", "9845760");
        Splitwise.addEqualExpense(harsha, 1000.0, Set.of(harsha, rohith, praneeth, aravind));
        Splitwise.addExactExpense(harsha, 1250.0, Map.of(rohith, 370.0, praneeth, 880.0));
    }
}
