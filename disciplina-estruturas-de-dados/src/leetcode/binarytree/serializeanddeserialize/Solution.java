package leetcode.binarytree.serializeanddeserialize;
import java.util.*;
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
 }


public class Solution {

    static List<String> serialize(TreeNode node) {
        List<String> list = new ArrayList<>();
        helper(node, list);
        return list;
    }
    static void helper(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("null");
            return;
        }

        list.add(String.valueOf(node.val));

        helper(node.left, list);
        helper(node.right, list);
    }

    static TreeNode deserialize(List<String> list) {
        Collections.reverse(list);
        TreeNode node = helper(list);
        return node;
    }
    static TreeNode helper(List<String> list) {
        String val = list.remove(list.size() - 1);

        if (val.charAt(0) == 'n') {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left = helper(list);
        node.right = helper(list);

        return node;
    }

    static void printPreOrder(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        List<String> serialized = Solution.serialize(root);

        TreeNode deserialized = deserialize(new ArrayList<>(serialized));
        printPreOrder(deserialized);
    }
}
