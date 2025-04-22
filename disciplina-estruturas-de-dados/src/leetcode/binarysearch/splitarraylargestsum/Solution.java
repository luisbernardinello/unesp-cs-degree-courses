package leetcode.binarysearch.splitarraylargestsum;
//https://leetcode.com/problems/split-array-largest-sum/
public class Solution {

    static int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }

        //binary search

        while (start < end) {
            int mid = start + (end - start) / 2;

            int sum = 0;
            int pieces = 1;
            for(int num: nums) {
                if(sum + num > mid) {
                    // you cannot add this in this subarray
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if(pieces > k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int k = 2;
        System.out.println(splitArray(nums, k));
    }
}