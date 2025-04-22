package leetcode.binarytree.boundarytraversal;
import java.util.*;
//https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree

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


    static ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // Passo 1: Adicione a raiz (caso não seja uma folha)
        if (!isLeaf(root)) {
            result.add(root.data);
        }

        // Passo 2: Adicione os nós da borda esquerda
        addLeftBoundary(root.left, result);

        // Passo 3: Adicione todos os nós folha (da esquerda para a direita)
        addLeafNodes(root, result);

        // Passo 4: Adicione os nós da borda direita (na ordem inversa)
        addRightBoundary(root.right, result);

        return result;
    }

    // Função para adicionar a borda esquerda
    static void addLeftBoundary(Node node, ArrayList<Integer> result) {
        while (node != null) {
            if (!isLeaf(node)) {
                result.add(node.data);
            }
            // Prefira o filho esquerdo; se não existir, vá para o direito
            node = (node.left != null) ? node.left : node.right;
        }
    }

    // Função para adicionar todos os nós folha (esquerda para direita)
    static void addLeafNodes(Node node, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }

        if (isLeaf(node)) {
            result.add(node.data);
            return;
        }

        // Recursivamente verifique as subárvores esquerda e direita
        addLeafNodes(node.left, result);
        addLeafNodes(node.right, result);
    }

    // Função para adicionar a borda direita (na ordem inversa)
    static void addRightBoundary(Node node, ArrayList<Integer> result) {
        Stack<Integer> stack = new Stack<>();

        while (node != null) {
            if (!isLeaf(node)) {
                stack.push(node.data); // Armazene os nós para inversão posterior
            }
            // Prefira o filho direito; se não existir, vá para o esquerdo
            node = (node.right != null) ? node.right : node.left;
        }

        // Desempilhe e adicione ao resultado na ordem inversa
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }

    // Função auxiliar para verificar se um nó é folha
    static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }

    public static void main(String[] args) {
        // Exemplo de entrada: Construir a árvore binária
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);

        // Executar a boundary traversal
        ArrayList<Integer> boundary = boundaryTraversal(root);

        // Exibir o resultado
        System.out.println(boundary);
    }

}
