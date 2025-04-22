package leetcode.linkedlist.flattenamultileveldoublylinkedlist;
//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

class Node {
    public int val;
    public Node next;
    public Node prev;
    public Node child;
}
//dfs
public class Solution {

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    // traverse the list and returns the last node (tail)
    private Node dfs(Node node) {
        // previous node to keep the last node
        Node previous = null;

        while (node != null) {
            previous = node;

            if(node.child != null) {

                // change the tail node, process the sublist and return the last node ( process the sublist of the node)
                Node tail = dfs(node.child);
                // the last node of the sublist connected to the next node
                tail.next = node.next;

                // We've updated your `prev` pointer to point to `tail`.
                if(node.next != null) {
                    node.next.prev = tail;
                }

                // change the head node, connecting the node.child to the node
                node.next = node.child;
                node.child.prev = node;

                //remove the pointer
                node.child = null;

                // reset the pointers to keep the same level
                node = tail.next;
                previous = tail;
            } else {
                // If the current node has no sublist, we just move on to the next node.
                node = node.next;
            }
        }
        // return the last node
        return previous;
    }

    public static void main(String[] args) {

    }
}
