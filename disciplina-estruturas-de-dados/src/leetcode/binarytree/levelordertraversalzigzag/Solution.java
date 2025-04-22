package leetcode.binarytree.levelordertraversalzigzag;
import java.util.*;
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

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


    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeftToRight = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode first = queue.poll();
                if(isLeftToRight){
                    levelList.add(first.val);
                } else {
                    levelList.add(0, first.val); // insert to RighToLeft at first element
                }
                if(first.left != null) {
                    queue.add(first.left);
                }
                if(first.right != null) {
                    queue.add(first.right);
                }

            }
            isLeftToRight = !isLeftToRight;
            result.add(levelList);
        }
        return result;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        /*
                    1
                  /   \
                 2     3
                / \   / \
               4   5 6   7
              / \
             8   9
         */

        System.out.println(zigzagLevelOrder(root));
    }

}
