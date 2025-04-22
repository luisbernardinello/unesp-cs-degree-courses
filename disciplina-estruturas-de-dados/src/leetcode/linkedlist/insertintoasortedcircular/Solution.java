package leetcode.linkedlist.insertintoasortedcircular;
//https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/

class Node {
    int val;
    Node next;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node next) { this.val = val; this.next = next; }
}
public class Solution {

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);

        if(head == null) { // the only node points to itself
            node.next = node;
            return node; // this ir our head
        }
        Node current = head; // traverse the list
        while(current.next != head) {
            int currentV = current.val;
            int nextVal = current.next.val;
            if(currentV <= insertVal && insertVal <= nextVal) {
                break;
            } else if (currentV > nextVal) {
                if(currentV > insertVal && nextVal > insertVal) {
                    break;
                }
                if(currentV <= insertVal && nextVal <= insertVal) {
                    break;
                }
            }
            current = current.next;
        }
        // swap
        Node temp = current.next;
        current.next = node;
        node.next = temp;
        return head;
    }

    public static void main(String[] args) {

    }
}

