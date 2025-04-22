package leetcode.linkedlistreversal.rotatelist;

//https://leetcode.com/problems/rotate-list/description/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        // base case
        if(head == null || head.next == null) return head;
        // define the previous and current
        ListNode previous = null;
        ListNode current = head;
        int size = 0;

        // connect the tail node to the head node
        while(current != null) {
            previous = current; // previous will be the tail node
            current = current.next;
            size++;
        }
        // make it circular
        current = head;
        previous.next = current;

        // determine how many times we have to rotate
        int rotate = k % size; // this because the cyclic nature of the problem, rotate we dont want to get the rotations that exceed the size
        //determine where is the new head
        int location = size - rotate;
        // delete the connection between previous and head
        for(int i = 0; i < location; i++) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        //return the new head
        return current;
    }
}
