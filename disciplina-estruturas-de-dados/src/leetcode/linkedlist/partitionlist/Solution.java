package leetcode.linkedlist.partitionlist;
import java.util.*;
//https://leetcode.com/problems/partition-list/description/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public ListNode partition(ListNode head, int x) {
        //base case
        if(head == null || head.next == null) return head;

        //define the pointers
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        ListNode low = dummy1;
        ListNode high = dummy2;

        ListNode current = head;

        while(current != null) {
            if(current.val < x) {
                low.next = current;
                low = current;
            } else {
                high.next = current;
                high = current;
            }
            current = current.next;
        }

        // connecting the two pointers
        low.next = dummy2.next; // the end of the low sublist to the beginning of the high sublist
        high.next = null;

        // return the head node
        return dummy1.next;
    }

    public static void main(String[] args) {

    }
}
