package leetcode.binarytree.averageoflevels;
import java.util.*;
//https://leetcode.com/problems/average-of-levels-in-binary-tree/
// this solution uses BFS

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

    static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double averageLevel = 0;
            for (int i=0; i < size; i++) {
                TreeNode first = queue.poll();
                averageLevel += first.val;
                if (first.left != null) {
                    queue.offer(first.left);
                }
                if (first.right != null) {
                    queue.offer(first.right);
                }
            }
            averageLevel = averageLevel / size;
            result.add(averageLevel);
        }
        return result;
    }


    public static void main(String[] args) {
        //3,9,20,15,7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(averageOfLevels(root));
    }

}
