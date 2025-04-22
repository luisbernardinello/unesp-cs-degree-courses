package leetcode.hashmapset.pythagoreantriplet;
import java.util.*;

class Solution {
    boolean checkTriplet(int[] arr, int n) {
        // Find maximum element
        int maxEle = 0;
        for (int ele : arr) {
            maxEle = Math.max(maxEle, ele);
        }

        // Create HashSet and store all elements
        HashSet<Integer> set = new HashSet<>();
        for (int ele : arr) {
            set.add(ele);
        }

        // Iterate through possible pairs
        for (int a : set) {
            for (int b : set) {
                // Calculate c using Pythagorean theorem
                int c = (int)Math.sqrt(a * a + b * b);

                // Check if it's a perfect square and within range
                if ((c * c) != (a * a + b * b) || c > maxEle) {
                    continue;
                }

                // Check if c exists in our set
                if (set.contains(c)) {
                    return true;
                }
            }
        }

        return false;
    }
}
