package leetcode.binarytree.symmetrictree;
import java.util.*;
// https://leetcode.com/problems/symmetric-tree/
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
//bfs

public class Solution {

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null) {
                continue;
            }

            if(left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);

        }
        return true;
    }

    public boolean isSymmetricRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricRecursiveHelper(root.left, root.right);
    }

    private boolean isSymmetricRecursiveHelper(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left != null && right != null) {
            return left.val == right.val && isSymmetricRecursiveHelper(left.left, right.right) && isSymmetricRecursiveHelper(left.right, right.left);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);

        /*
                1
               / \
              2   2
             / \ / \
            3  4 4  3
        */

        System.out.println(solution.isSymmetric(root1));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);

        /*
                1
               / \
              2   2
               \    \
                3    3
        */

        System.out.println(solution.isSymmetric(root2));




    }

}
