package leetcode.twopointers.threesumsmaller;
import java.util.*;
//https://leetcode.com/problems/3sum-smaller
// three sum which is less than the target number
public class Solution {

    public int threeSumSmaller(int[] nums, int target) {
        int n = nums.length;

        // Sort array to use two pointers technique
        Arrays.sort(nums);

        // Counter for valid triplets (triplets with sum < target)
        int counter = 0;

        // Fix first number and use two pointers for the other two numbers
        for (int i = 0; i < n; i++) {
            int left = i + 1;      // pointer after fixed number
            int right = n - 1;     // pointer at end of array

            while(left < right) {
                int currentSum = nums[left] + nums[right] + nums[i];

                // If sum is less than target, we found valid triplets
                if(currentSum < target) {
                    // Add count of all possible triplets with current i and left
                    // Since array is sorted, all numbers between left and right
                    // will also form valid triplets
                    counter += right - left;
                    left++;
                }
                // If sum is >= target, we need a smaller sum
                else {
                    right--;
                }
            }
        }
        return counter;
    }

    public int threeSumSmallerBruteForce(int[] nums, int target) {
        int n = nums.length;
        int counter = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum < target) {
                        counter++;
                        list.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    }
                }
            }
        }
        for(List<Integer> element: list) {
            System.out.println(element);
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        int target = 2;
        Solution solution = new Solution();
        System.out.println(solution.threeSumSmaller(nums, 2));

    }
}
