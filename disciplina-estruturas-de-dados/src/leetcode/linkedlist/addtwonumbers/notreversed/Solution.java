package leetcode.linkedlist.addtwonumbers.notreversed;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

////https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-list/
public class Solution {

    static Node addTwoLists(Node l1, Node l2) {
        // Inverter as listas de entrada para processar os números da direita para a esquerda
        l1 = reverse(l1);
        l2 = reverse(l2);

        // Definir o "dummy" Node (nó inicial fictício com valor 0)
        Node dummy = new Node(0);
        Node previous = dummy;
        int carry = 0;

        // Enquanto l1 e l2 não forem nulos
        while (l1 != null || l2 != null) {
            // Obter os valores atuais (ou 0 se a lista já terminou)
            int value1 = l1 != null ? l1.data : 0;
            int value2 = l2 != null ? l2.data : 0;

            // Soma dos valores atuais + carry
            int sum = value1 + value2 + carry;
            carry = 0; // Resetar o carry

            // Se a soma for maior que 9, incrementamos o carry
            if (sum > 9) {
                carry++;
            }

            // Criar um novo nó com o último dígito da soma
            Node currentNode = new Node(sum % 10);

            // Conectar o nó atual ao resultado
            previous.next = currentNode;
            previous = currentNode;

            // Avançar os ponteiros das listas (se não forem nulos)
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        // Se ainda houver carry no final, criar um nó adicional
        if (carry != 0) {
            Node currentNode = new Node(1);
            previous.next = currentNode;
        }

        // Reverter o resultado para colocá-lo na ordem correta
        return reverse(dummy.next);
    }

    // Função para reverter uma lista ligada
    private static Node reverse(Node head) {
        if (head == null || head.next == null) return head;

        Node previous = null;
        Node current = head;

        while (current != null) {
            Node temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        return previous;
    }

    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(0);

        Node head2 = new Node(2);
        head2.next = new Node(0);
        head2.next.next = new Node(0);

        Node result = addTwoLists(head1, head2);

        printList(result);

    }
}
