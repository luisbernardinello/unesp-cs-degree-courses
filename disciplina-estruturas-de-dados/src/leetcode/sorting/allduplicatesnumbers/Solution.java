package leetcode.sorting.allduplicatesnumbers;
import java.util.*;
//https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
public class Solution {

    // this solution uses cyclic sort
    static List<Integer> findDuplicates(int[] nums) {
        int i = 0;

        while(i < nums.length) {
            int correct = nums[i] - 1;

            if(nums[i] != nums[correct]) {
                swap(nums, i, correct);
            }
            else {
                i++;
            }
        }

        List<Integer> resultList = new ArrayList<Integer>();
        for(int index = 0; index < nums.length; index++) {
            if(nums[index] != index + 1) {
                resultList.add(nums[index]);
            }
        }



        return resultList;
    }


    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(arr));
    }
}
