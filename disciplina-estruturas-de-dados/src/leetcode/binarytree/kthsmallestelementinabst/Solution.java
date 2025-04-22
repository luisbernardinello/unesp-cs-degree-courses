package leetcode.binarytree.kthsmallestelementinabst;
import java.util.*;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/


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


public class Solution {

//    public int kthSmallest(TreeNode root, int k) {
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode current = root;
//        int count = 0;
//
//        while (!stack.isEmpty() || current != null) {
//            while (current != null) {
//                stack.push(current);
//                current = current.left;
//            }
//
//            current = stack.pop();
//            count++;
//            if (count == k) return current.val;
//            current = current.right;
//        }
//
//        return -1; // This line should never be reached
//    }




        private int count = 0;
        private int result = 0;

        public int kthSmallest(TreeNode root, int k) {
            inorderTraversal(root, k);
            return result;
        }

        private void inorderTraversal(TreeNode node, int k) {
            if (node == null || count >= k) {
                return;
            }

            inorderTraversal(node.left, k);

            count++;
            if (count == k) {
                result = node.val;
                return;
            }

            inorderTraversal(node.right, k);
        }

}
