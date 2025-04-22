package leetcode.stackheap.nextgreaterelement;
import java.util.*;
//https://www.geeksforgeeks.org/next-greater-element/
public class Solution {

    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }

        for (int i = n -1; i >= 0; i--) {

            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }

            if (!stack.isEmpty()){
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        ArrayList<Integer> finalResult = new ArrayList<>();
        for (int value : result) {
            finalResult.add(value);

        }
        return finalResult;


    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(solution.nextLargerElement(arr));
    }
}
