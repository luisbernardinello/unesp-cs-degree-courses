package leetcode.binarytree.constructfrompreorderandinorder;
import java.util.*;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
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
    int[] preOrder;
    int[] inOrder;
    Map<Integer, Integer> map = new HashMap<>();
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

    preOrder = preorder;
    inOrder = inorder;
    int n = preOrder.length;
    for (int i = 0; i < n; i++) {
        map.put(inorder[i], i);
    }
    TreeNode root = dfs(0, n - 1);
    return root;

    }

    private TreeNode dfs(int start, int end) {
        //base case
        if (start > end) return null;

        //build the tree node
        int currentValue = preOrder[index++]; //increment before traverse the left subtree
        TreeNode current = new TreeNode(currentValue);

        int mid = map.get(currentValue);

        //build the left subtree
        current.left = dfs(start, mid - 1);

        //build the right subtree
        current.right = dfs(mid + 1, end);

        //return the tree node
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

    static void printPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void main(String[] args) {

        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};

        /*
                3
               / \
              9  20
                 / \
                15  7
        */

        Solution solution = new Solution();
        TreeNode root1 = solution.buildTree(preorder1, inorder1);
        printPreOrder(root1);
        System.out.println();
        printInOrder(root1);
        System.out.println();


    }
}
