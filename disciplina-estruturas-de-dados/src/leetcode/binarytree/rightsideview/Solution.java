package leetcode.binarytree.rightsideview;
import java.util.*;
//https://leetcode.com/problems/binary-tree-right-side-view/description/

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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i=0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(4);

        /*
                1
               / \
              2   3
               \    \
                5    4
        */

        System.out.println(solution.rightSideView(root1));

        TreeNode root2 = new TreeNode(1);

        /*
                1
        */

        System.out.println(solution.rightSideView(root2));

        TreeNode root3 = null;

        System.out.println(solution.rightSideView(root3));

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.left.left = new TreeNode(4);
        root4.left.right = new TreeNode(5);
        root4.right.right = new TreeNode(6);
        root4.left.right.left = new TreeNode(7);

        /*
                    1
                  /   \
                 2     3
                / \      \
               4   5      6
                  /
                 7
        */

        System.out.println(solution.rightSideView(root4));
    }
}
