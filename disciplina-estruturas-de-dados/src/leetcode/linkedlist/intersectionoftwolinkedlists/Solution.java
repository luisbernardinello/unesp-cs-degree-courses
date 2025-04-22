package leetcode.linkedlist.intersectionoftwolinkedlists;
//https://leetcode.com/problems/intersection-of-two-linked-lists/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        if(a == null || b == null) return null;
        // If the lists have an intersection, the pointers will meet at the intersection node.
        while (a != b) {
            // if a or b is null we have the end of the list, so we move to the start of the second list
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA:  b.next;
        }
        // a or b pointing to the intersection node or null ( if we dont have intersection)
        return a;

    }

    public static void main(String[] args) {

    }
}
