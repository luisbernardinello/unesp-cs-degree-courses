package leetcode.binarysearch.rotatedsortedarray2;
import java.util.*;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii
public class Solution {
// duplicate numbers
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        return Math.min(nums[left], nums[right]);
    }


    public static void main(String[] args) {

    }
}
