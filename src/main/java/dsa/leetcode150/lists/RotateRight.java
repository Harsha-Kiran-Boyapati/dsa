package dsa.leetcode150.lists;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int len = size(head);
        if(len <=1) return head;
        k = k%len;
        if(k==0) return head;

        ListNode node = head;
        ListNode leftPartitionEndNode=null, rightPartitionStartNode =null, rightPartitionLastNode = null;
        int i=0;
        while(node!=null){
            System.out.println("i - "+i+" val - "+node.val);
            if(i == len-k-1){
                leftPartitionEndNode = node;
                rightPartitionStartNode = node.next;
            }
            if(node.next == null){
                rightPartitionLastNode = node;
                rightPartitionLastNode.next = head;
            }
            node = node.next;
            i++;
        }
        System.out.println("len - "+len+" k - "+k+ " left end ");
        // rightParitionLastNode.next = head;
        // leftPartitionEndNode.next = null;
        return rightPartitionStartNode;
    }

    private int size(ListNode head){
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
