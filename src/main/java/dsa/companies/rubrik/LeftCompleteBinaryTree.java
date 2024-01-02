package dsa.companies.rubrik;

import dsa.leetcode150.trees.TreeNode;

public class LeftCompleteBinaryTree {

    public void insert(TreeNode root, int val){
        int totalDepth = depth(root);
        if(rightDepth(root) == totalDepth){
            //insert in a new layer
            TreeNode node = root;
            while(true){
                if(node.left == null){node.left = new TreeNode(val); break;}
                else{node = node.left;}
            }
        }
        //find total depth
        //what will be the path of new node
        //eg root left left right left right left
        //there are 2^d-1 possiblities
        //given two subtrees if there is a place at the final level in left subtree, then place it in left subtree
        TreeNode parent = root;
        for(int parentDepth=1; parentDepth<totalDepth-1; parentDepth++){
            int rDepthLeftSubTree = rightDepth(parent.left);
            if(rDepthLeftSubTree+parentDepth == totalDepth){
                parent = root.right;
            }else parent = root.left;
        }
        if(parent.left == null) parent.left = new TreeNode(val);
        else parent.right = new TreeNode(val);
    }

    private int depth(TreeNode node){
        return node==null ? 0: 1+depth(node.left);
    }

    private int leftDepth(TreeNode node){
        return node==null ? 0: 1+depth(node.left);
    }
    private int rightDepth(TreeNode node){
        return node==null ? 0: 1+depth(node.right);
    }
}
