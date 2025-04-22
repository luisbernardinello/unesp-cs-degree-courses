package leetcode.linearsearch.findnumberswithevennumber;

public class Solution {
    static int findNumbers(int[] nums) {

        int count = 0;

        for (int num: nums) {
            if (even(num)){
                count++;
            }
        }

        return count;
    }

    static boolean even(int num) {
        int numberOfDigits = digits(num);

        return numberOfDigits % 2 == 0;

    }

    static int digits(int num) {
        if (num < 0) {
            num = num * -1;
        }

        return (int)(Math.log10(num)) +1;
    }

    // static int digits(int num) {
    //     int count = 0;

    //     if (num < 0) {
    //         num = num * -1;
    //     }

    //     if (num == 0) {
    //         return 1;
    //     }

    //     while (num >0) {
    //         count++;
    //         num = num/10;
    //     }
    //     return count;

    // }

    public static void main(String[] args) {
        int[] nums = {1 ,2 ,4 ,5, 6, 7, 8};

        int ans = findNumbers(nums);

        System.out.println(ans);

    }



}
