package leetcode.binarytree.binarytreetodllmorris;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}

public class Solution {

    static Node bToDLLMorrisAlgorithm(Node root) {

        if (root == null) return null;

        Node head = null;
        Node tail = null;
        Node current = root;

        while (current != null) {

            // if left tree does not exists,
            // then add the current node to the
            // dll and set current = current.right
            if (current.left == null) {
                if (head == null) {
                    head = tail = current;
                } else {
                    tail.right = current;
                    current.left = tail;
                    tail = current;
                }
                current = current.right;
            } else {
                Node predecessor = current.left;

                //find the inorder predecessor
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                //create a linkage between predecessor and current
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                }

                // if predecessor.right = current, it means we have processed the left subtree, and we can add current node to list
                else {
                    tail.right = current;
                    current.left = tail;
                    tail = current;

                    current = current.right;
                }
            }
        }

        return head;
    }

    static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create a hard coded binary tree
        //          10
        //         /  \
        //       12    15
        //      / \    /
        //     25 30  36
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);

        Node head = bToDLLMorrisAlgorithm(root);

        printList(head);
    }
}
