package leetcode.twopointers.removeduplicates2;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
//O(n) time, O(1) space
public class Solution {

    public int removeDuplicates(int[] nums) {
        //base case
        int n = nums.length;
        if(n < 3) return n;
        //define pointers and counter
        int left = 0;
        int right = 1;
        int counter = 0;
        //remove duplicates
        while(right < n) {
            if(nums[left] == nums[right] && counter == 0) {
                nums[++left] = nums[right++];
                counter++;
            } else if (nums[left] == nums[right] && counter == 1) {
                right++;
            } else if (nums[left] != nums[right]) {
                nums[++left] = nums[right++];
                counter = 0;
            }
        }

        //return length
        return left + 1;
    }

    public static void main(String[] args) {

    }
}
