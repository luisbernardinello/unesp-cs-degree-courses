package leetcode.twopointers.removeduplicateslist2;
import java.util.*;
//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
//O(n) and O(1) in space

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        // base case
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            if(current.next != null && current.val == current.next.val) {
                while(current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
