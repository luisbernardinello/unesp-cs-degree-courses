package leetcode.twopointers.squaresofasortedarray;


//https://leetcode.com/problems/squares-of-a-sorted-array/
public class Solution {

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int n = nums.length;
        int right = n - 1;
        int index = n - 1;

        int[] result = new int[n];

        while (0 <= index) {
            int leftNum = nums[left] * nums[left];
            int rightNum = nums[right] * nums[right];
            if (leftNum < rightNum) {
                result[index--] = rightNum;
                right--;
            } else {
                left++;
                result[index--] = leftNum;
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
