package leetcode.linkedlist.mergeksortedlists;
import java.util.*;
//https://leetcode.com/problems/merge-k-sorted-lists/description/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //define the min heap;
        Queue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);

        for (ListNode node : lists) {
            if(node == null) continue;
            minHeap.add(node); // add the first node of each list
        }

        ListNode dummy = new ListNode(); // to build our result list
        ListNode current = dummy;

        while(!minHeap.isEmpty()) { // remove the smallest node, add this node to the result list, connecting the next to this node
            ListNode top = minHeap.poll(); // remove the smallest node from the heap
            current.next = top; // add the node to the result list
            current = current.next;  // move the pointer to the next node

            if(top.next != null) {
                minHeap.add(top.next); // add the next node from the list to the heap
            }
        }
        return dummy.next;
    }
}
