package leetcode.binarytree.levelordertraversal2;
import java.util.*;
//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }

    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        /*
                3
               / \
              9  20
                 / \
                15  7
        */

        System.out.println(solution.levelOrderBottom(root1));

        TreeNode root2 = new TreeNode(1);

        /*
                1
        */

        System.out.println(solution.levelOrderBottom(root2));

        TreeNode root3 = null;

        System.out.println(solution.levelOrderBottom(root3));
    }

}
