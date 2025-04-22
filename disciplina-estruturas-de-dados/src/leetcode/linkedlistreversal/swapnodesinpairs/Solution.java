package leetcode.linkedlistreversal.swapnodesinpairs;

//https://leetcode.com/problems/swap-nodes-in-pairs/description/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Solution {

    public ListNode swapPairs(ListNode head) {
        //base case
        if(head == null || head.next == null) return head;

        //define previous and current
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode previous = dummy;
        ListNode current = head;

        //swap nodes
        while(current != null && current.next != null) {
            ListNode tempNext = current.next;
            current.next = tempNext.next;
            tempNext.next = previous.next;
            previous.next = tempNext;

            // move current and previous one to the right
            previous = current;
            current = current.next;
        }

        // return the head node
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
