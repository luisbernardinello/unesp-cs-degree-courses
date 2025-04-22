package leetcode.binarytree.kthlargestelementinabst;
import java.util.*;
//https://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

public class Solution {
    static int count = 0;
    static int result = 0;

    static int kthLargest(Node root, int k) {
        count = 0;
        result = 0;
        reversalInorderTraversal(root, k);
        return result;
    }

    static void reversalInorderTraversal(Node root, int k) {
        if (root == null || count >= k)
            return;

        reversalInorderTraversal(root.right, k);

        count++;

        if (count == k) {
            result = root.data;
            return;
        }

        reversalInorderTraversal(root.left, k);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(9);

        System.out.println(kthLargest(root, 4));
    }
}