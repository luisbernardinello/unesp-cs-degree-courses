package leetcode.binarysearch.findfirstandlastposition;
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class Solution {

    static int[] searchRange(int[] nums, int target) {

        int[] ans = {-1, -1};

        ans[0] = search(nums, target, true);
        if (ans[0] != -1) {
            ans[1] = search(nums, target, false);
        } return ans;
    }

    static int search(int[] nums, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 3, 5, 6};
        int target = 3;
        int[] ans = searchRange(nums, target);
        for (int an : ans) {
            System.out.print(an + " ");
        }

        System.out.print("\n" + ans[0] + " " + ans[1] + "\n");

        System.out.println();

        int[] nums2 = {5 ,7, 7, 8 ,8 ,10};
        int target2 = 10;
        int[] ans2 = searchRange(nums2, target2);
        for (int element : ans2) {
            System.out.print(element + " ");
        }
    }
}
