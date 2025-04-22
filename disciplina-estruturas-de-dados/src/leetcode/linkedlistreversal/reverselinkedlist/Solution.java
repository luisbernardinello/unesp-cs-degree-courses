package leetcode.linkedlistreversal.reverselinkedlist;

//https://leetcode.com/problems/reverse-linked-list/description/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public ListNode reverseList(ListNode head) {
        //base case
        if (head == null) return null;

        //define current and previous pointers
        ListNode current = head;
        ListNode previous = null;

        // while current is not null, we continue to traverse the list
        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;

        }

        // return previous
        return previous;


    }
}
