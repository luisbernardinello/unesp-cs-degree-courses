package leetcode.dynamicprogramming.coinchange;
import java.util.*;
//https://www.geeksforgeeks.org/coin-change-dp-7/
public class Solution {

    static int count(int[] coins, int sum) {
        int[][] memo = new int[coins.length][sum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return countRecur(coins, coins.length, sum,memo);
    }

    static int countRecur(int[] coins, int n, int sum, int[][] memo) {

        // If sum is 0 then there is 1 solution
        // (do not include any coin)
        if (sum == 0) return 1;

        // 0 ways in the following two cases
        if (sum < 0 || n == 0) return 0;

        // If the subproblem is previously calculated then
        // simply return the result
        if (memo[n - 1][sum] != -1) return memo[n - 1][sum];

        // count is sum of solutions (i)
        // including coins[n-1] (ii) excluding coins[n-1]
        return memo[n - 1][sum] =
                countRecur(coins, n, sum - coins[n - 1], memo) +
                        countRecur(coins, n - 1, sum, memo);
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 5;
        System.out.println(count(coins, sum));
    }


}
