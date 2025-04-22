package leetcode.binarytree.levelordersucessor;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    //bfs
    // google question
    static TreeNode findSuccessor(TreeNode root, int key){
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
            if (currentNode.val == key) {
                break;
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        /*
                1
               / \
              2   3
             / \ / \
            4  5 6  7
        */

        System.out.println("Sucessor de 1: " + (findSuccessor(root, 1) != null ? findSuccessor(root, 1).val : "null"));
        System.out.println("Sucessor de 2: " + (findSuccessor(root, 2) != null ? findSuccessor(root, 2).val : "null"));
        System.out.println("Sucessor de 3: " + (findSuccessor(root, 3) != null ? findSuccessor(root, 3).val : "null"));
        System.out.println("Sucessor de 7: " + (findSuccessor(root, 7) != null ? findSuccessor(root, 7).val : "null"));
        System.out.println("Sucessor de 5: " + (findSuccessor(root, 5) != null ? findSuccessor(root, 5).val : "null"));


    }
}
