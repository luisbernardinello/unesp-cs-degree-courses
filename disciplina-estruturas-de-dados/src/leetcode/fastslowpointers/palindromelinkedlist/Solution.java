package leetcode.fastslowpointers.palindromelinkedlist;
//https://leetcode.com/problems/palindrome-linked-list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {

    public boolean isPalindrome(ListNode head) {
        //base case
        if(head == null || head.next == null) return true;
        //define our pointers
        ListNode slow = head;
        ListNode fast = head;

        //move slow and fast in the right position
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse the last half of the list
        ListNode left = head;
        ListNode right = reverse(slow); // slow as a head of the second part of the list

        //check if is palindrome
        while(right != null) {
            if(left.val == right.val) {
                left = left.next;
                right = right.next;
            } else {
                return false;
            }
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        //base case
        if(head == null || head.next == null) return head;

        //reverse
        ListNode previous = null;
        ListNode current = head;

        while(current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }
}
