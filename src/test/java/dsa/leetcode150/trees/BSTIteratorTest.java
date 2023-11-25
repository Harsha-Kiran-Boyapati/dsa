package dsa.leetcode150.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTIteratorTest {

    @Test
    public void test(){
        TreeNode three = new TreeNode(3);
        TreeNode seven = new TreeNode(7);
        TreeNode fifteen = new TreeNode(15);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        fifteen.left = nine; fifteen.right=twenty;
        seven.left = three; seven.right=fifteen;

        BSTIterator itr = new BSTIterator(seven);
        assertEquals(3, itr.next());
        assertEquals(7, itr.next());
        assertTrue(itr.hasNext());
        assertEquals(9, itr.next());
        assertTrue(itr.hasNext());
        assertEquals(15, itr.next());
        assertTrue(itr.hasNext());
        assertEquals(20, itr.next());
        assertFalse(itr.hasNext());
    }


}