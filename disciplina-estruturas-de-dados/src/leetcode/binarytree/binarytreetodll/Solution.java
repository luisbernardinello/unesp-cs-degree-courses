package leetcode.binarytree.binarytreetodll;

//https://www.geeksforgeeks.org/convert-given-binary-tree-to-doubly-linked-list-in-linear-time/
class Solution {
    private Node prev = null;
    private Node head = null;



    public Node bToDLL(Node root) {
        if (root == null) return null;

        inorder(root);
        return head;
    }

    private void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);

        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        inorder(root.right);
    }

    private void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);

        /*
              10
             /  \
           12    15
          /  \   /
         25  30 36
        */

        Solution solution = new Solution();
        Node dll = solution.bToDLL(root);

        System.out.println("result:");
        solution.printList(dll);

        solution.prev = null;
    }
}

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}