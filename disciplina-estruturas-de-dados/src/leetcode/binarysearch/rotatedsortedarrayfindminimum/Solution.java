package leetcode.binarysearch.rotatedsortedarrayfindminimum;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class Solution {
    // fast solution
    static int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while(left + 1 < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }

    static int findMin(int[] nums) {
        int pivot = findPivot(nums);

        if (pivot == -1) {
            return nums[0];
        }

        return nums[pivot + 1];
    }

    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 4, 5, 1, 2 };
        System.out.println(findMin(nums));

    }
}
