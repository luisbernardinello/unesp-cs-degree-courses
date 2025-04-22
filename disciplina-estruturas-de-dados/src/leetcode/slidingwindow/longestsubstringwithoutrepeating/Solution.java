package leetcode.slidingwindow.longestsubstringwithoutrepeating;
import java.util.*;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        //base case
        char[] arr = s.toCharArray();
        int n = arr.length;
        if (n < 2) return n;

        //define pointers
        int left = 0;
        int right = 0;

        //define table
        Map<Character, Integer> map = new HashMap<>();

        //define max len
        int maxLength = 0;

        //find longest substring
        while (right < n) {
            //adding current element
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            //check if we meet the condition
            while(map.size() != right - left + 1) {
                map.put(arr[left], map.get(arr[left] ) - 1);
                if(map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }
            //update the maxLen
            maxLength = Math.max(maxLength, right - left + 1);

            //move the right pointer one to the right
            right++;
        }

        //return max len
        return maxLength;
    }

    public static void main(String[] args) {

    }
}
