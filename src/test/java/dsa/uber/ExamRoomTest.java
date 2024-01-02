package dsa.uber;

import dsa.companies.uber.ExamRoom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExamRoomTest {

    @Test
    void test() {
        ExamRoom room = new ExamRoom(4);
        assertEquals(0, room.seat());
        assertEquals(3, room.seat());
        assertEquals(1, room.seat());
        assertEquals(2, room.seat());
        room.leave(1);
        room.leave(3);
        assertEquals(1, room.seat());
    }

    @Test
    void test2() {
        ExamRoom room = new ExamRoom(10);
        assertEquals(0, room.seat());
        assertEquals(9, room.seat());
        room.leave(0);
        room.leave(9);
        assertEquals(0, room.seat());
        assertEquals(9, room.seat());
        assertEquals(4, room.seat());
        assertEquals(2, room.seat());
        assertEquals(6, room.seat());
        assertEquals(1, room.seat());
        assertEquals(3, room.seat());
        assertEquals(5, room.seat());
        assertEquals(7, room.seat());
        assertEquals(8, room.seat());
        room.leave(0);
    }
}