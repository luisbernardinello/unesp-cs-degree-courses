package leetcode.binarysearchtree.convertsortedarraytobinarysearchtree;
import java.util.*;
//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
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
    int[] numsAux;

    public TreeNode sortedArrayToBST(int[] nums) {
        numsAux = nums;
        return buildBST(0, nums.length - 1);
    }

    private TreeNode buildBST(int start, int end) {
        if(start > end) return null;

        int mid = (start + end) / 2;

        TreeNode current = new TreeNode(numsAux[mid]);

        //build left and right
        current.left = buildBST(start, mid - 1);
        current.right = buildBST(mid + 1, end);

        return current;
    }
}
