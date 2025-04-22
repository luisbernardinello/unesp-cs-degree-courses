package leetcode.binarytree.constructfrominorderandpostorder;
import java.util.*;
//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
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
    int[] inOrder;
    int[] postOrder;
    Map<Integer, Integer> map = new HashMap<>();
    int index; // start from n -1
    public TreeNode buildTree(int[] inorder, int[] postorder){
        inOrder = inorder;
        postOrder = postorder;
        int n = inorder.length;
        index = n - 1;

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = dfs(0, n - 1);

        return root;
   }

   private TreeNode dfs(int start, int end) {
        // base case
       if (start > end) return null;

       // build the current node
       int currentValue = postOrder[index--];
       TreeNode current = new TreeNode(currentValue);

       int mid = map.get(currentValue);
       // build the right subtree
       current.right = dfs(mid + 1, end);
       // build the left subtree
        current.left = dfs(start, mid - 1);
       // return the current node
       return current;

   }

    static void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    static void printPostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {

        int[] inorder1 = {9, 3, 15, 20, 7};
        int[] postorder1 = {9, 15, 7, 20, 3};

        /*
                3
               / \
              9  20
                 / \
                15  7
        */

        Solution solution = new Solution();
        TreeNode root1 = solution.buildTree(inorder1, postorder1);
        printInOrder(root1);
        System.out.println();
        printPostOrder(root1);
        System.out.println();


    }

}
