package dsa.leetcode150.graphs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateDivisionTest {
    @Test
    void test() {
        List<List<String>> equations = List.of(
                List.of("a","b"), List.of("b","c")
        );
        double[] values = new double[]{2.0,3.0};
        List<List<String>> queries = List.of(
                List.of("a","c"),List.of("b","a"),List.of("a","e"),List.of("a","a"),List.of("x","x")
        );
        double[] expected = new double[]{6.00000,0.50000,-1.00000,1.00000,-1.00000};
        assertArrayEquals(expected, new EvaluateDivision().calcEquation(equations,values,queries));
    }

    @Test
    void test2() {
        List<List<String>> equations = List.of(
                List.of("a","b"), List.of("b","c"), List.of("bc","cd")
        );
        double[] values = new double[]{1.5,2.5,5.0};
        List<List<String>> queries = List.of(
                List.of("a","c"),List.of("c","b"),List.of("bc","cd"),List.of("cd","bc")
        );
        double[] expected = new double[]{3.75000,0.40000,5.00000,0.20000};
        assertArrayEquals(expected, new EvaluateDivision().calcEquation(equations,values,queries));
    }
}