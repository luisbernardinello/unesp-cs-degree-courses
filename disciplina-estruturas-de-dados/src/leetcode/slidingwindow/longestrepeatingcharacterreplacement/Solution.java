package leetcode.slidingwindow.longestrepeatingcharacterreplacement;
import java.util.*;
//https://leetcode.com/problems/longest-repeating-character-replacement
public class Solution {

    public int characterReplacement(String s, int k) {
        //base case
        char[] chars = s.toCharArray();
        int n = chars.length;

        //define the pointers
        int left = 0;
        int right = 0;

        //define the table
        Map<Character, Integer> map = new HashMap<>();

        //define the maxLen and our mostFreq
        int mostFreq = 0;
        int maxLength = 0;

        // find longest repeating character replacement
        while(right < n) {
           //expand the window
            map.put(chars[right], map.getOrDefault(chars[right], 0) + 1);
            mostFreq = Math.max(mostFreq, map.get(chars[right]));

            //shrink the window if we need to replace more than k chars
            if((right - left + 1) - mostFreq > k) {
                map.put(chars[left], map.get(chars[left]) - 1);
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
