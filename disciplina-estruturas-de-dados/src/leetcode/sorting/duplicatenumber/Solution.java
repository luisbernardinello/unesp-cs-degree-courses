package leetcode.sorting.duplicatenumber;

//// https://leetcode.com/problems/find-the-duplicate-number/
public class Solution {

    static int findDuplicate(int[] arr) {
        int i = 0;

        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                // Se chegamos aqui, significa que:
                // 1. Ou o número está na posição correta (arr[i] == i + 1)
                // 2. Ou encontramos um número duplicado (arr[i] == arr[correct] mas i != correct)
                if (i != correct) {
                    return arr[i];
                }
                i++;
            }
        }

        return -1;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(findDuplicate(arr));
    }
}
