package leetcode.slidingwindow.longestsubstringtwodistinct;
import java.util.*;
//https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
public class Solution {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        //base case
        char[] arr = s.toCharArray();
        int n = arr.length;
        if (n < 3) return n;

        //define pointers
        int left = 0;
        int right = 0;

        //define table
        Map<Character, Integer> map = new HashMap<>();

        //define maxLen
        int maxLength = 0;

        //find the max len substring 2 distinct char
        while (right < n) {

            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            //contract our window if we don't meet the condition
            while (map.size() > 2) {
                //remove the element that the left pointer is pointing
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {

    }
}
