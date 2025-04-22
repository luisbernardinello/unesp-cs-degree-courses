package leetcode.binarysearch.rotationcountrotatedsortedarray;
import java.util.*;
//https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
public class Solution {

    static int findKRotation(List<Integer> arr) {
        int pivot = findPivot(arr);
        return pivot + 1;
    }

    static int findPivot(List<Integer> arr) {
        int start = 0;
        int end = arr.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr.get(mid) > arr.get(mid + 1)) {
                return mid;
            }
            if (mid > start && arr.get(mid) < arr.get(mid - 1)) {
                return mid - 1;
            }
            if (arr.get(mid) <= arr.get(start)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int countRotations(int[] arr) {
        int pivot = findPivotWithDuplicates(arr);
        return pivot + 1;
    }

    // use this when arr contains duplicates
    static int findPivotWithDuplicates(int[] arr) {
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

            // if elements at middle, start, end are equal then just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // check whether end is pivot
                if (arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // left side is sorted, so pivot should be in right
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(4, 5, 6, 7, 0, 1, 2));
        int[] dpArray = {2, 2, 2, 3, 1, 2};
        System.out.println(findKRotation(arr));
        System.out.println(countRotations(dpArray));
    }
}
