package leetcode.linkedlist.sortlist;
//https://leetcode.com/problems/sort-list/description/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {

    public ListNode sortList(ListNode head) {
        //base caes
        if(head == null || head.next == null) return head;

        //this approach uses the merge sort

        // split in the middle
        ListNode list1 = head;
        ListNode list2 = splitMiddleNode(head);

        // sort the left list
        list1 = sortList(list1);

        //sort the right list

        list2 = sortList(list2);

        // merge to lists together
        ListNode dummy = new ListNode();
        ListNode result = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                result.next = list1;
                list1 = list1.next; //move to the right
            } else {
                result.next = list2;
                list2 = list2.next;
            }
            result = result.next;
        }
        // the lists could have different sizes, so we have to add the remaining nodes at the end of our new list
        //If one of the lists has been completely traversed,
        // the other list is already sorted and its nodes can simply be connected to the end of the new sorted list.
        if(list2 != null) {
            result.next = list2;
        } else {
            result.next = list1;
        }

        // return the head node
        return dummy.next;


    }

    private ListNode splitMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode previous = null;

        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        previous.next = null;
        return slow;
    }

    public static void main(String[] args) {

    }
}
