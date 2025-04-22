package leetcode.binarytree.recoverybinarytree;

//https://leetcode.com/problems/recover-binary-search-tree/description/

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

    private TreeNode first;
    private TreeNode second;
    private TreeNode prev;

    public void recoverTree(TreeNode root) {
        first = null;
        second = null;
        prev = null;

        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }

        prev = root;

        inorder(root.right);
    }
}