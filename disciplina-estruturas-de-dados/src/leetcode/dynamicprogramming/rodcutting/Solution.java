package leetcode.dynamicprogramming.rodcutting;
import java.util.*;
//https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
public class Solution {

    static int cutRodRecur(int i, int[] price, int[] memo) {

        // Base case
        if (i == 0) return 0;

        // If value is memoized
        if (memo[i - 1] != -1) return memo[i - 1];

        int ans = 0;

        // Find maximum value for each cut.
        // Take value of rod of length j, and
        // recursively find value of rod of
        // length (i-j).
        for (int j = 1; j <= i; j++) {
            ans = Math.max(ans, price[j - 1] + cutRodRecur(i - j, price, memo));
        }

        return memo[i - 1] = ans;
    }

    static int cutRod(int[] price) {
        int n = price.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return cutRodRecur(n, price, memo);
    }

    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(price));
    }
}
