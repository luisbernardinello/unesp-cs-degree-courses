package leetcode.queue.implementingstacksusingqueue;
import java.util.*;
//https://leetcode.com/problems/implement-stack-using-queues/description/
public class MyStack {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public MyStack() {}

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int topElement = queue1.poll();

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    public int top() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int topElement = queue1.peek();

        queue2.add(queue1.poll());

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        System.out.println("Adicionando elementos na pilha:");
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("\nElemento no topo da pilha (top): " + stack.top());

        System.out.println("\nRemovendo elementos da pilha:");
        System.out.println("Removido: " + stack.pop());
        System.out.println("Removido: " + stack.pop());

        System.out.println("\nA pilha está vazia? " + stack.empty());

        System.out.println("Removido: " + stack.pop());

        System.out.println("\nElemento no topo da pilha (top): " + stack.top());

        System.out.println("Removido: " + stack.pop());

        System.out.println("\nA pilha está vazia? " + stack.empty());
    }
}
