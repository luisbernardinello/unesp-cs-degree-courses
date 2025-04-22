package leetcode.binarytree.pathsum3;
import java.util.*;
//https://leetcode.com/problems/path-sum-iii/
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
// uses prefix sum
public class Solution {
    int Counter = 0;
    int target;
    Map<Long, Integer> hashMap = new HashMap<>();

    public int pathSum(TreeNode root, int sum) {
        target = sum;
        hashMap.put(0L, 1);
        dfs(root, 0L);
        return Counter;
    }

    private void dfs(TreeNode root, Long currentSum) {
        if (root == null) return;

        //update the currentSum
        currentSum += root.val;
        //check if the currentSum - target exists in the table
        if(hashMap.containsKey(currentSum - target)) {
            Counter += hashMap.get(currentSum - target);
        }
        //update the table with the currentSum
        hashMap.put(currentSum, hashMap.getOrDefault(currentSum, 0) + 1);
        //traverse left side
        dfs(root.left, currentSum);

        //traverse right side
        dfs(root.right, currentSum);

        //Backtracking: reduces the currentSum count
        hashMap.put(currentSum, hashMap.get(currentSum) - 1);

    }

    public static void main(String[] args) {

    }
}


// O(n^2) time complexity
//class Solution {
//    int Counter = 0;
//    int target;
//    public int pathSum(TreeNode root, int sum) {
//        target = sum;
//        dfs(root, new LinkedList<>());
//        return Counter;
//    }
//
//    private void dfs(TreeNode root, LinkedList<Integer> list){
//        if(root == null) return;
//
//        //add current node's val into the list
//        list.add(root.val);
//
//        //iterate the list backwards to get the currentSum
//        int currentSum = 0;
//        for (int i = list.size() - 1; i >= 0; i--) {
//            currentSum += list.get(i);
//            if(currentSum == target) {
//                Counter++;
//            }
//        }
//
//        //traverse left
//        dfs(root.left, list);
//        //traverse right
//        dfs(root.right, list);
//
//        //backtracking, remove the current node's val of the list
//        list.remove(list.size() - 1);
//
//    }
//}
