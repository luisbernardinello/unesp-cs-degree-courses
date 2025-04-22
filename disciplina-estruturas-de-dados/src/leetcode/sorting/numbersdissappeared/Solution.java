package leetcode.sorting.numbersdissappeared;
import java.util.ArrayList;
import java.util.List;

//// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class Solution {
    // this solution uses cyclic sorting
    static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;

        while (i < nums.length){
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);

            }
            else {
                i++;
            }
        }

        // to find all missing numbers
        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                ans.add(index + 1);
            }
        }

        return ans;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(arr));
    }
}
