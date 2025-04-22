package leetcode.fastslowpointers.linkedlistcycle;
import java.util.*;
//https://leetcode.com/problems/linked-list-cycle

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public boolean hasCycle(ListNode head) {
        //base case
        if(head == null || head.next == null) return false;
        //define slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        // traverse the list to check if there is a cycle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        //return false if no cycle
        return false;
    }

    public static void main(String[] args) {

    }
}
