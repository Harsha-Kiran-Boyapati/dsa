package dsa.leetcode150.trees;

import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthSmallestInBSTTest {

    @Test
    void kthSmallest() {
        TreeNode root = new TreeNode();
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        assertEquals(1,new KthSmallestInBST().kthSmallest(root, 1));
    }
}