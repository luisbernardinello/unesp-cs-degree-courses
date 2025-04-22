package leetcode.binarytree.lowestcommonancestor;
import java.util.*;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
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

// O(n) time complexity and O(h) space complexity
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // we found p and q in left and right
        if (left != null && right != null) {
            return root;
        }
        // otherwise we return the left or the right
//        return left == null ? right : left;
        if (left != null) {
            return left;
        }

        return right;

    }


//    static Node lca(Node root, int n1, int n2) {
//
//        if (root == null) {
//            return null;
//        }
//
//        // If either key matches with root data, return root
//        if (root.data == n1 || root.data == n2) {
//            return root;
//        }
//
//        // Look for keys in left and right subtrees
//        Node leftLca = lca(root.left, n1, n2);
//        Node rightLca = lca(root.right, n1, n2);
//
//        // If both left and right subtrees return a non-null value,
//        // this node is the LCA
//        if (leftLca != null && rightLca != null) {
//            return root;
//        }
//
//        // Return whichever subtree has the LCA (or null if neither does)
//        if (leftLca != null) {
//            return leftLca;
//        }
//
//        return rightLca;
//
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(8);

        /*
                3
               / \
              5   1
             / \  / \
            6  2 0   8
              / \
             7   4
        */

        TreeNode p1 = root1.left;
        TreeNode q1 = root1.left.right.right;

        TreeNode lca1 = solution.lowestCommonAncestor(root1, p1, q1);
        System.out.println("LCA: " + p1.val + " and " + q1.val + ": " + (lca1 != null ? lca1.val : "null"));

    }

}
