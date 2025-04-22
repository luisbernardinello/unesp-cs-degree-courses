package leetcode.stackheap.stockspanproblem;
import java.util.*;

//https://www.geeksforgeeks.org/the-stock-span-problem/
//https://leetcode.com/problems/online-stock-span/description/
class Solution {
    // Function to calculate the span of stock's price for all n days.
    public ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> span = new ArrayList<>(); // Result list
        Deque<int[]> stack = new ArrayDeque<>(); // Stack to store price-span pairs

        for (int price : arr) {
            int count = 1; // Span starts as 1 for the current price

            // Pop elements from the stack if their price is less than or equal to the current price
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                count += stack.pop()[1]; // Accumulate the span of the popped element
            }

            // Push the current price and its span onto the stack
            stack.push(new int[] {price, count});

            // Add the computed span to the result list
            span.add(count);
        }

        return span;
    }



}

