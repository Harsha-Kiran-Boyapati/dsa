package dsa.leetcode150.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskSchedulerTest {

    @Test
    void test1() {
        char[] tasks = new char[]{'A','A','A','B','B','B'};
        int actual = new TaskScheduler().leastInterval(tasks, 2);
        int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        char[] tasks = new char[]{'A','A','A','B','B','B'};
        int actual = new TaskScheduler().leastInterval(tasks, 0);
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        char[] tasks = new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'};
        int actual = new TaskScheduler().leastInterval(tasks, 2);
        int expected = 16;
        assertEquals(expected, actual);
    }
}