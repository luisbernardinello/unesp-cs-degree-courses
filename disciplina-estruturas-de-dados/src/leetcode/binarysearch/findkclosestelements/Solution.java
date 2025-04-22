package leetcode.binarysearch.findkclosestelements;
import java.util.*;
//https://leetcode.com/problems/find-k-closest-elements
public class Solution {
    // binary search and sliding window. O(log^(n-k)) time complexity O(k) space complexity

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(x - arr[mid] > arr[mid + k] - x) { //// the distance between left and x is bigger than the distance between x and right
                // The distance between x and the element at mid is greater than
                // the distance between x and the element at mid + k.
                // This means the closer elements are on the right side of mid,
                // so we move the left pointer to mid + 1.
                left = mid + 1;
            } else { //// the distance between left and x is smaller or equal the distance between x and right
                // The distance between x and the element at mid is less than or equal
                // to the distance between x and the element at mid + k.
                // This means the closer elements are on the left side of mid or
                // include mid itself, so we move the right pointer to mid.
                right = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;

    }

    public static void main(String[] args) {

    }
}
