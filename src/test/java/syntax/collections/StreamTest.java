package syntax.collections;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamTest {
    @Test
    void mergeTwoStreams() {
        Stream<Integer> stream = Stream.concat(Stream.of(1,2,3), Stream.of(11, 12, 13));
        assertEquals(6, stream.count());
    }

    @Test
    void createAStreamLikeAList() {
        Stream<Integer> stream = Stream.of(1, 2,3);
    }

    @Test
    void sortStream() {
        Stream<Integer> stream = Stream.of(10, 2,3).sorted();
        assertEquals(2, stream.findFirst().orElse(0));
    }

    @Test
    void min() {
        Stream<Integer> stream = Stream.of(10, 2,3);
        assertEquals(2, stream.min(Comparator.comparingInt(x -> x)).orElse(0));
    }

    @Test
    void max() {
        //need to use orElse as min and max returns Optional
        assertEquals(10, Stream.of(10, 2,3).max(Comparator.comparingInt(x -> x)).orElse(0));
    }

    void toArrayTest() {
        //to get int array from stream of integers
        Stream.of(1,2,3).mapToInt(x -> x).toArray();
    };
    void toList() {
        Stream.of(1,2,3).toList();
        Stream.of(1,2,3).collect(Collectors.toList());
    }
    void toCollection() {
        Stream.of(1,2,3).collect(Collectors.toSet());
    }

}
