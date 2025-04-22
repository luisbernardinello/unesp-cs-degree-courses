package leetcode.binarytree.verticalordertraversal;
import java.util.*;

// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/


 // Definition for a binary tree node.
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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, List<int[]>> xToSortedPairs = new TreeMap<>();

        dfs(root, 0, 0, xToSortedPairs);

        for (List<int[]> pairs : xToSortedPairs.values()) {
            Collections.sort(pairs, (a, b) ->
                    a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
            );

            List<Integer> vals = new ArrayList<>();
            for (int[] pair : pairs) {
                vals.add(pair[1]);
            }
            ans.add(vals);
        }

        return ans;
    }

    private void dfs(TreeNode root, int x, int y, TreeMap<Integer, List<int[]>> xToSortedPairs) {
        if (root == null) return;

        xToSortedPairs.putIfAbsent(x, new ArrayList<>());
        xToSortedPairs.get(x).add(new int[] {y, root.val});

        dfs(root.left, x - 1, y + 1, xToSortedPairs);
        dfs(root.right, x + 1, y + 1, xToSortedPairs);
    }
}