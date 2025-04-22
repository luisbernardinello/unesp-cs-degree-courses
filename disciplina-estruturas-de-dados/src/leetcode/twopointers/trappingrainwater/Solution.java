package leetcode.twopointers.trappingrainwater;
import java.util.*;
//https://leetcode.com/problems/trapping-rain-water/
public class Solution {

    public int trap(int[] height) {
        int n = height.length;
        int max = 0;

        for(int i = 0; i < n; i++) {
            // get the maximum elevation index in the array
            if(height[max] < height[i]) {
                max = i;
            }
        }
        int sum = 0;
        int leftMax = 0;
        for(int i = 0; i < max; i++) {
            if(height[leftMax] < height[i]) {
                leftMax = i;
            }
            sum += Math.min(height[leftMax], height[max]) - height[i];
        }

        int rightMax = height.length - 1;
        for(int i = n - 1; i > max; i--) {
            if(height[rightMax] < height[i]) {
                rightMax = i;
            }
            sum += Math.min(height[rightMax], height[max]) - height[i];
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
