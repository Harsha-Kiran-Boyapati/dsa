package syntax.collections;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

//linked list already acts as a stack  - push, pop, peek
public class StackTest {
    @Test
    public void test(){
        LinkedList<Integer> s  = new LinkedList<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        assertEquals(4, s.pop());
        s.push(5);
        assertEquals(5, s.pop());

        assertFalse(s.isEmpty());
        assertEquals(3, s.peek());

    }
}
