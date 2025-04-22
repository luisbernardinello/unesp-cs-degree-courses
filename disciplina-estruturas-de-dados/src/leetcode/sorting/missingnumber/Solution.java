package leetcode.sorting.missingnumber;
//https://leetcode.com/problems/missing-number/
public class Solution {

    // this solution uses cyclic sorting
    static int missingNumber(int[] arr) {
        int i = 0;

        while (i < arr.length) {
            int correct = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[correct]) {
                swap(arr, i , correct);

            } else {
                i++;
            }
        }

        // search for the first missing number
        for(int index = 0; index < arr.length; index++) {
            if(arr[index] != index) {
                return index;
            }
        }

        return arr.length;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 0 ,2, 1};
        System.out.println(missingNumber(arr));
    }
}
