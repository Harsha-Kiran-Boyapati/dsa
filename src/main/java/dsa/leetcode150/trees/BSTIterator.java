package dsa.leetcode150.trees;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;

class BSTIterator {
    //node is added to the parent stack if its left subtree is accessed
    private LinkedList<TreeNode> parentStack;
    private TreeNode nextNode;

    public BSTIterator(TreeNode root) {
        TreeNode node = root;
        parentStack = new LinkedList<TreeNode>();
        while(node.left!=null){
            parentStack.push(node);
            node=node.left;
        }
        nextNode = node;
    }

    public int next() {
        if(nextNode == null) return Integer.MAX_VALUE;
        int ans = nextNode.val;
        TreeNode node = nextNode;
        if(node.right != null){
            node = node.right;
            while(node.left!=null){
                parentStack.push(node);
                node = node.left;
            }
        }else if( !parentStack.isEmpty()){
            node = parentStack.pop();
        }else{
            node = null;
        }
        nextNode = node;
        return ans;
    }

    public boolean hasNext() {
        return nextNode != null;
    }
}