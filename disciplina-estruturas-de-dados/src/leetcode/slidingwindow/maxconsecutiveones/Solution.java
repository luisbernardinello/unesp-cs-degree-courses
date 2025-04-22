package leetcode.slidingwindow.maxconsecutiveones;
import java.util.*;
//https://leetcode.com/problems/max-consecutive-ones/
public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        //define variables
        int maxLength = 0;
        int counter = 0;

        //iterate all elements in the nums
        for(int num: nums) {
            if(num == 0) {
                counter = 0;
            } else {
                counter++;
                maxLength = Math.max(maxLength, counter);
            }
        }
        // return maxLen
        return maxLength;
    }

    public static void main(String[] args) {

    }
}
