package leetcode.twopointers.sortcolors;

//https://leetcode.com/problems/sort-colors/
public class Solution {

    public void sortColors(int[] nums) {
        int n = nums.length;
        //define pointers
        int left = 0;
        int right = n - 1;
        int current = 0;
        //while cur <= R
        while (current <= right) {
            if (nums[current] == 2) {
                swap(nums, current, right);
                right--;
            } else if(nums[current] == 1) {
                current++;
            } else {
                swap(nums, current, left);
                left++;
                current++;
            }
        }
    }

    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }

    public static void main(String[] args) {

    }
}
