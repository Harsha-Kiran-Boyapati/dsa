package syntax;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class OptionalTest {
    @Test
    void commonMethods() {
        Optional<Integer> optional = Optional.empty();
        optional.isPresent();
        optional.isPresent();
    }

    @Test
    void getOrDefault() {
        Optional<Integer> optional = Optional.empty();
        assertEquals(2, optional.orElse(2));
        assertTrue(Optional.empty().orElseGet(LinkedList::new) instanceof List); // can also use a function to gen
    }

    @Test
    void throwExceptionIfEmpty() {
        assertThrows(Exception.class, () -> Optional.empty().orElseThrow());
        assertThrows(NoSuchElementException.class, () -> Optional.ofNullable(null).orElseThrow());
    }
}
