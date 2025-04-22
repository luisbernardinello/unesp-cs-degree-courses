package leetcode.binarysearchtree.inordersucessorinbst;
//https://leetcode.com/problems/inorder-sucessor-in-bst/description/
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

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;

        TreeNode current = root;
        TreeNode previous = null;

        while (current != null) {
            if(current.val > p.val) {
                previous = current;
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
        return previous;
    }

}
