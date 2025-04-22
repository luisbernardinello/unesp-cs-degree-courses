package leetcode.binarytree.inordertraversal;
import java.util.*;
//

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

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        inorderTraversalRecursiveHelper(root, result);
        return result;
    }

    public void inorderTraversalRecursiveHelper(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return;

        inorderTraversalRecursiveHelper(root.left, result);
        result.add(root.val);
        inorderTraversalRecursiveHelper(root.right, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(18);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(16);
        root.left.right = new TreeNode(19);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(23);

        Solution solution = new Solution();
        System.out.println(solution.inorderTraversalRecursive(root));
        System.out.println(solution.inorderTraversal(root));
    }
}
