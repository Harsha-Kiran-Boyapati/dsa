package dsa.leetcode150.trees;

class Reply{
    boolean found = false;
    int numNodes = 0;
    int ans = 0;
    Reply(){}
    Reply notFound(int numNodes){
        this.numNodes = numNodes;
        this.found = false;
        return this;
    }

    Reply found(int ans){
        this.found = true; this.ans = ans;
        return this;
    }
}

public class KthSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        Reply reply = helper(root,k);
        return reply.ans;
    }

    private Reply helper(TreeNode node, int k){
        int leftNodeCount = 0;
        int rightNodeCount=0;

        if(node.left!=null){
           Reply leftReply = helper(node.left, k);
            if(leftReply.found) return leftReply;
            leftNodeCount = leftReply.numNodes;

        }
        if(leftNodeCount+1 == k) return new Reply().found(node.val);
        if(node.right!=null){
            Reply rightReply = helper(node.right, k-1-leftNodeCount);
            if(rightReply.found) return rightReply;
           rightNodeCount = rightReply.numNodes;
        }
        return new Reply().notFound(leftNodeCount+rightNodeCount+1);
    }
}

