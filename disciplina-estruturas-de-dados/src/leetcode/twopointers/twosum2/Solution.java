package leetcode.twopointers.twosum2;
import java.util.*;
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class Solution {
    // linear time complexity and constant space complexity
    public int[] twoSum(int[] nums, int target) {
        //define pointers
        int left = 0;
        int n = nums.length;
        int right = n -1;
        //two pointers find the sum
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                return new int[]{left + 1, right + 1}; // array is 0 based, the + 1 returns the elements position
            } else if(sum < target) {
                left++;
            } else {
                right++;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {

    }
}
