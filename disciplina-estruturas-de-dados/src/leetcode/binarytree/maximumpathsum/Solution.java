package leetcode.binarytree.maximumpathsum;
import java.util.*;
//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
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

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        // Base case
        if (node == null) {
            return 0;
        }

        //Left
        int left = Math.max(0, dfs(node.left));
        //Right
        int right = Math.max(0, dfs(node.right));

        int pathSum = left + right + node.val;

        maxSum = Math.max(maxSum, pathSum);

        return Math.max(left, right) + node.val;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        /*
                -10
                /  \
               9   20
                  /  \
                 15   7
        */

        Solution solution = new Solution();
        System.out.println("Maximum Path Sum: " + solution.maxPathSum(root));
    }

}
