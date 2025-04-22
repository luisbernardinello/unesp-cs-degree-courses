package leetcode.fastslowpointers.linkedlistcycle2;
import java.util.*;

//https://leetcode.com/problems/linked-list-cycle-ii

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {

    public ListNode detectCycle(ListNode head) {
        //base case
        if (head == null || head.next == null) return null;
        //define the pointers
        ListNode slow = head;
        ListNode fast = head;

        //check if there is a cycle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                //find the len of the cycle
                int length = findLength(slow);
                //find the head node of the cycle
                return getHeadNode(length, head);
            }
        }

        //no cycle returns null
        return null;
    }

    private int findLength(ListNode node) {
        ListNode temp = node.next;
        int size = 1;

        while(temp != null) {
            temp = temp.next;
            size++;
        }
        return size;

    }

    private ListNode getHeadNode(int length, ListNode head) {
        //define the pointers
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        // pointer2 move length ahead of pointer1
        for(int i = 0; i < length; i++) {
            pointer2 = pointer2.next;
        }
        while(pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        //return the head
        return pointer1;
    }

    public static void main(String[] args) {

    }
}
