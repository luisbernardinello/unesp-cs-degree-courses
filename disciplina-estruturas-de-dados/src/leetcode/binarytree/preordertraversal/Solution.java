package leetcode.binarytree.preordertraversal;
import java.util.*;
//https://leetcode.com/problems/binary-tree-preorder-traversal/description/
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
    List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return result;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        result.add(root.val);
        helper(root.left);
        helper(root.right);
    }

    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //base case
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();

        //add head node
        stack.add(root);

        while(!stack.isEmpty()) {
            TreeNode top = stack.pop();

            //add the current node to the list
            result.add(top.val);
            //add the right node onto the stack
            if(top.right != null) {
                stack.add(top.right);
            }
            //add the left node onto the stack
            if(top.left != null) {
                stack.add(top.left);
            }
        }
        return result;
    }


}
