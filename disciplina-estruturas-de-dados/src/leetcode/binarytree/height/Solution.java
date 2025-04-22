package leetcode.binarytree.height;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Solution {

    static int height(Node root) {
        int result = calculateRecursiveHeight(root);
        return result - 1;

    }

    static int calculateRecursiveHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = calculateRecursiveHeight(root.left);
        int rightHeight = calculateRecursiveHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.right = new Node(22);
        root.left = new Node(8);
        root.left.left = new Node(6);
        root.left.right = new Node(7);

        int result = height(root);
        System.out.println(result);

    }
}
