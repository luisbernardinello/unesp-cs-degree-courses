package leetcode.graph.reorderroutes;

import java.util.*;

class Solution {
    private int ans = 0;

    private void dfs(int node, List<List<int[]>> graph, boolean[] vis) {
        vis[node] = true;

        for (int[] neighbor : graph.get(node)) {
            int nextNode = neighbor[0];
            int cost = neighbor[1];

            if (vis[nextNode])
                continue;

            ans += cost;
            dfs(nextNode, graph, vis);
        }
    }

    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            graph.get(from).add(new int[] {to, 1});
            graph.get(to).add(new int[] {from, 0});
        }

        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);

        dfs(0, graph, vis);

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 6;
        int[][] connections = {
                {0, 1},
                {1, 3},
                {2, 3},
                {4, 0},
                {4, 5}
        };

        int result = solution.minReorder(n, connections);
        System.out.println("Output: " + result);
    }
}
