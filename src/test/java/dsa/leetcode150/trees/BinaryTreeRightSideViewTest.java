package dsa.leetcode150.trees;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeRightSideViewTest {

    @Test
    void rightSideView() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        List<Integer> expected = List.of(1,3,5);
        List<Integer> actual = new BinaryTreeRightSideView().rightSideView(root);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}