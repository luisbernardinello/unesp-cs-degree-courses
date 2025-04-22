package leetcode.twopointers.containerwithmostwater;
import java.util.*;
//https://leetcode.com/problems/container-with-most-water/
public class Solution {

    public int maxArea(int[] height) {
        int n = height.length;

        //define pointers
        int left = 0;
        int right = n - 1;

        //define max area
        int maxArea = Integer.MIN_VALUE;

        //find max area
        while (left < right) {
            int area = (right - left) * Math.min(height[right], height[left]);
            maxArea = Math.max(maxArea, area);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;

    }

    public static void main(String[] args) {


        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        Solution solution = new Solution();
        System.out.println(solution.maxArea(height));

    }
}
