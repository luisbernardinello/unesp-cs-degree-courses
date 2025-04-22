package leetcode.binarytree.rightview;
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

    static ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        rightViewUtil(root, list, 0);
        return list;
    }

    static void rightViewUtil(Node root, ArrayList<Integer> list, int level) {
        if (root == null) return;

        if(level == list.size()) {
            list.add(root.data);
        }

        rightViewUtil(root.right, list, level + 1);
        rightViewUtil(root.left, list, level + 1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        System.out.println(rightView(root));

    }

}
