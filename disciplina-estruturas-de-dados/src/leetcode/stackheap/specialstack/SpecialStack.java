package leetcode.stackheap.specialstack;

// Java program to implement a stack that supports
// getMinimum() in O(1) time and O(1) extra space using Deque
import java.util.Deque;
import java.util.ArrayDeque;

class SpecialStack {
    Deque<Integer> stack;
    Integer minEle;

    // Constructor
    SpecialStack() {
        stack = new ArrayDeque<>();
    }

    // Prints minimum element of SpecialStack
    void getMin() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Minimum Element in the stack is: " + minEle);
        }
    }

    // Prints top element of SpecialStack
    void peek() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        Integer top = stack.peek();
        System.out.print("Top Most Element is: ");
        if (top < minEle) {
            System.out.println(minEle);
        } else {
            System.out.println(top);
        }
    }

    // Removes the top element from SpecialStack
    void pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.print("Top Most Element Removed: ");
        Integer top = stack.pop();

        // If the popped element was a modified value, update minEle
        if (top < minEle) {
            System.out.println(minEle);
            minEle = 2 * minEle - top;
        } else {
            System.out.println(top);
        }
    }

    // Inserts a new number into SpecialStack
    void push(Integer x) {
        if (stack.isEmpty()) {
            minEle = x;
            stack.push(x);
            System.out.println("Number Inserted: " + x);
        } else {
            if (x < minEle) {
                stack.push(2 * x - minEle);
                minEle = x;
            } else {
                stack.push(x);
            }
            System.out.println("Number Inserted: " + x);
        }
    }


    public static void main(String[] args) {
        SpecialStack s = new SpecialStack();

        // Function calls
        s.push(3);
        s.push(5);
        s.getMin();
        s.push(2);
        s.push(1);
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.peek();
    }
}
