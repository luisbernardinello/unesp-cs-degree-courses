package leetcode.graph.nearestexitfromentranceinmaze;
//https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/
import java.util.*;

class Solution {
    private final int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{entrance[0], entrance[1]});

        boolean[][] vis = new boolean[maze.length][maze[0].length];
        vis[entrance[0]][entrance[1]] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];

                if (steps > 0 && (x == 0 || y == 0 || x == maze.length - 1 || y == maze[0].length - 1)) {
                    return steps;
                }

                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX < 0 || newY < 0 || newX >= maze.length || newY >= maze[0].length) {
                        continue;
                    }

                    if (vis[newX][newY] || maze[newX][newY] != '.') {
                        continue;
                    }

                    vis[newX][newY] = true;
                    q.offer(new int[]{newX, newY});
                }
            }

            steps++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] maze = {
                {'+', '+', '.', '+'},
                {'.', '.', '.', '+'},
                {'+', '+', '+', '.'}
        };
        int[] entrance = {1, 2};

        int result = solution.nearestExit(maze, entrance);
        System.out.println("Output: " + result);
    }
}
