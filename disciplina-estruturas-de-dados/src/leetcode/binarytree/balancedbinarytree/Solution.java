package leetcode.binarytree.balancedbinarytree;
import java.util.*;
//https://leetcode.com/problems/balanced-binary-tree/

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

// O(n) time, O(h) space
public class Solution {
    final int UNBALANCED = -1;


    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return dfs(root) != UNBALANCED;
    }

    private int dfs(TreeNode root) {
        //Base case: leaf node
        if(root.left == null && root.right == null) return 1;

        //Left Subtree DFS
        int leftHeight = 0;
        if(root.left != null) {
            leftHeight = dfs(root.left);
        }
        if (leftHeight == UNBALANCED) {
            return UNBALANCED;
        }

        //Right Subtree DFS
        int rightHeight = 0;
        if(root.right != null) {
            rightHeight = dfs(root.right);
        }
        if (rightHeight == UNBALANCED) {
            return UNBALANCED;
        }

        //Check the current tree
        if(Math.abs(rightHeight - leftHeight) <= 1) {
            return Math.max(leftHeight, rightHeight) + 1;
        }

        return UNBALANCED;
    }

    public static void main(String[] args) {

    }
}
