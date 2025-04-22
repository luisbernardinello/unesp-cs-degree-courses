package leetcode.slidingwindow.maxconsecutiveones2;
//https://leetcode.com/problems/max-consecutive-ones-ii/
public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        //base case
        int n = nums.length;
        if(n < 2) return n;
        //define pointers
        int left = 0;
        int right = 0;

        //define maxLen and counter
        int maxLength = 0;
        int counter = 0;
        //find max consecutive ones
        while (right < n) {
            if (nums[right] == 0) {
                counter++;
            }
            //contract window if we don't meet the condition
            while(counter > 1) {
                if(nums[left] == 0) {
                    counter--;
                }
                //otherwise
                left++;
            }
            //update the maxLen
            maxLength = Math.max(maxLength, right - left + 1);
            //move the right pointer one to the right
            right++;

        }
        return maxLength;
    }

    public static void main(String[] args) {

    }
}
