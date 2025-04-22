package leetcode.twopointers.threesum;
import java.util.*;
//https://leetcode.com/problems/3sum/
// gives the sum of zero
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        //base case
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if(n < 3) return result;

        // sort the array
        Arrays.sort(nums);

        //iterate the array
        for(int i = 0; i < n; i++) {
            if(i != 0 && nums[i] == nums[i - 1]) // to not have duplicates combinations
                continue;

            // define the pointers
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if(currentSum == 0) {
                    List<Integer> subList = new LinkedList<>();
                    subList.add(nums[i]);
                    subList.add(nums[left]);
                    subList.add(nums[right]);
                    result.add(subList);

                    left++;
                    right--;

                    // to not get duplicate numbers
                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                    // small sum
                } else if(currentSum < 0) {
                    left++;
                    // too much big
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution solution = new Solution();
        System.out.println(solution.threeSum(nums));
    }
}
