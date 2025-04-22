package leetcode.fastslowpointers.removenthnodefromend;
//https://leetcode.com/problems/remove-nth-node-from-end-of-list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //base case
        if(head == null) return null;
        //define pointers
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        ListNode previous = null;

        //move fast pointer n node ahead of the slow
        for(int i = 0; i < n; i++) {
            fast = fast.next;

        }
        //move both slow and fast pointers in the same speed
        while(fast != null) {
            fast = fast.next;
            previous = slow;
            slow = slow.next;
        }
        previous.next = slow.next;

        //return head
        return dummy.next;


    }

    public static void main(String[] args) {

    }
}
