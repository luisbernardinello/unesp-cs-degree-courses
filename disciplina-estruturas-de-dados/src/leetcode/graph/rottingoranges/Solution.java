package leetcode.graph.rottingoranges;
//https://leetcode.com/problems/rotting-oranges/description/
import java.util.*;

class Solution {
    private final int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        int minutes = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];

                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length) {
                        continue;
                    }

                    if (grid[newX][newY] == 0 || grid[newX][newY] == 2) {
                        continue;
                    }

                    grid[newX][newY] = 2;
                    count--;
                    q.offer(new int[]{newX, newY});
                }
            }

            if (!q.isEmpty()) {
                minutes++;
            }
        }

        return count == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int result = solution.orangesRotting(grid);
        System.out.println("Output: " + result);
    }
}

