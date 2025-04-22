package leetcode.binarytree.leftview;
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

    static ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        leftViewUtil(root, list, 0);
        return list;
    }

    static void leftViewUtil(Node root, ArrayList<Integer> list, int level) {
        if (root == null) return;

        if (level == list.size()) {
            list.add(root.data);
        }

        leftViewUtil(root.left, list, level + 1);
        leftViewUtil(root.right, list, level + 1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(leftView(root));
    }
}
