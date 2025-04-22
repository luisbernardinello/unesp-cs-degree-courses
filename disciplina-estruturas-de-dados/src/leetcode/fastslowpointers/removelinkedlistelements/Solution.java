package leetcode.fastslowpointers.removelinkedlistelements;
import java.util.*;
//https://leetcode.com/problems/remove-linked-list-elements


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        //base case
        if(head == null) return null;

        //define the pointers
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode previous = dummy;
        ListNode current = head;

        //traverse the list
        while(current != null) {
            if(current.val == val) {
                previous.next = current.next;
                current = previous.next;
            } else {
                previous = current;
                current = current.next;
            }
        }

        //return the head node
        return dummy.next;

    }

    public static void main(String[] args) {

    }
}
