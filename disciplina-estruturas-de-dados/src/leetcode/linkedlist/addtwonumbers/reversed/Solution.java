package leetcode.linkedlist.addtwonumbers.reversed;
import java.util.*;
//https://leetcode.com/problems/add-two-numbers/description/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //define the pointers and carry
        ListNode dummy = new ListNode();
        ListNode previous = dummy;
        int carry = 0;

        // while l1 and l2 is not empty
        while (l1 != null || l2 != null) {
            // get current sum += carry over

            int value1 = l1 != null ? l1.val : 0;
            int value2 = l2 != null ? l2.val : 0;

            int sum = value1 + value2 + carry;
            carry = 0;

            // check if current sum is bigger than 9 then increment carry over by one
            if(sum > 9) {
                carry++;
            }

            //create a node with the value of current sum % of the 10
            ListNode currentNode = new ListNode(sum % 10);

            // pre point to current node
            previous.next = currentNode;
            previous = currentNode;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

        }

        if (carry != 0) {
            ListNode currentNode = new ListNode(1);
            previous.next = currentNode;
        }
        return dummy.next;

    }

    static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" <- ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(3);
        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(list1, list2);

        printList(result);
    }
}
