package leetcode.linkedlist.copylistwithrandompointer;
//https://leetcode.com/problems/copy-list-with-randomo-pointer/
import java.util.*;
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}

public class Solution {

    public Node copyRandomList(Node head) {
        // base case
        if(head == null) {
            return null;
        }

        //define table
        HashMap<Node, Node> map = new HashMap<>();

        //define the current pointer = head;
        Node current = head;
        map.put(current, new Node(current.val));

        //while current pointer != null
        while(current != null) {
            // get the new node of the current pointer
            Node currentClone = map.get(current);

            // build the random pointer if doesn't exists in the table
            if(current.random != null && !map.containsKey(current.random)) {
                map.put(current.random, new Node(current.random.val));
            }
            Node randomClone = map.get(current.random);
            //We associate the clone of the current node (currentClone) with the clone of the node pointed to by random
            // get new current node point to the new random node
            currentClone.random = randomClone;

            // build the next node if doesn't exists in the table ( if the node has not yet been cloned
            if(current.next != null && !map.containsKey(current.next)) {
                map.put(current.next, new Node(current.next.val));
            }
            //We associate the clone of the current node (currentClone) with the clone of the node pointed to next
            Node nextClone = map.get(current.next);
            //get the new currentNode point to the next new node
            currentClone.next = nextClone;

            // corrent pointer move the next node
            current = current.next;


        }

        //return the new head node from the table
        return map.get(head);
    }

    public static void main(String[] args) {

    }
}
