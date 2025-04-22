package leetcode.binarytree.binarytreetocirculardll;

//https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/description/
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};


class Solution {
    // This 'previous' node will help in keeping track of the previously processed node in the inorder traversal
    private Node previous;

    // The 'head' node will serve as the head of the doubly linked list
    private Node head;

    // Convert a binary search tree to a sorted, circular, doubly-linked list
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null; // If the tree is empty, there is nothing to process or convert
        }

        // Initialize 'previous' and 'head' as null before the depth-first search
        previous = null;
        head = null;

        // Start the inorder traversal from the root to convert the BST into a sorted list
        inorderTraversal(root);

        // After the traversal, connect the last node with the 'head' to make it circular
        previous.right = head;
        head.left = previous;

        return head; // Return the head of the doubly linked list
    }

    // Inorder traversal of the binary search tree
    private void inorderTraversal(Node node) {
        if (node == null) {
            return; // Base case for the recursive function, stop if the current node is null
        }

        // Recursively process the left subtree
        inorderTraversal(node.left);

        // In the inorder traversal, 'previous' will be null only for the leftmost node
        if (previous != null) {
            // Connect the previous node's right to the current node
            previous.right = node;

            // Connect the current node's left to the previous node
            node.left = previous;
        } else {
            // If 'previous' is null, it means we are at the leftmost node which is the 'head' of the list
            head = node;
        }

        // Update 'previous' to be the current node before moving to the right subtree
        previous = node;

        // Recursively process the right subtree
        inorderTraversal(node.right);
    }


    public void printList(Node head) {
        if (head == null) return;

        Node current = head;

        do {
            System.out.print(current.val + " ");
            current = current.right;
        } while (current != head);
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
        Node dll = solution.treeToDoublyList(root);

        System.out.println("Doubly Linked List (Circular):");
        solution.printList(dll);
    }
}

