package leetcode.binarytree.serializeanddeserialize2;
import java.util.*;
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    final String X = "X";

    public String serialize(TreeNode root) {
        if (root == null) return X;
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }

    String[] arr;
    int index = 0;
    public TreeNode deserialize(String data) {
        arr = data.split(",");
        return dfs();
    }

    public TreeNode dfs() {
        //base case
        if(arr[index].equals(X)) {
            index++;
            return null;
        }
        // deserialize the current value
        TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));
        // build our left subtree and return its root;
        root.left = dfs();
        // build our right subtree and return its root;
        root.right = dfs();
        return root;
    }

//    public String serialize(TreeNode root) {
//        if (root == null) return "";
//        Queue<TreeNode> q = new LinkedList<>();
//        StringBuilder res = new StringBuilder();
//        q.add(root);
//        while (!q.isEmpty()) {
//            TreeNode node = q.poll();
//            if (node == null) {
//                res.append("n ");
//                continue;
//            }
//            res.append(node.val + " ");
//            q.add(node.left);
//            q.add(node.right);
//        }
//        return res.toString();
//    }
}
