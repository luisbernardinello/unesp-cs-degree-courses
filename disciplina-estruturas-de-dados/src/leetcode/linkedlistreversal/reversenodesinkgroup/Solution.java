package leetcode.linkedlistreversal.reversenodesinkgroup;
//https://leetcode.com/problems/reverse-nodes-in-k-group/description/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        //base case
        if(head.next == null) return head;
        if(k == 1) return head;

        // define previous and current pointers
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode previous = dummy;
        ListNode current = head;

        //reverse the list

        while(current != null) {
            //check the space
            boolean space = checkHasSpace(k, current);
            if(space) {
                previous = reverse(previous, current, k);
                current = previous.next;
            } else {
                break;
            }
        }

        //return the head
        return dummy.next;
    }

    private boolean checkHasSpace(int k, ListNode current) {
        for(int i = 1; i <= k; i++) {
            if (current == null) return false;
            current = current.next;
        }
        return true;
    }

    private ListNode reverse(ListNode previous, ListNode current, int k) {
        for(int i = 0; i < k - 1; i++) {
            ListNode tempNext = current.next;
            current.next = tempNext.next; // pointing to the next node of tempNext (skip the tempNext)
            tempNext.next = previous.next; // tempNext is the new start
            previous.next = tempNext; // add the tempNext to the start
        }
        return current;
    }
}
