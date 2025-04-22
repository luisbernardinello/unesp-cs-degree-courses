package leetcode.stackheap.kthlargestelement;
import java.util.*;
//https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class Solution {

    static int findKthLargest(int[] nums, int k ) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
        }

        while (k > 1) {
            maxHeap.poll();
            k--;
        }

        return maxHeap.peek();
    }

    // sorting an array

//    static int findKthLargest(int[] nums, int k ) {
//        ArrayList<Integer> list = new ArrayList<>();
//
//        for(int numbers : nums) {
//            list.add(numbers);
//        }
//
//        list.sort(Collections.reverseOrder());
//
//        return list.get(k - 1);
//
//
//    }

    // optimal solution
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
//
//        // Add first k elements to the heap
//        for (int i = 0; i < k; i++) {
//            heap.add(nums[i]);
//        }
//
//        // Process the rest of the array
//        for (int i = k; i < nums.length; i++) {
//            if (heap.peek() < nums[i]) {
//                heap.poll();  // Remove the smallest element
//                heap.add(nums[i]);  // Add the current element
//            }
//        }
//
//        return heap.peek();  // The kth largest element
//    }




    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        System.out.println(findKthLargest(arr, 2));
    }
}
