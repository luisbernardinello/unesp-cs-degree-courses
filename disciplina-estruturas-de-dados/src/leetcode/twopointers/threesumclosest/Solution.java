package leetcode.twopointers.threesumclosest;
import java.util.*;
//https://leetcode.com/problems/3sum-closest/
public class Solution {


    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;

        // Sort array to use two pointers technique
        Arrays.sort(nums);

        // Initialize variables to track the minimum difference and closest sum
        int gap = Integer.MAX_VALUE;  // minimum difference from target
        int ans = 0;                  // sum closest to target

        // Fix first number and use two pointers for remaining numbers
        for(int i = 0; i < n; i++) {
            int left = i + 1;         // pointer after fixed number
            int right = n - 1;        // pointer at end of array

            while (left < right) {
                int currentSum = nums[left] + nums[right] + nums[i];

                // If sum equals target, we found the best possible answer
                if(currentSum == target) {
                    return target;
                }
                // If sum is less than target, increase left pointer to get bigger sum
                else if (currentSum < target) {
                    left++;
                }
                // If sum is greater than target, decrease right pointer to get smaller sum
                else {
                    right--;
                }

                // Calculate and update minimum difference if current sum is closer to target
                int currentGap = Math.abs(currentSum - target);
                if(currentGap < gap) {
                    gap = currentGap;
                    ans = currentSum;
                }
            }
        }

        return ans;  // Return the sum that has smallest difference from target
    }


    public static void main(String[] args) {

    }
}
