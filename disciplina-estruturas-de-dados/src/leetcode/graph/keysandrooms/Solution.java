package leetcode.graph.keysandrooms;

import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        Arrays.fill(vis, false);

        vis[0] = true;

        Queue<Integer> q = new LinkedList<>();

        q.offer(0);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int i = 0; i < rooms.get(curr).size(); i++) {
                int nextRoom = rooms.get(curr).get(i);
                if (vis[nextRoom])
                    continue;

                q.offer(nextRoom);
                vis[nextRoom] = true;
            }
        }

        for (boolean visited : vis) {
            if (!visited)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(Collections.emptyList());


        boolean result = solution.canVisitAllRooms(rooms);
        System.out.println("Output: " + result);
    }
}
