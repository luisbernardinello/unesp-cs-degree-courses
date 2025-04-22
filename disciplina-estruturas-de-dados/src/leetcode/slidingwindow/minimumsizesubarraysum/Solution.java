package leetcode.slidingwindow.minimumsizesubarraysum;
import java.util.*;
//https://leetcode.com/problems/minimum-size-subarray-sum/
public class Solution {
    // O(n) using sliding window technique
    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;
        //define pointers
        int left = 0;
        int right = 0;

        //define min & sum
        int min = Integer.MAX_VALUE;
        int sum = 0;

        //sliding window to min sub array len
        while (right < n) {
            //add the current element
            sum += nums[right];
            //contract window
            while (target <= sum) {
                min = Math.min(min, right - left + 1); //current element value or current size of how elements we have in the subarray
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {

    }
}
