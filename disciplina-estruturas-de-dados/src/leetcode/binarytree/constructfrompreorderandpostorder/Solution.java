package leetcode.binarytree.constructfrompreorderandpostorder;
import java.util.*;
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/
// Always remember Tree Traversal
// Serialize Tree => string can be used as a key
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

// if the current index < previousindex, the current node is child node of the previous node
// otherwiser the current node is not child of the previous node

public class Solution {
    int[] preorderArray;
    int[] postorderArray;
    Map<Integer, Integer> map = new HashMap<>();
    int index = 0;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        //Build the table
        preorderArray = pre;
        postorderArray = post;
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i); // values as the key e index as the value
        }
        return dfs(pre.length);
    }

    private TreeNode dfs(int previousIndex) {
        if(index >= preorderArray.length) return null;

        int currentVal = preorderArray[index];
        int currentIndex = map.get(currentVal);

        if (previousIndex < currentIndex) {
            return null;
        }
        // the current node is child of the previous node
        index++;
        TreeNode root = new TreeNode(currentVal);
        root.left = dfs(currentIndex);
        root.right = dfs(currentIndex);

        return root;
    }

    private static void printPreOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder1 = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder1 = {4, 5, 2, 6, 7, 3, 1};
        TreeNode root1 = solution.constructFromPrePost(preorder1, postorder1);
        printPreOrder(root1);
    }
}
