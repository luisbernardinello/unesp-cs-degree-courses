package leetcode.binarytree.postordertraversal;
import java.util.*;

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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = null;

        while (!stack.isEmpty() || root != null) {
            // Empilhar todos os nós à esquerda
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // Olhar para o topo da pilha sem removê-lo
            TreeNode peekNode = stack.peek();

            // Se o nó à direita não foi visitado, vá para o nó à direita
            if (peekNode.right != null && lastVisited != peekNode.right) {
                root = peekNode.right;
            } else {
                // Se não houver nó à direita ou já foi visitado, processar o nó atual
                result.add(peekNode.val);
                lastVisited = stack.pop();
            }
        }

        return result;
    }


    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversalRecursiveHelper(root, result);
        return result;
    }

    public void postorderTraversalRecursiveHelper(TreeNode root, List<Integer> result) {
        if (root == null) return;

        postorderTraversalRecursiveHelper(root.left, result);
        postorderTraversalRecursiveHelper(root.right, result);
        result.add(root.val);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(18);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(16);
        root.left.right = new TreeNode(19);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(23);

        Solution solution = new Solution();
        System.out.println(solution.postorderTraversal(root));
        System.out.println(solution.postorderTraversalRecursive(root));

    }



}
