package leetcode.twopointers.removeduplicates;
import java.util.*;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
//O(n) time, O(1) space
public class Solution {

    public int removeDuplicates(int[] nums) {
        //base case
        int n = nums.length;
        if(n < 2) return n;

        //define pointers
        int left = 0;
        int right = 1;

        //remove duplicate in place
        while (right < n) {
            if (nums[left] == nums[right]) {
                right++;
            } else if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
        }
        // return size of the subarray
        return left + 1; // last non duplicate element index + 1
    }

    public static void main(String[] args) {

    }
}
