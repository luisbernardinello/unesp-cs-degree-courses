package leetcode.twopointers.partitionlabels;
import java.util.*;
//https://leetcode.com/problems/partition-labels/
public class Solution {

    public List<Integer> partitionLabels(String S) {
        int n = S.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(S.charAt(i), i);
        }

        // set the pointers
        int left = 0;
        int right = 0;
        List<Integer> result = new ArrayList<>();

        for (int index = 0; index < n; index++) {
            char current = S.charAt(index);
            right = Math.max(right, map.get(current));
            if(right == index) {
                int size = right - left + 1;
                result.add(size);
                left = right + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        Solution solution = new Solution();
        System.out.println(solution.partitionLabels(s));
    }
}
