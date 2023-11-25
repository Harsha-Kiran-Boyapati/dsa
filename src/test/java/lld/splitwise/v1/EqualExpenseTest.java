package lld.splitwise.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EqualExpenseTest {

    @Test
    void subclasstest() {
        Expense x = new EqualExpense();
        assertEquals(x.getClass(), EqualExpense.class);
        assertInstanceOf(EqualExpense.class, x);
        assertInstanceOf(Expense.class, x);
    }

    @Test
    void pairTest() {
//        Pair
    }
}