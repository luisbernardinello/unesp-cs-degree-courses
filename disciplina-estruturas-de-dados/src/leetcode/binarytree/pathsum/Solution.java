package leetcode.binarytree.pathsum;
import java.util.*;
//https://leetcode.com/problems/path-sum/
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

// TIme complexity O(n) and Space complexity O(h)
public class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode root, int targetSum) {
        targetSum -= root.val;

        //base case: leaf node
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        boolean left = false, right = false;
        if(root.left != null) {
            left = dfs(root.left, targetSum);
        }

        if(root.right != null) {
            right = dfs(root.right, targetSum);
        }

        return left || right;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int targetSum = 5;
        Solution solution = new Solution();
        System.out.println(solution.hasPathSum(root, targetSum));

    }
}
