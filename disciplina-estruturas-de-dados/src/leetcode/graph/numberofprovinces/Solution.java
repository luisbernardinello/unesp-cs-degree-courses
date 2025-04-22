package leetcode.graph.numberofprovinces;

import java.util.*;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i])
                continue;

            ans++;
            Queue<Integer> q = new LinkedList<>();

            q.offer(i);
            vis[i] = true;

            while (!q.isEmpty()) {
                int curr = q.poll();

                for (int c = 0; c < n; c++) {
                    if (isConnected[curr][c] == 0 || vis[c])
                        continue;

                    vis[c] = true;
                    q.offer(c);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        int result = solution.findCircleNum(isConnected);
        System.out.println("Output: " + result);
    }
}

