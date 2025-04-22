package leetcode.fastslowpointers.reorderlist;
//https://leetcode.com/problems/palindrome-linked-list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {

    public void reorderList(ListNode head) {
        //base case
        if(head == null || head.next == null) return;
        //define slow and fast pointers

        ListNode slow = head;
        ListNode fast = head;
        ListNode previous = null;
        //slow point the middle node in the list
        while(fast != null && fast.next != null) {
            previous = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        // break the list
        previous.next = null;

        // reverse the last half of the list
        ListNode first = head;
        ListNode second = reverse(slow);

        //reorder the list
        while(first != null && second != null) {
            ListNode nextFirst = first.next;
            ListNode nextSecond = second.next;

            first.next = second;
            second.next = nextFirst == null ? nextSecond : nextFirst;


            first = nextFirst;
            second = nextSecond;
        }
    }

    private ListNode reverse(ListNode head) {
        //base case
        if (head == null || head.next == null) return head;
        //reverse the list
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        return previous;
    }

    public static void main(String[] args) {

    }
}
