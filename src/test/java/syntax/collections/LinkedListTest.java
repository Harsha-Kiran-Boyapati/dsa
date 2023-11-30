package syntax.collections;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {
    @Test
    void popRemovesLastInsertedElement() {
        LinkedList<Integer> linkedList  = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        assertEquals(1, linkedList.peek());
        assertEquals(2, linkedList.peekLast());
        assertEquals(1, linkedList.peekFirst());
        assertEquals(1, linkedList.getFirst());
    }
}
