package leetcode.binarysearch.searchinrotatedsortedarray;
// https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/

public class Solution {

    static int search(int[] nums, int target) {
        int pivot = findPivot(nums);
//        int pivot = findPivotWithDuplicates(nums);

        // if you did not find a pivot, it means the array is not rotated
        if (pivot == -1) {
            // just do normal binary search
            return binarySearch(nums, target, 0 , nums.length - 1);
        }

        // if pivot is found, you have found 2 asc sorted arrays
        if (nums[pivot] == target) {
            return pivot;
        }

        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }

        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }

    // this will not work in duplicate values
    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static int findPivotWithDuplicates(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if mid is pivot
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // Check if mid-1 is pivot
            if (mid > start && nums[mid - 1] > nums[mid]) {
                return mid - 1;
            }

            // If elements at start, mid, and end are equal
            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                // Check if start is pivot
                if (start < end && nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;

                // Check if end is pivot
                if (end > start && nums[end - 1] > nums[end]) {
                    return end - 1;
                }
                end--;
            }
            // If left side is sorted and pivot is on right side
            else if (nums[start] <= nums[mid] && nums[mid] > nums[end]) {
                start = mid + 1;
            }
            // If right side is sorted and pivot is on left side
            else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(arr, target));
    }

}
