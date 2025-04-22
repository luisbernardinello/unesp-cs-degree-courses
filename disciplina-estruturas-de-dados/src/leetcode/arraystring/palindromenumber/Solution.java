package leetcode.arraystring.palindromenumber;
import java.util.*;
//https://leetcode.com/problems/palindrome-number/description/
public class Solution {

    static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        String number = String.valueOf(x);

        int left = 0;
        int right = number.length() - 1;
        while(left < right) {
            if (number.charAt(left) != number.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));

    }
}
