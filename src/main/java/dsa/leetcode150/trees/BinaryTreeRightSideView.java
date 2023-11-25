package dsa.leetcode150.trees;

import dsa.leetcode150.trees.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        //bfs
        if(root == null) return new LinkedList<Integer>();
        LinkedList<TreeNode> curr = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        curr.add(root);
        LinkedList<Integer> ans = new LinkedList<>();

        while(!curr.isEmpty()){
            ans.add(curr.getLast().val);
            for(TreeNode node: curr){
                if(node.left != null) next.add(node.left);
                if(node.right != null) next.add(node.right);
            }
            curr = next;
            next = new LinkedList<>();
        }
        return ans;
    }
}
