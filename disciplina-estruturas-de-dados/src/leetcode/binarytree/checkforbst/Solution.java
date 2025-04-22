package leetcode.binarytree.checkforbst;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
public class Solution {

    // Wrapper function to call the recursive function
    static boolean isBST(Node root) {

        // we need to make one size array to hold previous value
        ArrayList<Integer> prev = new ArrayList<>();
        prev.add(Integer.MIN_VALUE);  // Inicializa com o menor valor possível
        return isValidBST(root, prev);
    }


    static boolean isValidBST(Node root, ArrayList<Integer> prev) {
        if (root == null) return true;

        // Check the left subtree
        boolean isLeftBST = isValidBST(root.left, prev);
        if (!isLeftBST) return false; // Se a subárvore esquerda não é BST, retorne falso

        // Check current node value against previous value
        if (prev.get(0) >= root.data) return false;

        // Update previous value to current node's value
        prev.set(0, root.data);

        // Check the right subtree
        boolean isRightBST = isValidBST(root.right, prev);
        return isRightBST; // Retorne o resultado da subárvore direita
    }




    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        System.out.println(isBST(root));
    }
}
