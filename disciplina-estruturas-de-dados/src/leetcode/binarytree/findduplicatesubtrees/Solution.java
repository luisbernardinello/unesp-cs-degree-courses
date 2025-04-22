package leetcode.binarytree.findduplicatesubtrees;
import java.util.*;
//https://leetcode.com/problems/find-duplicate-subtrees/
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

public class Solution {
    final String NOTREE = "X";
    //Keep track of visited subtree string key
    Set<String> visited = new HashSet<>();
    //Keep track of duplicate subtree
    Map<String , TreeNode> result = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        postOrderTraversal(root);
        return new LinkedList<>(result.values());
    }

    private String postOrderTraversal(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        String leftSubtree = NOTREE, rightSubtree = NOTREE;

        //Traverse the left
        if(node.left != null) {
            leftSubtree = postOrderTraversal(node.left);
        }

        // Traverse the right
        if(node.right != null) {
            rightSubtree = postOrderTraversal(node.right);
        }

        // Current Node
        sb.append(node.val);

        // Build the remaining nodes in the subtree
        sb.append(",");
        sb.append(leftSubtree);
        sb.append(",");
        sb.append(rightSubtree);

        String currentSubtree = sb.toString();
        saveDuplicateSubtree(node, currentSubtree);
        visited.add(currentSubtree);
        return currentSubtree;
    }

    private void saveDuplicateSubtree(TreeNode node, String key) {
        if (visited.contains(key)) {
            result.put(key, node);
        }
    }


    public static void main(String[] args) {

    }
}
