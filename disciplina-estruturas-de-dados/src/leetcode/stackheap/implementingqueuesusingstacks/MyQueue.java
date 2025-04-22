package leetcode.stackheap.implementingqueuesusingstacks;
import java.util.Stack;
//https://leetcode.com/problems/implement-queue-using-stacks/description/
class MyQueue {
    private Stack<Integer> in_stack;
    private Stack<Integer> out_stack;

    public MyQueue() {
        in_stack = new Stack<>();
        out_stack = new Stack<>();
    }

    private void transfer() {
        while (!in_stack.isEmpty()) {
            out_stack.push(in_stack.pop());
        }
    }

    public void push(int x) {
        in_stack.push(x);
    }

    public int pop() {
        if (out_stack.isEmpty()) {
            transfer();
        }
        return out_stack.pop();
    }

    public int peek() {
        if (out_stack.isEmpty()) {
            transfer();
        }
        return out_stack.peek();
    }

    public boolean empty() {
        return in_stack.isEmpty() && out_stack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        System.out.println("Adicionando elementos na fila:");
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println("\nElemento no início da fila (peek): " + queue.peek());

        System.out.println("\nRemovendo elementos da fila:");
        System.out.println("Removido: " + queue.pop());
        System.out.println("Removido: " + queue.pop());

        System.out.println("\nFila está vazia? " + queue.empty());

        queue.push(4);
        System.out.println("Removido: " + queue.pop());

        System.out.println("\nElemento no início da fila (peek): " + queue.peek());

        System.out.println("Removido: " + queue.pop());

        System.out.println("\nFila está vazia? " + queue.empty());
    }
}