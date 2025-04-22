package leetcode.slidingwindow.longessubstringkdistinct;
import java.util.*;
//https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
public class Solution {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        //base case
        char[] arr = s.toCharArray();
        int n = arr.length;
        if(k == 0) return 0;

        //define pointers
        int left = 0;
        int right = 0;

        //define table
        Map<Character, Integer> map = new HashMap<>();
        //define maxLen
        int maxLength = 0;

        //find longest substring with k distinct char
        while (right < n) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            //contract window if we don't meet the condition
            while(map.size() > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if(map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }
            //update the maxLen
            maxLength = Math.max(maxLength, right - left + 1);

            //move right pointer one to the right
            right++;
        }
        //return maxLen

        return maxLength;
    }

    public static void main(String[] args) {

    }
}
