package leetcode.linkedlistreversal.reverselinkedlist2;

//https://leetcode.com/problems/reverse-linked-list-ii/description/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // base case
        if(head.next == null) return head;
        if(left == right) return head;
        // define previous and current
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode previous = dummy;
        ListNode current = head;

        // move previous and current into the right position
        for(int i = 1; i < left; i++) {
            previous = current;
            current = current.next;

        }
        // reverse the sublist
        int connections = right - left;
        ListNode currentNext;
        for (int i = 0; i < connections; i++) {
            currentNext = current.next;
            current.next = currentNext.next;// remove currentNext from the list
            currentNext.next = previous.next; // connect the currentNext to the start of our reversal sublist
            previous.next = currentNext; // update the previous to point to the new start
        }

        // return head node
        return dummy.next;
    }
}
