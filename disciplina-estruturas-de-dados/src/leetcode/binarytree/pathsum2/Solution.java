package leetcode.binarytree.pathsum2;
import java.util.*;
//https://leetcode.com/problems/path-sum-ii/
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
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return result;
        dfs(root, targetSum, new LinkedList<>());
        return result;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> path) {
        targetSum -= root.val;
        path.add(root.val);
        // if is a leaf node and if the current sum has reached the target (targetSum = 0)
        if(root.left == null && root.right == null && targetSum == 0) {
            result.add(new LinkedList<>(path));
        }
        else {
            if(root.left != null) {
                dfs(root.left, targetSum, path);
            }
            if(root.right != null) {
                dfs(root.right, targetSum, path);
            }
        }
        // Backtracking
        path.remove(path.size() - 1);
    }


    public static void main(String[] args) {
        //      5
        //     / \
        //    4   8
        //   /   / \
        //  11  13  4
        // /  \    / \
        //7    2  5   1
        // targetSum = 22

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        Solution solution = new Solution();
        List<List<Integer>> paths = solution.pathSum(root, 22);

        System.out.println("Path founded for the target:");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
