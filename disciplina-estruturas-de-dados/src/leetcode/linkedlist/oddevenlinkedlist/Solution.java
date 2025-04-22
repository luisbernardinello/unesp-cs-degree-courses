package leetcode.linkedlist.oddevenlinkedlist;
//https://leetcode.com/problems/odd-even-linked-list/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public ListNode oddEvenList(ListNode head) {
        //base case
        if(head == null || head.next == null) return head;

        //define head node of OddList & EvenList
        ListNode oddList = head;
        ListNode evenList = head.next;

        //define currentOdd and currentEven
        ListNode currentOdd = oddList;
        ListNode currentEven = evenList;

        // while currentOdd and currentEven is not Null
        while(currentOdd != null && currentEven != null) {
            // currentOdd.next = currentEven.next,  then currentOdd = currentOdd.next
            currentOdd.next = currentEven.next;
            currentOdd = currentOdd.next;

            // currentEven.next = curerentOdd.next, then currentEven = currentEven.next
            currentEven.next = currentOdd.next;
            currentEven = currentEven.next;


        }
        // tail Node of OddList of currentOdd.next = head node of the even list
        currentOdd.next = evenList;
        //return the head of odd list
        return oddList;
    }


    public static void main(String[] args) {

    }
}
