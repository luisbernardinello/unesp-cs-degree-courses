package leetcode.arraystring.kadanealgorithm.maximumsubarrayprint;
import java.util.*;
//https://www.geeksforgeeks.org/print-the-maximum-subarray-sum/
public class Solution {

    static List<Integer> maxSumSubarray(int[] arr) {

        // start and end of max sum subarray
        int resStart = 0, resEnd = 0;

        // start of current subarray
        int currStart = 0;

        int maxSum = arr[0];
        int maxEnding = arr[0];

        for (int i = 1; i < arr.length; i++) {

            // If starting a new subarray from the current element
            // has greater sum than extending the previous subarray
            if (maxEnding + arr[i] < arr[i]) {

                // Update current subarray sum with current element
                // and start of current subarray with current index
                maxEnding = arr[i];
                currStart = i;
            }
            else {

                // Add current element to current subarray sum
                maxEnding += arr[i];
            }

            // If current subarray sum is greater than maximum subarray sum
            if (maxEnding > maxSum) {

                // Update maximum subarray sum
                maxSum = maxEnding;

                // Update start and end of maximum sum subarray
                resStart = currStart;
                resEnd = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = resStart; i <= resEnd; i++)
            res.add(arr[i]);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        List<Integer> res = maxSumSubarray(arr);

        for (int i = 0; i < res.size(); i++)
            System.out.print(res.get(i) + " ");
    }
}
