package leetcode.fastslowpointers.middleofthelinkedlist;
//https://leetcode.com/problems/middle-of-the-linked-list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {

    public ListNode middleNode(ListNode head) {
        // base case
        if(head.next == null) return head;

        //define our pointers
        ListNode slow = head;
        ListNode fast = head;

        // traverse of the list
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //return the slow pointer
        return slow;


    }

    public static void main(String[] args) {

    }
}
