package leetcode.slidingwindow.maxconsecutiveones3;
//https://leetcode.com/problems/max-consecutive-ones-iii
public class Solution {

    public int longestOnes(int[] nums, int k) {
        //base case
        int n = nums.length;
        if(n < 2 && k > 0) return n;
        //define the pointers
        int left = 0;
        int right = 0;
        //define the maxLen and counter
        int maxLength = 0;
        int counter = 0;
        //iterate and find the max consecutive ones
        while (right < n) {
            if(nums[right] == 0) {
                counter++;
            }
            //contract our window if we don't meet the condition
            while(counter > k) {
                if(nums[left] == 0) {
                    counter--;
                }
                //otherwise
                left++;
            }
            //update the maxLength
            maxLength = Math.max(maxLength, right - left + 1);
            //increment the right pointer
            right++;;
        }
        return maxLength;
    }

    public static void main(String[] args) {

    }
}
