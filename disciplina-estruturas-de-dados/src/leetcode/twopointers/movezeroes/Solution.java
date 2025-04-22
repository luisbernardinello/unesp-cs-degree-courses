package leetcode.twopointers.movezeroes;
import java.util.*;
//https://leetcode.com/problems/move-zeroes/
public class Solution {

    public void moveZeroes(int[] nums) {
        //base case
        int n = nums.length;
        if(n < 2) return;

        //define pointers
        int left = 0;
        int right = 1;

        //move zeroes to the back
        while (right < n) {
            if(nums[left] == 0){
                if(nums[right] !=0){
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
                else{
                    right++;
                }
            }
            else{
                left++;
                right++;
            }
        }
    }


    public static void main(String[] args) {

    }
}
